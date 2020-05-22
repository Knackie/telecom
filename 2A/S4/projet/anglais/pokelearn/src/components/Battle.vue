<template>
  <div>
    <v-row>
      <v-col cols="6">
        <v-card>
          <v-card-title>
            {{enemy.name}}
          </v-card-title>
          <v-card-subtitle>
            Level : {{enemy.level}}
          </v-card-subtitle>
          <v-card-text>
            <v-progress-linear
                color="light-blue"
                height="15"
                :value="enemy.life"
                rounded
            >
              <template v-slot="{ value }">
                <strong>{{ value }}/100</strong>
              </template>
            </v-progress-linear>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="6">
        <v-img
            :src="trainerImg"
            max-height="300px"
            contain
            v-if="imgDresser"
            transition="slide-x-transition"
        ></v-img>
        <v-slide-x-transition v-else>
          <span>{{question.Question}}</span>
        </v-slide-x-transition>
      </v-col>
    </v-row>
    <v-row>
      <v-col>

      </v-col>
      <v-col>
        <v-card>
          <v-card-title>
            {{ally.name}}
          </v-card-title>
          <v-card-subtitle>
            Level : {{ally.level}}
          </v-card-subtitle>
          <v-card-text>
            <v-progress-linear
                color="light-blue"
                height="15"
                :value="ally.life"
                rounded
            >
              <template v-slot="{ value }">
                <strong>{{ value }}/100</strong>
              </template>
            </v-progress-linear>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-card>
          <v-row>
            <v-col>
              <v-card-text v-if="imgDresser">
                A wild {{enemy.name}} appears
              </v-card-text>
              <v-card-text v-else>
                Answer that question !
              </v-card-text>
            </v-col>
            <v-col>
              <v-card-actions>
                <v-container v-if="imgDresser">
                  <v-row>
                    <v-col>
                      <v-btn @click="imgDresser = ! imgDresser">
                        Attack
                      </v-btn>
                    </v-col>
                    <v-col>
                      <v-dialog
                          v-model="dialogItems"
                          max-width="500"
                      >
                        <template v-slot:activator="{ on }">
                          <v-btn v-on="on">
                            Objects
                          </v-btn>
                        </template>
                        <v-card>
                          <v-card-title>
                            Available objects
                          </v-card-title>
                          <v-divider></v-divider>
                          <v-card-text>
                            <v-list>
                              <v-list-item
                                  v-for="item in items"
                                  :key="item.type"
                                  @click="use(item)"
                              >
                                <v-list-item-avatar>
                                  <v-img :src="itemImg(item.type)"></v-img>
                                </v-list-item-avatar>

                                <v-list-item-content>
                                  <v-list-item-title v-text="itemText(item.type)"></v-list-item-title>
                                </v-list-item-content>

                                <v-list-item-icon>
                                  <v-tooltip bottom>
                                    <template v-slot:activator="{ on }">
                                      <v-icon v-on="on">mdi-information</v-icon>
                                    </template>
                                    <span>{{itemInfo(item.type)}}</span>
                                  </v-tooltip>
                                </v-list-item-icon>

                                <v-list-item-action>
                                  <v-btn icon>
                                    {{item.quantity}}
                                  </v-btn>
                                </v-list-item-action>

                              </v-list-item>
                            </v-list>
                          </v-card-text>
                          <v-card-actions>

                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col>
                      <v-dialog
                          v-model="dialogHelp"
                          max-width="500"
                      >
                        <template v-slot:activator="{ on }">
                          <v-btn v-on="on">
                            Help
                          </v-btn>
                        </template>
                        <v-card>
                          <v-card-title>
                            Trainers help
                          </v-card-title>
                          <v-divider></v-divider>
                          <v-card-text>If you decide to attack, you will be asked a question with 4 answers.
                            <br>only one answer is correct per question.
                            <br>If you choose the correct answer, your enemy will lose Healt Points (HP), otherwise you will lose HP.
                            <br>If your enemy loses all his Health point, you win. If you lose all your HP, you
                            lose the game.
                            <br> <b>Now trainers, go fight your enenmy and defeat him to be rewarded with a victory.</b>
                          </v-card-text>
                          <v-divider></v-divider>
                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                color="primary"
                                text
                                @click="dialogHelp = false"
                            >
                              Back
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </v-col>
                    <v-col>
                      <v-dialog
                          v-model="dialog"
                          max-width="500"
                      >
                        <template v-slot:activator="{ on }">
                          <v-btn v-on="on">
                            Flee
                          </v-btn>
                        </template>

                        <v-card>
                          <v-card-title>
                            Do you really want to leave ?
                          </v-card-title>

                          <v-divider></v-divider>

                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                color="error"
                                text
                                to="accueil"
                            >
                              Quit
                            </v-btn>
                            <v-btn
                                color="primary"
                                text
                                @click="dialog = false"
                            >
                              Back
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
                    </v-col>
                  </v-row>
                </v-container>

                <v-container v-else>
                  <v-row v-for="i in [0,1]" :key="i">
                    <v-col v-for="j in [i*2,i*2+1]" :key="j">
                      <v-btn
                          @click="verifReponse(j)"
                          v-if="question.Reponses[j]"
                      >
                        {{question.Reponses[j]}}
                      </v-btn>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-actions>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <template>
      <div class="text-center">
        <v-dialog
            v-model="endDialog"
            width="500"
        >
          <v-card>
            <v-card-title>
              {{dialogTitle}}
            </v-card-title>

            <v-card-text>
              {{dialogText}}
            </v-card-text>

            <v-divider></v-divider>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                  color="succes"
                  text
                  @click="nouvellePartie"
              >
                New Game
              </v-btn>
              <v-btn
                  color="error"
                  text
                  to="accueil"
              >
                Stop
              </v-btn>

            </v-card-actions>
          </v-card>
        </v-dialog>
      </div>
    </template>
  </div>
