<template>
  <v-table>
    <TableHead/>
    <TableBody :data="receivedData"/>
  </v-table>
</template>

<script>
import TableHead from "@/components/TableHead";
import TableBody from "@/components/TableBody";
export default {
  components: {TableHead,TableBody},
  props: {
    data:null
  },
  watch: {
    data(newValue, oldValue) {
      this.receivedData=newValue
    },
  },
  data () {
    return {
      receivedData:null,
    }
  },
}
</script>
