<template>
  <div id="collection-container">
    <div class="background"></div>
    <div v-for="collection in collections" :key="collection.id" class="collection">
      
      <router-link :to="`/albumcollection/${collection.collection_id}`">
        <img :src="collection.albumUrl" alt="" class="album-image">
        <img src="@/images/recordcollectioncard.png" alt="Album Collection Card" class="record-image">
      </router-link>
      
      <div class="text-box">
        
        <h2>{{ collection.title }}</h2>
        <p>{{ collection.description }}</p>
        
      </div>
      <div class="button-container"> </div>
      
      
    </div>
    
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
</script>


<style scoped>

.album-image {
  position: relative;
  top: 0px;
  left: 34%;
  width:310px;
  z-index: 1; /* Ensure this image is on top */
  
}




#collection-container {
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  width: 80%;
  overflow: auto;
  justify-content: space-evenly;
  border: none;
  gap: 30px;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.6);
  border-radius: 5px;
}


.background {
  background-color: black;
  opacity: 80%;
}

p {
  height: 40px;
  width: 400px;
  font-size: 19px;
 margin-left: 23px;

}

h2 {
  font-weight: 300;
  font-size: 45px;
}

img {
  display: flex;
 
  height: 270px;
  margin: 20px;
}

.collection {
  background-color: black;
  display: flex;
  width: 1100px;
  border-radius: 10px;
  border: 2px solid;
  justify-content: center;
  align-items: center;
}
a{
  display : flex;
margin-left: -33%;
}

</style>
