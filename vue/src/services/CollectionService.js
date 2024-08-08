
import axios from 'axios';

export default {

  getAllCollections(){
    return axios.get("/collections");
  },
}