</template>

<script>
    import firebase from 'firebase/app'
    import 'firebase/database'
    import trainerImg from '../assets/pokeTrainer2.png'
    import {ItemQuantity, TYPE_POTION, TYPE_REPEL} from "../assets/classes.ts";
    import repelImg from '../assets/repel.png'
    import potionImg from '../assets/potion.png'


    let config = {
        apiKey: "AIzaSyC5WBXgSz4QG0XPuVrMYN0eYNbtDtindGg",
        authDomain: "pokelearning.firebaseapp.com",
        databaseURL: "https://pokelearning.firebaseio.com/",
        storageBucket: "pokelearning.appspot.com",
    };

    if (!firebase.apps.length) {
        firebase.initializeApp(config);
    }
    export const db = firebase.app().database();

    export default {
        name: "Battle.vue",
        data: function () {
            return {
                endDialog: false,
                imgDresser: true,
                dialog: false,
                dialogHelp: false,
                dialogItems: false,
                trainerImg: trainerImg,
                enemy: {
                    name: "Trainer",
                    life: 100,
                    level: 5
                },
                ally: {
                    name: "Anonymous",
                    life: 100,
                    level: 5
                },
                question: {
                    id: -1,
                    Question: "",
                    Reponses: [],
                    Reponse: -1
                },
                dialogTitle: "",
                dialogText: ""
            }
        },
        asyncComputed: {
            items: async function () {
                if (this.$indexedDb) {
                    let nbItems = await this.$indexedDb.count("items");
                    if (nbItems === 0) {
                        this.$indexedDb.add("items", new ItemQuantity(TYPE_POTION));
                        this.$indexedDb.add("items", new ItemQuantity(TYPE_REPEL));
                    }
                    let items = await this.$indexedDb.getAll('items');
                    return items.filter(item => item.quantity > 0);
                }
            },
        },
        computed: {
            list_questions: async function () {
                return await this.$indexedDb.getAll("questions");
            }
        },
        mounted: function () {
            this.changerQuestion();
        }
        ,
        methods: {
            changerQuestion: async function () {
                let list_questions = await this.list_questions;
                if (list_questions.length === 0) {
                    list_questions = await this.$indexedDb.getAll("questions");
                }
                list_questions.sort(function (a, b) {
                    return 0.5 - Math.random()
                });
                this.question = list_questions.pop();
            },
            verifReponse: function (reponse) {
                if (this.question.Reponse === reponse) {
                    this.reductionPVEnnemy();
                    this.changerQuestion()
                } else {
                    this.reductionPVAllie()
                }
            },
            victoire: function () {
                this.dialogTitle = "Victory";
                this.dialogText = "You won this game";
                this.endDialog = true;
            }
            ,
            defaite: function () {
                this.dialogTitle = "Try again";
                this.dialogText = "You lost this game";
                this.endDialog = true;
            }
            ,
            nouvellePartie: function () {
                location.reload()
            }
            ,
            reductionPVAllie: function () {
                this.ally.life -= 10;
                if (this.ally.life <= 0) {
                    this.ally.life = 0;
                    this.defaite();
                }
            }
            ,
            reductionPVEnnemy: function () {
                this.enemy.life -= 30;
                if (this.enemy.life <= 0) {
                    this.enemy.life = 0;
                    this.victoire()
                }
            },
            itemImg: function (type) {
                switch (type) {
                    case TYPE_REPEL:
                        return repelImg;
                    case TYPE_POTION:
                        return potionImg;
                }
            },
            itemText: function (type) {
                switch (type) {
                    case TYPE_REPEL:
                        return "Repel";
                    case TYPE_POTION:
                        return "Potion";
                }
            },
            itemInfo: function (type) {
                switch (type) {
                    case TYPE_REPEL:
                        return "Allow you to withdraw one of the answers";
                    case TYPE_POTION:
                        return "Heal you of a few HP";
                }
            },
            use: async function (item) {
                this.dialogItems = false;
                switch (item.type) {
                    case TYPE_REPEL:
                        let tmp = this.question.Reponses[this.question.Reponse];
                        this.question.Reponses.splice(this.question.Reponse, 1);
                        this.question.Reponses.sort(function (a, b) {
                            return 0.5 - Math.random()
                        });
                        this.question.Reponses.splice(0, 1);
                        this.question.Reponses.push(tmp);
                        this.question.Reponses.sort(function (a, b) {
                            return 0.5 - Math.random()
                        });
                        this.question.Reponse = this.question.Reponses.indexOf(tmp);
                        this.imgDresser = false;
                        break;
                    case TYPE_POTION:
                        this.ally.life += 20;
                }
                let itemupdate = await this.$indexedDb.get("items", item.type);
                itemupdate.quantity -= 1;
                this.$indexedDb.put("items", itemupdate);
            }
        }
    }
</script>

<style scoped>

</style>
