<template>
  <v-app>
    <v-navigation-drawer
        app
        v-model="menubar"
    >
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="title">
            Pokelearning
          </v-list-item-title>
          <v-list-item-subtitle>
            How to learn English
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>
      <v-list-item
          v-for="link in links"
          :key="link.text"
          :to="{name: link.link}"
          link
      >
        <v-list-item-icon>
          <v-icon>{{link.icon}}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ link.text }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-navigation-drawer>

    <v-app-bar app>
      <v-app-bar-nav-icon @click="menubar = !menubar"></v-app-bar-nav-icon>

      <v-toolbar-title>Pokelearning</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>
    </v-app-bar>

    <!-- Sizes your content based upon application components -->
    <v-content>

      <!-- Provides the application the proper gutter -->
      <v-container fluid>

        <!-- If using vue-router -->
        <router-view></router-view>
      </v-container>
    </v-content>

  </v-app>
</template>

<script>
    import Battle from './components/Battle.vue'

    export default {
        name: 'app',
        components: {
            Battle
        },
        data: function () {
            return {
                menubar: false,
                links: [
                    {
                        text: "Home page",
                        link: "accueil",
                        icon: "mdi-home"
                    },
                    {
                        text: "Play",
                        link: "battle",
                        icon: "mdi-gamepad-variant"
                    },
                    {
                        text: "Administration",
                        link: "newQuestion",
                        icon: "mdi-settings-outline"
                    }
                ]
            }
        },
    }
</script>

<style>
</style>
