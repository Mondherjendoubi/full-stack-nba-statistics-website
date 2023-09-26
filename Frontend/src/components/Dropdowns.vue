<template>
  <div class="text-center">
    <v-menu :location="location">
      <template v-slot:activator="{ props }">
        <v-btn
          variant="outlined"
          color="primary"
          dark
          v-bind="props"
        >
          {{ title }}
        </v-btn>
      </template>

      <v-card
        class="mx-auto"
        :width="width ? width :'100'"
      >

        <v-list>
          <v-list-item
            v-for="(item, i) in itemsList"
            :key="i"
          >
              <v-checkbox
                @click="this.emitSpecialEvent(item.title)"
                :v-model="item['checkbox' + i]"
                :label="item.title"
                :model-value="true"
                color="red"
                value="red"
                hide-details
                >
              </v-checkbox>
          </v-list-item>
        </v-list>
      </v-card>
    </v-menu>
  </div>
</template>

<script>
export default {
  props: {
    title: String ,
    itemsList: Array,
    width: String,
  },

  created() {
    console.log(this.itemsList)
    console.log("herevruv")
    console.log(this.itemsList[0]['checkbox0'])
  },
  methods: {
    emitSpecialEvent(team) {
      console.log(team)
      this.$emit('drop-down-click', team);
    },
  },

};
</script>
