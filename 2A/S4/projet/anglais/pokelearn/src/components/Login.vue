<template>
    <div>
        <v-card>
            <v-form
                ref="form"
                v-model=loginValidate
                :lazy-validation="true"
            >
                <v-card-title>Authentication</v-card-title>
                <v-divider></v-divider>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col>
                                <v-text-field
                                        v-model="loginInformation.username"
                                        :rules="loginRules"
                                        label="Login"
                                        required
                                ></v-text-field>
                            </v-col>
                        </v-row>
                        <v-row>
                            <v-col>
                                <v-text-field
                                        v-model="loginInformation.password"
                                        :rules="passwordRules"
                                        :type="showPassword ? 'text' : 'password'"
                                        :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                        label="Password"
                                        @click:append="showPassword = !showPassword"
                                        required
                                ></v-text-field>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-card-text>
                <v-divider></v-divider>
                <v-card-actions>
                    <v-btn
                            color="success"
                            class="mr-4"
                            @click="login"
                    >
                        Login
                    </v-btn>
                </v-card-actions>
            </v-form>
        </v-card>
    </div>
</template>

<script>
    export default {
        name: 'Login.vue',
        components:{},
        data : function() {
            return {
                loginInformation : {
                    username: "",
                    password: ""
                },
                loginValidate : false,
                loginRules: [
                    v => !!v || 'Login is required',
                    v => v === "admin" || 'Login is incorrect',
                ],
                passwordRules: [
                    v => !!v || 'Password is required',
                    v => v === "admin" || 'Password is incorrect',
                ],
                showPassword: false,
            }
        },
        methods: {
            login() {
                if (this.$refs.form.validate()) {
                    localStorage.setItem("authenticated", Date.now() + "");
                        this.$router.replace({ name: "newQuestion" });
                }
            }
        }
    }
</script>

<style scoped>
</style>
