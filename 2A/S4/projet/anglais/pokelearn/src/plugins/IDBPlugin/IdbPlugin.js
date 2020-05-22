import indexedDb from "./database"
import firebase from 'firebase/app'

export default {
    async install(Vue, options) {
        indexedDb.databaseVersion = options.databaseVersion | 1;
        indexedDb.dbName = options.dbName || "defaultDbName";
        indexedDb.tables = options.tables;
        firebase.app().database().ref('Questions').on('value', function (num_question) {
            let questions = num_question.val();
            for (let key in questions) {
                let question = questions[key];
                if (question instanceof Object) {
                    question.id = key;
                    indexedDb.put("questions", question)
                }
            }
        });

        Vue.prototype.$indexedDb = indexedDb;
    }
}
