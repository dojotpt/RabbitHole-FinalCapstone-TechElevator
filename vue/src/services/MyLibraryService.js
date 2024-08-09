import axios from 'axios';


export default {

    getLibraryByRegUserId(id) {
        return axios.get(`/mylibrary/${id}`);
    },

    addAlbum(id, album) {
        return axios.post(`/mylibrary/${id}`, album);
    },

    viewAlbumCollection(id) {
        return axios.get(`albumcollection/${id}`)
    }
    // updateAlbum(id, album) {
    //     return http.put(`//${id}`)
    // },

    // deleteAlbum(id) {
    //     return http.delete(`//${id}`);
    // }

}
