<template>
    <div id="collection-container">
      <div class="background"></div>
      <div class="collection">
                    <router-link class="add" :to="`/addcollections`">
                        <img id="sample-album-img" src="@/images/addrecordcollectioncard.png" />
                    </router-link>
                   
                    <div class="text-box">
                        <h2>Add a Collection</h2>
                        
                        <p>Description</p>
                        <div class="button-container">
                        <router-link :to="`/addcollections`">
                            <button class="add-record-button"><img id="add-record-button-img"
                                    src="@/images/sign-plus-square-fill_.png"></button>
                        </router-link>
                    </div>
                    </div>
                   
                </div>
      <div v-for="collection in collections" :key="collection.id" class="collection">
        <router-link class="link" :to="`/albumcollection/${collection.collection_id}`">
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
    data() {
        return {
            collections: []

        }
    },
    methods: {
      getCollections() {
        this.collections = this.$store.state.myCollections.collections;
      }
    },
    created() {
      CollectionService.getCollectionByUserId(this.$store.state.user.id)
        .then((response) => {
           const myCollections = response.data;
          this.$store.commit('SET_MY_COLLECTIONS',myCollections);
          this.getCollections();
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
.collection {
  background-color: black;
  display: flex;
  width: 1100px;
  border-radius: 10px;
  border: 2px solid;
  justify-content: center;
  align-items: center;
}
.link{
  display : flex;
margin-left: -33%;
}
.add{
  display : flex;
margin-left: -5%;
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
    padding-bottom: 2%;
    height: 96%;

  }
  
  button {
    
    background-color: #FCEBB6;
}
.text-box {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
    
}
.button-container {
    display: flex;
    align-self: end;
    justify-self: center;
}
#add-record-button-img {
display: flex;
height: 30px;
justify-self: center;
   
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
    
  }
  </style>
  