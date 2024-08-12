<template>
    <div class="blurred-background"></div>
    <div class="card-container">
        <img src="@/images/sample_album.jpg" />
        <div class="card">
            <div class="card" v-for="album in albums" :key="album.id">
                <img class="card-img" v-bind:src="album.albumImage" />
                <div id="text-box">
                    <h1>{{ album.title }}</h1>
                    <h3>{{ album.artist }}</h3>
                    <h3>{{ album.genre }}</h3>
                    <p>{{ album.yearReleased }}</p>
                    <p>{{ album.notes }}</p>
                </div>
                <div class="button-container">
                    <button id="edit-button"><img src="@/images/edit_.png"></button>
                    <button id="delete-button"><img src="@/images/trash_.png"></button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import MyLibraryService from '../services/MyLibraryService.js';

export default {
    computed: {
        albums() {
            return this.$store.state.myLibrary.album_id;
        }
    },
    created() {
        const albumId = this.$route.params.album_id;
        if (albumId) {
            MyLibraryService.getAlbum(albumId)
                .then((response) => {
                    const album = response.data;
                    this.$store.commit('SET_ALBUM', album);
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
.card-container {
    max-height: 80vh;
    overflow-y: scroll;
    scrollbar-color: #F07818 rgb(94, 65, 36);
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    width: 100%;
}

.card {
    background-color: rgba(94, 65, 36, 0.5);
    border: 2px solid #78c0A8;
    border-radius: 10px;
    width: 700px;
    height: 685px;
    margin: 20px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
}

.text-box {
    flex-direction: column;
    display: flex;
    align-items: flex-start;
    justify-content: center;
}

#title-box {
    margin-top: 15px;
}

h3 {
    font-family: "Caprasimo", sans-serif;
    color: #78c0A8;
    font-size: 50px;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

.field {
    font-family: 'Comic Sans MS', 'Chalkboard SE', 'Comic Neue', sans-serif;
    font-size: larger;
    color: #FCEBB6;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 10px;
}

.field label {
    width: 100px;
    margin-right: 10px;
}

#genre {
    width: 350px;
}

.field input {
    width: 350px;
}

img {
    border-radius: 50%;
    width: 45%;
    height: auto;
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
</style>
