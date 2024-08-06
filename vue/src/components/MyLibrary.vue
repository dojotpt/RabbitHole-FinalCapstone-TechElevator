<template>
    <div id="main-container">

        <div id="album-container">
            <ul>
                <li>
                    <button>Add Record</button>
                </li>
                <li v-for="album in albums" :key="album.id">
                    <h1>{{ album.title }}</h1>
                    <p>{{ album.artist }}</p>
                    <p>{{ album.genre }}</p>
                    <div class="button-container">
                        <button>Edit Record</button>
                        <button>Delete Record</button>
                    </div>
                </li>
            </ul>
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
        // commit takes mutation and payload
        /* revisit error
        */

    }
}
</script>

<style scoped>
#main-container {
    display: flex;
    flex-direction: column;
    background-color: rgba(94, 65, 36, 0.9);
    border-radius: 10px;
    width: 80%;
    height: 80%;
    align-items: center;
    border: black 2px solid;
    margin: auto;
    justify-content: center;
}


#album-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>