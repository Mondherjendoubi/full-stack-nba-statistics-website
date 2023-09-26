<template>
  <v-app>
    <v-checkbox
      :label="`Checkbox`"
    ></v-checkbox>
    <default-bar @most-points-event="this.handleCustomEvent" />
    <v-btn class="ma-3" variant="text">
      League Roster
    </v-btn>
    <DropdownsMenu @team-players-event="this.handleCustomEvent"
                   @age-players-event="this.handleCustomEvent"
                   @positions-players-event="this.handleCustomEvent"
                   class="ml-400" />
    <Table :data="receivedDataSlice"/>
  </v-app>
  <pagination @pagination-event="this.handlePaginationEvent" :currentPage="currentPage"  :totalPages="totalPages" />
</template>


<script >
  import DefaultBar from './AppBar.vue'
  import DefaultView from './View.vue'
  import Table from "@/components/Table.vue";
  import DropdownsMenu from "@/components/DropDownsMenu.vue";
  import Pagination from "../../components/Pagination";
  export default {

    components: {Pagination,DefaultBar,DefaultView,Table,DropdownsMenu},
    data () {
      return {
        receivedData: null,
        currentPage: 1,
        itemsPerPage: 10,
        totalPages:1,
        receivedDataSlice: null,
      }
    },
    watch:{
      currentPage(newValue){

      }
    },
    methods: {
      findTotalPages(data) {
        if(data){
          return Math.ceil(data.length / this.itemsPerPage);
        }
        return 1
      },
      handleCustomEvent(data) {
        this.currentPage= 1;
        this.itemsPerPage= 10;
        this.totalPages=1;
        this.receivedData=data;
        this.totalPages=this.findTotalPages(data);
        const startIndex = (this.currentPage - 1) * this.itemsPerPage;
        const endIndex = startIndex + this.itemsPerPage;
        this.receivedDataSlice=data.slice(startIndex, endIndex)
      },
      handlePaginationEvent(data){
        console.log("bruuuv")
        this.currentPage=data
        const startIndex = (this.currentPage - 1) * this.itemsPerPage;
        const endIndex = startIndex + this.itemsPerPage;
        this.receivedDataSlice=this.receivedData.slice(startIndex, endIndex)
      }
    },
  }
</script>

