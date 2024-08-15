<template>
    <div class="blurred-background"></div>
    <form class="add-album-form" v-on:submit.prevent="saveAlbum">
        <div class="card-container">
            
            <!-- this needs a hide show thingy for the image if the view is 
            in an add album form  or  edit album form-->

            <img v-if="album.album_id !== 0" class="card-img" v-bind:src="album.albumImage" /> 
            <img v-else id="sample-album-img" src="@/images/sample_album.jpg"/>
            <!-- <div class="card" v-for="album in albums" :key="album.id">
                <img class="card-img" v-bind:src="album.albumImage" />
            </div> -->

            <div class="card">
                <div id="title-box">

                    <h3 v-if="album.album_id !== 0" class="edit">Edit Record</h3>
                    <h3 v-else class="add">Add a New Record</h3>
                    
                </div>
                <div class="text-box">
                    <div class="field">
                        <label for="title">Title</label>
                        <input id="title" type="text" v-model="album.title" />
                    </div>
                    <div class="field">
                        <label for="artist">Artist</label>
                        <input id="artist" type="text" v-model="album.artist" />
                    </div>
                    <div class="field">
                        <!-- /* need to trim year released, right? */   -->
                        <label for="yearReleased">Year Released</label>
                        <input id="yearReleased" type="text" v-model="album.yearReleased" />
                    </div>
                    <div class="field">
                        <label for="genre">Genre</label>
                        <select id="genre" v-model="album.genre">
                            <option value="Pop">Pop</option>
                            <option value="Rock">Rock</option>
                            <option value="R&B">R&B</option>
                            <option value="Country">Country</option>
                            <option value="Jazz">Jazz</option>
                            <option value="Classical">Classical</option>
                            <option value="Electronic Dance Music">Electronic Dance Music</option>
                            <option value="Reggae">Reggae</option>
                            <option value="Latin">Latin</option>
                        </select>
                    </div>
                    <div class="field">
                        <label for="notes">Notes</label>
                        <input id="notes" type="text" v-model="album.notes" />
                    </div>
                    <div class="field">
                        <label for="albumImage">Url for Album Image</label>
                        <input id="albumImage" type="text" v-model="album.albumImage" />
                        <div class="actions">
                        <button type="button" v-on:click="cancel()">Cancel</button>&nbsp;
                        <button type="submit">Save Album</button>
                    </div>
                    </div>
                   
                </div>
            </div>
        </div>

    </form>
</template>

<script>
import MyLibraryService from '../services/MyLibraryService.js';

export default {

    props: {
        album: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            addAlbum: {
                album_id: this.album.album_id,
                registeredUserId: this.$store.state.user.id,
                title: this.album.title,
                artist: this.album.artist,
                yearReleased: parseInt(this.album.yearReleased, 10),
                genre: this.album.genre,
                notes: this.album.notes,
                albumImage: this.album.albumImage
            }
        };
    },
    
    methods: {
        saveAlbum() {
            if (this.album.album_id === 0) {
                MyLibraryService
                    .addAlbum(this.album)
                    .then(response => {
                        if (response.status === 200) {
                            this.$router.push({ name: 'my-library' });
                        }
                    })
                    .catch(error => {
                        console.error(error);
                    });
            }
            else {
                MyLibraryService
                    .updateAlbum(this.album)
                    .then(response => {
                        if (response.status === 200) {
                            this.$router.push({ name: 'my-library' });
                        }
                    })
                    .catch(error => {
                        console.error(error);
                    });
            }
        },
        cancel() {
            this.$router.push({ name: "my-library" });
        }

    }
}
</script>


<style scoped>
.card-img{
    width: 35%;
    height: auto;
    border-color: black;
    border-style: solid;
}
.hide {
    display: none;
}

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
    display: flex;
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
    
    margin-right: 10px;
}

#genre {
    width: 350px;
}

.field input {
    width: 350px;
}

#sample-album-img {
    border-radius: 50%;
    width: 45%;
    height: auto;
}
button {
  font-family: "Caprasimo", sans-serif;
  font-weight: 400;
  background-color: #F07818;
  font-size: large;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  color: #FCEBB6;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  text-decoration: none;
  border: #000 2px solid;
  margin-top: 60px;
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
.actions {
    margin-top: -30px;
}

</style>
