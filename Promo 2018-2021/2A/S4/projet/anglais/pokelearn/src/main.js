import Vue from 'vue'
import { rtdbPlugin } from 'vuefire'
import App from './App.vue'
import router from '@/plugins/router'
import vuetify from '@/plugins/vuetify' // path to vuetify export
import '@/plugins/indexedDb'
import './assets/style/custom.scss'
import '@/plugins/asyncComputed'
import indexedDb from "@/plugins/IDBPlugin/database";


if ('serviceWorker' in navigator) {
  window.addEventListener('load', function() {
    navigator.serviceWorker.register('/sw.js');
  });
}
(async () => {
  await indexedDb.init();
  Vue.config.productionTip = false;
  Vue.use(rtdbPlugin);

  new Vue({
    render: h => h(App),
    router,
    vuetify
  }).$mount('#app')
})();


