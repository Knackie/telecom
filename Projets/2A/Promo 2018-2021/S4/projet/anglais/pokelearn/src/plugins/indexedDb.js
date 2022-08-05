import Vue from 'vue';
import IdbPlugin from './IDBPlugin/IdbPlugin';

Vue.use(IdbPlugin, {
    databaseVersion: 2,
    tables: [
        {name: "questions", params: {keyPath: "id"}},
        {name: "items", params: {keyPath: "type"}},
    ]
});
