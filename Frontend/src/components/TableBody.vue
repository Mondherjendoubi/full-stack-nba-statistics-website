<template>
  <tbody>
  <tr v-if="players" v-for="item in players" :key="item.id">
    <td>{{ item.playerName }}</td>
    <td>{{ item.position }}</td>
    <td>{{ item.age }}</td>
    <td>{{ item.totalRebounds }}</td>
    <td>{{ item.assists }}</td>
    <td>{{ item.steals }}</td>
    <td>{{ item.gamesPlayed }}</td>
    <td>{{ item.fieldGoalPercentage }}</td>
    <td>{{item.threePointPercentage }}</td>
  </tr>
  </tbody>
</template>

<script >
import DropDowns from "@/components/DropDowns.vue";

export default {
  props: {
    data:null
  },
  watch: {
    data(newValue, oldValue) {
      const jsonObjectArray = newValue.map((proxy) => {
        return JSON.parse(JSON.stringify(proxy));
      });
      this.players=jsonObjectArray
    },
  },
  data () {
    return {
      players:null,
    }
  },
}
</script>



