<template>
  <div class="d-flex">
      <DropDowns @drop-down-click="this.handleTeamCustomEvent " width="200" title="All teams" :itemsList="nbaTeams" class="ma-2 pa-2"/>
      <DropDowns @drop-down-click="this.handleAgeCustomEvent"  width="200" title="Age" :itemsList="ages" class="ma-2 pa-2"/>
      <DropDowns @drop-down-click="this.handlePositionCustomEvent" width="200" title="Position" :itemsList="positions" class="ma-2 pa-2"/>
  </div>

</template>

<script >
import DropDowns from "@/components/DropDowns.vue";
import {NBA_TEAMS_LIST} from '../constants/teams.ts';
import {AGES_LIST} from '../constants/ages';
import {BASKETBALL_POSITIONS} from "@/constants/positions";
import axios from "axios";

export default {
  components: {
    DropDowns
  },
  data() {
    return {
        nbaTeams: NBA_TEAMS_LIST,
        ages:AGES_LIST,
        positions:BASKETBALL_POSITIONS,
        items: [
          {
            title: 'ATL',
            value: 1,
          },
          {
            title: 'BOS',
            value: 2,
          },
          {
            title: 'CHA',
            value: 3,
          },
        ],
    };
  },
  methods: {
    handleTeamCustomEvent(teamName) {
      this.fetchData('team',teamName)
    },
    handleAgeCustomEvent(age) {
      this.fetchData('age',age)
    },
    handlePositionCustomEvent(position) {
      this.fetchData('positions',position)
    },
    fetchData(param1,param2){
      const apiUrl= `http://localhost:8080/api/v1/players/${param1}/${param2}`;

      // Make a GET request to the API
      console.log(apiUrl)
      axios.get(apiUrl)
        .then((response) => {
          this.responseData = response.data;
          this.$emit(`${param1}-players-event`, this.responseData);
        })
        .catch((error) => {
          // Handle any errors here
          console.error('Error fetching data:', error);
        });
    }
  },
  created() {

    console.log(this.t)

  }
};
</script>
