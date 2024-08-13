<template>
    <div class="blurred-background"></div>
    <div class="card-container">
        <img class="card-img" v-bind:src="album.albumImage" />
        <div class="card">

            <div id="text-box">
                <p>This record appears {{ stats }} times in your collections.</p>
                <h1>{{ album.artist }}</h1>
                <h2> Album:</h2>
                <h3>{{ album.title }}</h3>
                <h2> Genre:</h2>
                <p>{{ album.genre }}</p>
                <h2> Year Released:</h2>
                <p>{{ album.yearReleased }}</p>
                <h2> Personal Notes:</h2>
                <p class="notes">{{ album.notes }}</p>
            </div>
            <div class="button-container">
                <button id="edit-button"><img src="@/images/edit_.png"></button>
            </div>

        </div>
    </div>
</template>

<script>
import MyLibraryService from '../services/MyLibraryService.js';

export default {
    computed: {
        album() {
            return this.$store.state.album;
        },
        stats() {
            return this.$store.state.stats;
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
            MyLibraryService.getCollectionStats(albumId)
                .then((response) => {
                    const stats = response.data;
                    this.$store.commit('SET_STATS', stats);
                })
        } else {
            console.error("No album ID found in the route parameters.");
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

#text-box {

    height: 800px;
}

#title-box {
    margin-top: 15px;
}

h1 {
    font-family: "Caprasimo";
    color: #78c0A8;
    font-size: 78px;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    margin-bottom: 65px;
    margin-top: 0px;
}

h3 {
    font-family: "Caprasimo", sans-serif;
    color: #FCEBB6;
    font-size: 40px;
    text-align: left;
    padding-left: 40px;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    margin-bottom: 25px;
    margin-top: 0px;
}

p {
    font-family: "Caprasimo", sans-serif;
    color: #FCEBB6;
    font-size: 30px;
    text-align: left;
    padding-left: 40px;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    margin-bottom: 15px;
    margin-top: 0px;
}

h2 {
    font-family: "Caprasimo", sans-serif;
    text-shadow: -1px -1px 0 gray, 1px -1px 0 gray, -1px 1px gray, 1px 1px 0 gray;
    margin-bottom: 10px;
    margin-top: 0px;
    padding-left: 10px;
}

.notes {
    margin-top: 20px;
    font-family: "Caprasimo", sans-serif;
    color: #FCEBB6;
    font-size: 20px;
    text-align: left;
    padding-left: 40px;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    margin-bottom: auto;
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

    width: 35%;
    height: auto;
    border-color: black;
    border-style: solid;
}

.button-container {

    display: flex;
    justify-content: space-between;
    margin: 0px;
    justify-self: bottom;
    padding-bottom: 20px;
}

button {
    background-color: #FCEBB6;
    color: white;
    border: none;
    border-radius: 10px;
    padding: 15px 20px;
    /* Small size */
    font-size: 12px;
    /* Small font size */
    cursor: pointer;
    display: flex;
    margin-left: 10px;
    margin-right: 10px;
}

button img {
    height: 16px;
    /* Small icon size */
    width: 16px;
    margin-right: 5px;
    /* Space between icon and text */
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
