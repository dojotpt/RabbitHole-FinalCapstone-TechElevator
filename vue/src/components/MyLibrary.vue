<template>

    <div class="blurred-background"></div>

    <div class="my-library-container">
        <div id="album-container">
            <div class="card-container">
                <div class="card">
                    <router-link :to="`/album/0/edit`">
                        <img id="sample-album-img" src="@/images/sample_album.jpg" />
                    </router-link>
                    <h3>Add a New Record</h3>
                    <div class="text-box">
                        <p>Artist name</p>
                        <p>Genre</p>
                    </div>
                    <div class="button-container">
                        <router-link :to="`/album/0/edit`">
                            <button class="add-record-button"><img id="add-record-button-img"
                                    src="@/images/sign-plus-square-fill_.png"></button>
                        </router-link>
                    </div>
                </div>

                <div class="card" v-for="album in albums" :key="album.id">
                    <router-link :to="`/album/${album.albumId}`">
                        <img class="card-img" v-bind:src="album.albumImage" />
                    </router-link>
                    <div class="text-box">
                        <h3>{{ album.title }}</h3>
                        <p class="artist">{{ album.artist }}</p>
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
    data() {
        return {

        }
    },
    computed: {
        albums() {
            return this.$store.state.myLibrary.albums;
        }
    },

    created() {
        MyLibraryService.getLibraryByRegUserId(this.$store.state.user.id)
            .then((response) => {
                const myLibrary = response.data;
                this.$store.commit('SET_LIBRARY', myLibrary);
            })
            .catch(error => {
                console.error(error);
            });
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
    display: flex;
    background-color: rgba(0, 0, 0, 0.5);
    border: 3px solid #78C0A8;
    border-radius: 10px;
    margin-right: 20PX;
    flex-direction: column;
    margin-bottom: 15px;
}

h3 {
    font-family: "Caprasimo", sans-serif;
    color: #78C0A8;
    width: 250px;
    height: 50px;
    margin: 25px;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    font-weight: 300;
}

p {
    margin-bottom: 60px;
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
    justify-content: center;
    align-items: flex-end;
}

.artist {
    display: inline-block;
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

@media only screen and (min-width: 1024px) {
    .my-library-container {
        width: 60%;
        height: 60%;
    }

    .card-container {
        max-height: 90vh;
    }

    .card {
        width: 300px;
    }

    /* .button-container {
        margin: 30px;
    } */

    .blurred-background {
        filter: blur(6px);
    }

    h3 {
        font-size: 1.5em;
    }

    p {
        font-size: 1em;
    }

    /* .text-box p {
        padding-left: 25px;
    } */

    .add-record-button {
        font-size: 1.2em;
    }

    #add-record-button-img {
        width: 30px;
    }

    #edit-button img {
        width: 30px;
    }

    #delete-button img {
        width: 30px;

    }
}
</style>
