<template>
  <div id="home-view"> 
    <div class="blurred-background"></div>
    <collection-list :collections="collections"/>
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import CollectionService from '../services/CollectionService';

export default {
  components: {
    CollectionList
  },
  data() {
    return {
      collections: [],
      allCollections: [], // To store the complete list of collections
    };
  },
  methods: {
    async getCollections(){
      try {
        const response = await CollectionService.list();
        this.collections = response.data;
        this.allCollections = response.data; // Store the complete list
      } catch (error) {
        console.error(error);
      }
    },
    filterCollections(filterValue) {
      if (filterValue) {
        this.collections = this.allCollections.filter(collection => 
          collection.title.includes(filterValue) || collection.description.includes(filterValue)
        );
      } else {
        this.collections = this.allCollections; // Reset to all collections if no filter
      }
    }
  },
  // created() {
  //   getCollections();
  //   // this.getCollections();
  //   // this.$root.$on('filter', this.filterCollections);
  // },
  beforeDestroy() {
    this.$root.$off('filter', this.filterCollections);
  }
}
</script>

<style scoped>
.home {
  padding: 20px;
}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('src/images/record store.jpeg');
  background-size: cover;
  background-position: center;
  filter: blur(5px);
  z-index: -1;
}
</style>
