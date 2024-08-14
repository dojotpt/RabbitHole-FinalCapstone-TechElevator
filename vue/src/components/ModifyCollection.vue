<template>
    <div class="container">
        <div class="blurred-background"></div>

        <div class="my-library-container">
            <div id="album-container">
                <div class="card-container">
                    <div class="card">
                        <router-link :to="`/albums`">
                            <img id="sample-album-img" src="@/images/sample_album.jpg" />
                        </router-link>
                        <h3>Add a New Record</h3>
                        <div class="text-box">
                            <p>Artist name</p>
                            <p>Genre</p>
                            <div class="button-container">
                                <router-link :to="`/albums`">
                                    <button class="add-record-button">
                                        <img id="add-record-button-img" src="@/images/sign-plus-square-fill_.png">
                                    </button>
                                </router-link>
                            </div>
                        </div>

                    </div>

                    <div class="card" v-for="album in albums" :key="album.albumId">
                        <img class="card-img" v-bind:src="album.albumImage" />
                        <div class="text-box">
                            <h3>{{ album.title }}</h3>
                            <p>{{ album.artist }}</p>
                            <p>{{ album.genre }}</p>
                            <div class="checkbox-box">
                                <label for="checkbox">Add Album</label>
                                <input type="checkbox" v-model="selectedAlbumIds" :value="album.albumId">
                            </div>
                        </div>
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
            selectedAlbumIds: []
        };
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
    },
    methods: {
        saveCollection() {
            if (this.collection.collection_id === 0) {
                CollectionService
                    .addCollection(this.collection)
                    .then(response => {
                        if (response.status === 200) {
                            this.$router.push({ name: 'my-collections' });
                        }
                    })
                    .catch(error => {
                        console.error(error);
                    });
            }
        }
    }
}
</script>

<style scoped>
.container {
    display: flex;
    width: 10px;
}

.my-library-container {
    display: flex;
    border-radius: 10px;
    margin: auto;
}

.card-container {
    display: flex;
    justify-content: space-evenly;
    list-style-type: none;
    flex-direction: row;
    height: 650px;
    overflow-x: auto;
    overflow-y: hidden;
}

.card {
    display: flex;
    background-color: rgba(0, 0, 0, 0.5);
    border: 3px solid #78c0A8;
    border-radius: 10px;
    margin: 20px;
    flex-direction: column;



}

h3 {
    font-family: "Caprasimo", sans-serif;
    color: #78c0A8;
    width: 250px;
    height: 50px;
    margin: 25px;
    text-align: center;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    font-weight: 300;
}

p {
    margin-bottom: 70px;
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

.checkbox-box {
    display: flex;
    justify-content: space-evenly;
    height: 100px;
    margin-bottom: 70px;
    font-family: 'Comic Sans MS', 'Chalkboard SE', 'Comic Neue', sans-serif;
    font-size: 25px;
    color: #FCEBB6;
}

.checkbox-box input[type="checkbox"] {
    width: 30px;
    /* Adjust width as needed */
    height: 30px;
    /* Adjust height as needed */
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

    .button-container {
        margin: 30px;
    }

    .blurred-background {
        filter: blur(6px);
    }

    h3 {
        font-size: 1.8em;
    }

    p {
        font-size: 1.5em;
    }

    .text-box p {
        padding-left: 25px;
    }

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
