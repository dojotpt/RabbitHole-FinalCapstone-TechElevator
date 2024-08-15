<template>
    <div class="blurred-background"></div>
    <div class="my-library-container">
        <div id="album-container">
            <div class="card-container">
                
                <div class="card" v-for="album in albums" :key="album.id">
                    <img class="card-img" v-bind:src="album.albumImage" />
                    <div class="text-box">
                        
                        <h3>{{ album.title }}</h3>
                        <p>{{ album.artist }}</p>
                        <p>{{ album.genre }}</p>
                    </div>
                    <div class="button-container">
                        <button id="edit-button"><img src="@/images/edit_.png"></button>
                        <button id="delete-button"><img src="@/images/trash_.png"></button>
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

.card {
    background-color: rgba(94, 65, 36, 0.5);
    border: 2px solid #78C0A8;
    border-radius: 10px;
    width: 250px;
    margin: 20px;
}

h3 {
    font-family: "Caprasimo", sans-serif;
    color: #78C0A8;
    font-size: medium;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
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