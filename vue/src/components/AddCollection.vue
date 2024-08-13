<template>
    <div class="blurred-background"></div>
    <form class="add-album-form" v-on:submit.prevent="saveCollection">
        <div class="card-container">
            <img src="@/images/addrecordcollectioncard.png" />

            <div class="card">
                <div id="title-box">
                    <h3>Add a Collection</h3>
                </div>
                <div class="text-box">
                    <div class="field">
                        <label for="title">Title</label>
                        <input id="title" type="text" v-model="collection.title" />
                    </div>
                    <div class="field">
                        <label for="description">Description</label>
                        <input id="description" type="text" v-model="collection.description" />
                    </div>
                    <label class="checkbox-label" for="shared">Public
                    <input type="checkbox" id="shared" v-model="collection.shared"></label>
                   
                  
                    <div class="actions">
                        <button type="button" v-on:click="cancel()">Cancel</button>&nbsp;
                        <button type="submit">Save Collection</button>
                    </div>
                </div>
            </div>
        </div>

    </form>
</template>

<script>
import CollectionService from '../services/CollectionService.js';

export default {
    props: {
        collection: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            // collection: {
            //     UserId: this.$store.state.user.id,
            //     title: '',
            //     description: ''
            // }
        };
    },
    
    methods: {
        saveCollection() {
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
        },
        cancel() {
            this.$router.push({ name: "my-collections" });
        }

    }

}
</script>


<style scoped>
.actions {
    display: flex;
    align-self: center;
    width: 320px;
  
    justify-content: space-between;
    
}
.checkbox-label {
    display: flex;
    align-self: center;
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
    background-color: rgba(0, 0, 0, 0.6);
    border: 2px solid #78c0A8;
    border-radius: 10px;
    width: 700px;
    height: 685px;
    margin: 20px;
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