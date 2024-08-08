import axios from 'axios';


export default {

    getLibraryByRegUserId(id) {
        return axios.get(`/mylibrary/${id}`);
    },

    addAlbum(album) {
        return http.post(`/mylibrary/${id}`, album);
    },

    // updateAlbum(id, album) {
    //     return http.put(`//${id}`)
    // },

    // deleteAlbum(id) {
    //     return http.delete(`//${id}`);
    // }

}
