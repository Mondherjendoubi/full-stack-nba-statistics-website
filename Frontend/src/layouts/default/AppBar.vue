<template>
  <v-card>
    <v-tabs
      bg-color="deep-purple-darken-4"
      center-active
    >
      <v-tab>Home</v-tab>
      <v-tab @click="this.fetchData('most-points')">Points</v-tab>
      <v-tab @click="this.fetchData('most-assists')">Assists</v-tab>
      <v-tab @click="this.fetchData('most-rebounds')">Rebounds</v-tab>
      <v-tab @click="this.fetchData('most-steals')">Steals</v-tab>
      <v-tab @click="this.fetchData('most-3pt')">3pt Made</v-tab>
      <v-tab @click="this.fetchData('most-2pt')" >2pt Made</v-tab>
    </v-tabs>
  </v-card>
</template>

<script>
import axios from "axios";
export default {

  data() {
    return {
      responseData: null,
    };
  },
  methods: {
    fetchData(query) {
      // Your API endpoint URL
      const apiUrl= `http://localhost:8080/api/v1/players/${query}`;

      // Make a GET request to the API
      axios.get(apiUrl)
        .then((response) => {
          // Handle the successful response here
          this.responseData = response.data;
          this.$emit('most-points-event', this.responseData);
        })
        .catch((error) => {
          // Handle any errors here
          console.error('Error fetching data:', error);
        });
    },
  },

};
</script>


