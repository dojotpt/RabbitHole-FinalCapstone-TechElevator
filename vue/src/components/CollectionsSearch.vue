<!-- <template>
  <form>
    <div class="field">
      <label for="title">Title</label>
    </div>
    <div class="actions">
      <button class="btn-submit" type="submit">Submit</button>
    </div>
  </form>
</template>

<script>
import CollectionService from '../services/CollectionService';

export default {
  props: {
    collections: {
      type: Object,
      
    }
  },
  methods: {
   getCollections() {
    CollectionService.list().then(response => {
        console.log(response);
    }).catch(error => {
        console.error(error);
    });
  },
  
}
  
};
</script>

<style>
form {
  padding: 20px;
  font-size: 16px;
}
form * {
  box-sizing: border-box;
  line-height: 1.5;
}
.field {
  display: flex;
  flex-direction: column;
}
.field label {
  margin: 4px 0;
  font-weight: bold;
}
.field input,
.field textarea {
  padding: 8px;
  font-size: 18px;
}
.field textarea {
  height: 300px;
}
.actions {
  text-align: right;
  padding: 10px 0;
}
</style> -->
