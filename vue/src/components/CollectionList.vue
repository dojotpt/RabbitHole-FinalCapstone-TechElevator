

<template>
    <div>
    <ul>
      <li v-for="collection in collections" :key="collection.id" class="collection">
        {{ collection.name }}
      </li>
    </ul>
  </div>
  </template>
  
  <script>
import CollectionService from '../services/CollectionService';

  
  
  export default {

    computed: {
      collections() {
        return this.$store.state.collections
      }
    },

    created() {
      CollectionService.getAllCollections()
      .then((response) => {
        const results = response.data;
        this.$store.commit('SET_COLLECTIONS', results.collections);        
      })
      .catch(error => {
        console.error(error);
      });
    }
  }
  
  </script >
  
  <style scoped>
 .collection {
  border-bottom: 1px solid #f2f2f2;
}
.collection:last-child {
  border-bottom: 0px;
}
.collection a {
  display: block;
  padding: 10px 20px;
}
.collection a:link, .topic a:visited {
  color: blue;
  text-decoration: none;
}
.collection a:hover {
  background-color: #f2f2f2;
  cursor: pointer;
}
  



  </style>
  


    
    

