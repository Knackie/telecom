<template>
  <div>
    <v-card>
      <v-form
          ref="form"
          v-model="valid"
          :lazy-validation="true"
      >
        <v-card-title>Question creation form</v-card-title>
        <v-divider></v-divider>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col>
                <v-text-field
                    v-model="question.Question"
                    :rules="questionRules"
                    label="Question"
                    required
                ></v-text-field>
              </v-col>
            </v-row>
            <v-radio-group
                v-model="question.Reponse"
                :rules="radioRules"
            >
              <v-row v-for="i in [0,1]" :key="i">
                <v-col v-for="j in [i*2,i*2+1]" :key="j" cols="12" md="6">
                  <v-text-field
                      v-model="question.Reponses[j]"
                      :rules="reponseRules"
                      :label="'Answer '+(j+1)"
                      required
                  ></v-text-field>
                  <v-radio
                      :label="question.Reponse === j ? 'Good Answer' : 'Bad Answer' "
                      :color="'success'"
                      :value="j"
                  ></v-radio>
                </v-col>
              </v-row>
            </v-radio-group>

          </v-container>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-actions>
          <v-dialog
              v-model="dialog"
              max-width="500"
          >
            <template v-slot:activator="{ on }">
              <v-btn
                  :disabled="!valid"
                  color="success"
                  class="mr-4"
                  v-on="on"
              >
                Validate
              </v-btn>
            </template>

            <v-card>
              <v-card-title>
                Are you sure you want to create this new question ?
              </v-card-title>

              <v-divider></v-divider>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                    :disabled="!valid"
                    color="success"
                    class="mr-4"
                    @click="checkForm"
                >
                  Validate
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
          <v-btn
              color="error"
              class="mr-4"
              @click="reset"
          >
            Reset Form
          </v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
    <v-snackbar
        v-model="snackbar"
    >
      {{ text_notification }}
      <v-btn
          color="green"
          text
          @click="snackbar = false"
      >
        Close
      </v-btn>
    </v-snackbar>
  </div>
</template>

<script>
    import 'firebase/database'
    import firebase from "firebase";

    let config = {
        apiKey: "AIzaSyC5WBXgSz4QG0XPuVrMYN0eYNbtDtindGg",
        authDomain: "pokelearning.firebaseapp.com",
        databaseURL: "https://pokelearning.firebaseio.com/",
        storageBucket: "pokelearning.appspot.com"
    };

    if (!firebase.apps.length) {
        firebase.initializeApp(config);
    }
    export const db = firebase.app().database();

    export default {
        name: "NewQuestion.vue",
        components: {},
        data: function () {
            return {
                question: {
                    id: -1,
                    Question: "",
                    Reponses: [],
                    Reponse: -1
                },
                questionRules: [
                    v => !!v || 'Question is required',
                ],
                reponseRules: [
                    v => !!v || 'Answer is required',
                ],
                radioRules: [
                    v => v <= 3 && v >= 0 || 'An answer must be choosen'
                ],
                valid: false,
                dialog: false,
                text_notification: "",
                snackbar: false,
            }
        },
        methods: {
            reset() {
                this.$refs.form.reset()
            },
            checkForm: function () {
                if (this.$refs.form.validate()) {
                    firebase.database().ref('Questions').push({
                        Question: this.question.Question,
                        Reponses: this.question.Reponses,
                        Reponse: this.question.Reponse
                    });
                    this.text_notification = "Success ! Question created";
                    this.dialog = false;
                    this.reset();
                    this.snackbar = true;
                }
            }
        }
    }
</script>

<style scoped>

</style>
