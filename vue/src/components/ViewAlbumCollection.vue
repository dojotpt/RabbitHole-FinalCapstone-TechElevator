<template>
    <div class="blurred-background"></div>
    <div class="my-library-container">
        <div id="album-container">
            <div class="card-container">
                   
                
                <!-- <div class="back-to-browse">
                   
                    <h3 class="back-to-browse-text">Browse Collections</h3>
                    
                </div> -->
                <div id="browse-collections" class="card">
                    
          <a href="/collections" class="card-text">Browse Collections</a>
        </div>



                <div class="card" v-for="album in albums" :key="album.id">
                    <router-link :to="`/album/${album.albumId}`">
                        <img class="card-img" v-bind:src="album.albumImage" />
                    </router-link>
                    <div class="text-box">
                        
                        <h3>{{ album.title }}</h3>
                        <p>{{ album.artist }}</p>
                        <p>{{ album.genre }}</p>
                    </div>
                    <div class="button-container">
                        <router-link :to="`/album/${album.albumId}/edit`">
                            <button id="edit-button"><img src="@/images/edit_.png"></button>
                        </router-link>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import MyLibraryService from '../services/MyLibraryService';

export default {
    computed: {
        albums() {
            return this.$store.state.myLibrary.albums;
        }
    },
    created() {
        const collectionId = this.$route.params.collection_id;
        if (collectionId) {
            MyLibraryService.getCollection(collectionId)
                .then((response) => {
                    const myLibrary = response.data;
                    this.$store.commit('SET_LIBRARY', myLibrary);
                })
                .catch(error => {
                    console.error(error);
                });
        } else {
            console.error("No collection ID found in the route parameters.");
        }
    }
}
</script>
<style scoped>
#browse-collections{ 
  display: flex;
  border: 2PX solid #78C0A8;;
  border-radius: 7PX;
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  background-position-y: -30px;
  justify-self: self-end;
  margin-right: 12px;
  color: white;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  font-size: 60px;
 }
 .card-text {
  font-family: "Caprasimo",sans-serif;
  font-weight: 400; 
  width: 100%;
  height: 100%;
  backdrop-filter: blur(5px);
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
  font-size: 20px;
  text-decoration: none;
  color:  #FCEBB6;
}
h3 {
    font-family: "Caprasimo", sans-serif;
    color: #78C0A8;
    font-size: medium;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
.card {
    background-color: rgba(94, 65, 36, 0.5);
    border: 2px solid #78C0A8;
    border-radius: 10px;
    width: 250px;
    margin: 20px;
}
.back-to-browse{
display: flex;
  
  
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  
  
  
  
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
   border: 2px solid #78C0A8;
   border-radius: 10px;
   width: 250px;
   margin: 20px;
   
}
.back-to-browse-text{
  font-family: "Caprasimo",sans-serif;
  font-weight: 300; 
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
  font-size: 20px;
  
  color:  #FCEBB6;

}


.my-library-container {
    display: flex;
    flex-direction: column;
    background-color: rgba(94, 65, 36, 0.5);
    border-radius: 10px;
    width: 80%;
    height: 80%;
    align-items: center;
    margin: auto;
    justify-content: center;
    list-style-type: none;
}

.card-container {
    max-height: 80vh;
    overflow-y: scroll;
    scrollbar-color: #F07818 rgb(94, 65, 36);
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    list-style-type: none;
}





p {
    font-family: 'Comic Sans MS', 'Chalkboard SE', 'Comic Neue', sans-serif;
    font-size: 16px;
    color: #FCEBB6;
}

.text-box p {
    padding-left: 20px;
    height: 15px;
}

.button-container {
    display: flex;
    justify-content: space-evenly;
    margin: 20px;
}

button {
    background-color: #FCEBB6;
}

.card-img {
    width: 100%;
    border-radius: 2.5%;
    height: 250px;
}

.card img {
    width: 100%;
    border-radius: 2.5%;
}

#sample-album-img {
    height: 250px;
    border-radius: 2.5%;
}

.blurred-background {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-image: linear-gradient(hwb(28 5% 89% / 0.247), hwb(29 9% 81% / 0.5)), url('@/images/recordcollection2.jpeg');
    background-size: cover;
    background-position: center;
    filter: blur(4px);
    z-index: -1;
}

.text-box p {
    padding-left: 20px;
}

.button-container {
    display: flex;
    justify-content: space-evenly;
    margin: 20px;
}

.add-record-button {
    display: flex;
    justify-content: center;
}

#add-record-button-img {
    display: flex;
    width: 25px;
    justify-content: center;
}

#edit-button img {
    width: 25px;
}

#delete-button img {
    width: 25px;
}
</style>