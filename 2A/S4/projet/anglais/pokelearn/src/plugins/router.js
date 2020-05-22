import Vue from 'vue'
import Router from 'vue-router'
import Battle from "@/components/Battle";
import NewQuestion from "@/components/NewQuestion";
import Accueil from "@/components/Accueil";
import Login from "@/components/Login"

// Page content

// Fallback page

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: {name: 'accueil'}
        },
        {
            path: "/home",
            component: Accueil,
            name: "accueil"
        },
        {
            path: '/battle',
            component: Battle,
            name: "battle"
        },
        {
            path: '/newQuestion',
            component: NewQuestion,
            name: "newQuestion",
            beforeEnter: (to, from, next) => {
                if (localStorage.getItem("authenticated") && parseInt(localStorage.getItem("authenticated")) > Date.now() - 1000 * 60 * 60) {
                    next();
                } else {
                    next('login');
                }
            }
        },
        {
            path: '/login',
            component: Login,
            name: "login"
        },
    ]
})
