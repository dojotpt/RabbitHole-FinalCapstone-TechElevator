
import axios from 'axios';

export default {

  getAllCollections(){
    return axios.get("/collections");
  },
  getCollectionByUserId(user_id){
    return axios.get(`/mycollections/${user_id}`);
  },
  addCollection(collection){
    return axios.post(`/addcollections`, collection);
  }
}
