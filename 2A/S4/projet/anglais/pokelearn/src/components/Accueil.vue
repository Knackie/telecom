<template>
    <div>
        <v-row justify="center">
          <v-col md="6" sm="12">
                <v-card>
                    <v-card-title>
                      Trainers information
                    </v-card-title>
                    <v-divider></v-divider>
                    <v-card-text>
                        <v-img
                                :src="trainerImg"
                                max-height="300px"
                                contain
                                transition="slide-x-transition"
                        ></v-img>
                        <v-divider></v-divider>
                        Hey Trainers,<br>
                      We need your help. Some of our worst enemy come to catch us. If they win, the world as we know
                      actually could be lost forever. Please help us to beat them and save the world.<br>
                      In order to fight them, you will be answered questions. For each of them, inflict damages on your
                      opponent by choosing the correct answer.
                      But keep in mind that you will take damages from your opponent if your answer is false.
                        <div class="my-2 text-center">
                          <v-btn color="primary" :to="{name : 'battle'}">Start battling</v-btn>
                        </div>
                    </v-card-text>
                </v-card>
            </v-col>
        </v-row>
     </div>
</template>

<script>
    import trainerImg from '../assets/pokeTrainer3.png'
    export default {
        name: "Accueil",
        data: function() {
            return {
                trainerImg: trainerImg
            }
        },
        methods: {

        }
    }
</script>

<style scoped>

</style>
