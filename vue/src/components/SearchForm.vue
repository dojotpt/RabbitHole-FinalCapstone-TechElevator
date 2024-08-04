<template>
    <form v-on:submit.prevent="submitForm">
      <div class="field">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" v-model="editTopic.title" />
      </div>
      <div class="actions">
        <button class="btn-submit" type="submit">Submit</button>
        <button class="btn-cancel" type="button" v-on:click="cancelForm">Cancel</button>
      </div>
    </form>
  </template>
  <script>
  import CollectionService from '../services/CollectionService';
  export default {
    props: {
      collection: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        // Since props are read-only, don't bind to props directly. 
        // Instead, initialize a new object with the same property values.
        getCollection: {
          id: this.collection.id,
          name: this.collection.name,
          description: this.collection.description,
          public: true
        },
        }
      };
    },
    methods: {
      list() {
        
        
        CollectionService.list()
        .then((response) => {this.$router.push({ name: 'HomeView' });
        
      })
        
      },
      cancelForm() {
        this.$router.back();
      },
      handleErrorResponse(error, verb) {
        if (error.response) {
          if (error.response.status == 404) {
            this.$router.push({name: 'NotFoundView'});
          } else {
            this.$store.commit('SET_NOTIFICATION',
            `Error ${verb} topic. Response received was "${error.response.statusText}".`);
          }
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', `Error ${verb} topic. Server could not be reached.`);
        } else {
          this.$store.commit('SET_NOTIFICATION', `Error ${verb} topic. Request could not be created.`);
        }
      },
      validateForm() {
        let msg = '';
        this.editTopic.title = this.editTopic.title.trim();
        if (this.editTopic.title.length === 0) {
          msg += 'The new topic must have a title. ';
        }
        if (msg.length > 0) {
          this.$store.commit('SET_NOTIFICATION', msg);
          return false;
        }
        return true;
      },
    }
  };
  </script>