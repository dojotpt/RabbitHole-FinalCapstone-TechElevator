
import axios from 'axios';

export default {

  getAllCollections() {
    return axios.get("/collections");
  },
  getCollectionByUserId(id) {
    return axios.get(`/mycollections/${id}`);
  },
  addCollection(collection) {
    return axios.post(`/addcollections`, collection);
  },
  updateCollection(collection) {
    return axios.put(`/collections/${id}/albums`, collection)
  }
}
