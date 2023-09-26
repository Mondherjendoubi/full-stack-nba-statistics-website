<template>
  <div>
    <v-pagination
      @click="this.emitSpecialEvent($event)"
      :v-model="currentPage"
      :length="totalPages"
      prev-icon="mdi-menu-left"
      next-icon="mdi-menu-right"
      :total-visible="8"
    ></v-pagination>
  </div>
</template>

<script>


export default {
  props:{
    players:null,
    currentPage: null,
    totalPages:null
  },
  watch : {
    currentPage(newValue,oldValue){
      console.log("current value changed from " + oldValue + " to " + newValue);
      if(newValue===this.totalPages){
         const buttonElement = document.querySelector('.mdi-menu-right');
         if (buttonElement) {
           buttonElement.style.pointerEvents = 'none';
         }

       }
    }
  },
  data() {
    return {

    };
  },
  methods: {
    emitSpecialEvent(event) {
      const buttonWithMdiMenuRight = document.querySelector('li button span.v-btn__content i.mdi-menu-right');
      const buttonWithMdiMenuLeft = document.querySelector('li button span.v-btn__content i.mdi-menu-left');
      if(event.target===buttonWithMdiMenuRight){
        console.log(this.currentPage+1)
        this.$emit('pagination-event', this.currentPage + 1);
      } else if(event.target===buttonWithMdiMenuLeft){
        console.log(this.currentPage)
        this.$emit('pagination-event', this.currentPage - 1 );
      } else{
        console.log(event.target.textContent)
        this.$emit('pagination-event', event.target.textContent);
      }
    },
  },
};
</script>
