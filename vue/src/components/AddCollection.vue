<template>
  <div class="collection-form-wrapper">
    <div class="blurred-background"></div>
    <form class="add-album-form" @submit.prevent="saveCollection">
      <div class="card-container">
        <img src="@/images/addrecordcollectioncard.png" alt="Add Record Collection Card" />

        <div class="card">
          <div id="title-box">
            <h3>Add a Collection</h3>
          </div>
          <div class="text-box">
            <div class="field">
              <label for="title">Title</label>
              <input id="title" type="text" v-model="newCollection.title" />
            </div>
            <div class="field">
              <label for="description">Description</label>
              <input id="description" type="text" v-model="newCollection.description" />
            </div>
            <div class="field">
              <label class="checkbox-label" for="shared">
                Public
                <input type="checkbox" id="shared" v-model="newCollection.shared" />
              </label>
            </div>
            <div class="actions">
              <button type="button" @click="cancel">Cancel</button>
              <button type="submit">Save Collection</button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>

  <div class="my-library-container">
    <div id="album-container">
      <div class="card-container">

        <div class="card" v-for="album in albums" :key="album.albumId">
          <img class="card-img" v-bind:src="album.albumImage" />
          <div class="text-box">
            <h3>{{ album.title }}</h3>
            <p>{{ album.artist }}</p>
            <p>{{ album.genre }}</p>
            <div class="checkbox-box">
              <label for="checkbox">Add Album</label>
              <input type="checkbox" v-model="newCollection.albums" :value="album.albumId">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService.js';
import MyLibraryService from '../services/MyLibraryService.js';

export default {
  props: {
    collection: {
      type: Object,
      required: true
    }
  },
  computed: {
    albums() {
      return this.$store.state.myLibrary.albums;
    }
  },
  data() {
    return {
      selectedAlbumIds: [],
      newCollection: {
        userId: this.collection.user_id,
        title: this.collection.title,
        description: this.collection.description,
        shared: this.collection.shared,
        albums: this.collection.selectedAlbumIds || []
      },
    };
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
      CollectionService.addCollection(this.newCollection)
        .then(r => {
          if (r.status === 201) {
            this.$store.commit('SET_MY_COLLECTION', r.data);
          }

        })
      this.$router.push({ name: 'my-collections' });
    },
    cancel() {
      this.$router.push({ name: 'my-collections' });
    }

    //   saveCollection() {
    //     if (this.collection.collection_id === 0) {
    //       CollectionService
    //         .addCollection(this.collection)
    //         .then(response => {
    //           if (response.status === 200) {
    //             this.$router.push({ name: 'my-collections' });
    //           }
    //         })
    //         .catch(error => {
    //           console.error(error);
    //         });
    //     }
    //   }
    // }
  }
}
</script>


<style scoped>
.actions {
  display: flex;
  align-self: center;
  justify-content: space-between;
  width: 330px;

}

.checkbox-label {
  display: flex;
  align-self: center;
}

.card-container {
  height: 500px;

  scrollbar-color: #F07818 rgb(94, 65, 36);
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  width: 100%;
}

.card {
  background-color: rgba(0, 0, 0, 0.6);
  border: 3px solid #78c0A8;
  border-radius: 10px;
  width: 600px;
  height: 600px;

  display: flex;
  flex-direction: column;
  align-items: center;
}

.text-box {
  flex-direction: column;
  display: flex;

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


.field input {
  width: 350px;
}

img {

  height: 550px;

}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: linear-gradient(hwb(28 5% 89% / 0.247), hwb(29 9% 81% / 0.5)), url('@/images/mycollections.jpg');
  background-size: cover;
  background-position: center;
  filter: blur(4px);
  z-index: -1;

}

label {
  color: #FCEBB6;
  font-family: 'caprasimo', sans-serif;
  font-size: 25px;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;

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
</style>