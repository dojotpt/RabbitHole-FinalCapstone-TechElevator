<template>

  <div id="collection-container">
    <div class="button-container">
      <a href="albumcollection" class="card-text">View Collection 1</a>
    </div>
    <div class="background"></div>
    <div v-for="collection in collections" :key="collection.id" class="collection">
      <img class="img" src="src/images/recordcollectioncard.png" alt="">
      <div class="text-box">
        <h2>{{ collection.name }}</h2>
        <p>{{ collection.description }}</p>
      </div>

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
#collection-container {
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  width: 65%;
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
  width: 350px;
  font-size: 17px;

}

h2 {
  font-weight: 300;

}

.img {
  display: flex;
  width: 300px;
  height: 150px;
  margin: 15px;
}

.collection {
  background-color: black;
  display: flex;
  width: 750px;
  border-radius: 10px;
  border: 2px solid;




}
</style>
