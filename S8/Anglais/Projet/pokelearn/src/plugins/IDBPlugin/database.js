if (!window.indexedDB) {
    window.alert("Votre navigateur ne supporte pas une version stable d'IndexedDB. Quelques fonctionnalités ne seront pas disponibles.")
}

export default {
    databaseVersion: 2,
    dbName: "",
    tables: [
        {name: "questions", params: {keyPath: "id"}},
        {name: "items", params: {keyPath: "type"}},
    ],
    db: null,
    init: function () {
        let superthis = this;
        return new Promise((resolve, reject) => {
            if(this.db === null){
                let request = indexedDB.open(superthis.dbName, superthis.databaseVersion);
                request.onerror = function (event) {
                    console.log(event)
                    reject(`error opening database ${event.target.errorCode}`)
                };
                request.onupgradeneeded = function (event) {
                    for (let i in superthis.tables) {
                        let table = superthis.tables[i];
                        let db = event.target.result;
                        if (!db.objectStoreNames.contains(table.name)) {
                            let objectStore = db.createObjectStore(table.name, table.params);
                        }
                    }
                };
                request.onsuccess = function (event) {
                    superthis.db = event.target.result;
                    resolve(event.target.result)
                }
            }else{
                resolve(this.db)
            }

        })
    },
    count: function (tableName) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête");
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName]).objectStore(tableName).count()
                pr.onsuccess = function (event) {
                    resolve(event.target.result)
                };
                pr.onerror = function (event) {
                    reject(`error counting data ${event.target.errorCode}`)
                }
            }
        })
    },
    add: function (tableName, object) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName], "readwrite").objectStore(tableName).add(object);
                pr.onsuccess = function () {
                    resolve()
                }
                pr.onerror = function (event) {
                    reject(`error adding data ${event.target.errorCode}`)
                }
            }
        })
    },
    delete: function (tableName, primaryKey) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName], "readwrite").objectStore(tableName).delete(primaryKey);
                pr.onsuccess = function () {
                    resolve()
                }
                pr.onerror = function (event) {
                    reject(`error deleting data ${event.target.errorCode}`)
                }
            }
        })
    },
    get: function (tableName, primaryKey) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName]).objectStore(tableName).get(primaryKey);
                pr.onsuccess = function (event) {
                    resolve(event.target.result)
                }
                pr.onerror = function (event) {
                    reject(`error getting data ${event.target.errorCode}`)
                }
            }
        })
    },
    getAll: function (tableName) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName]).objectStore(tableName).openCursor();
                let tab = [];
                pr.onsuccess = function (event) {
                    let cursor = event.target.result;
                    if(cursor){
                        tab.push(cursor.value)
                        cursor.continue();
                    }else {
                        resolve(tab)
                    }

                }
                pr.onerror = function (event) {
                    reject(`error getting cursor ${event.target.errorCode}`)
                }
            }
        })
    },
    clear: function (tableName) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName], "readwrite").objectStore(tableName).clear();
                pr.onsuccess = function (event) {
                    resolve()
                }
                pr.onerror = function (event) {
                    reject(`error clearing data ${event.target.errorCode}`)
                }
            }
        })
    },
    put: function (tableName, object) {
        return new Promise((resolve, reject) => {
            if (this.db === null) {
                console.log("La base de données n'est pas prête")
                reject("La base de données n'est pas prête");
            } else {
                let pr = this.db.transaction([tableName], "readwrite").objectStore(tableName).put(object);
                pr.onsuccess = function (event) {
                    resolve()
                }
                pr.onerror = function (event) {
                    reject(`error putting data ${event.target.errorCode}`)
                }
            }
        })
    },
}
