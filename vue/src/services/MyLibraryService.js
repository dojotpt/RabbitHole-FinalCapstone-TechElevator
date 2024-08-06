import axios from 'axios';

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

    getLibraryByRegUserId(id) {
        return http.get(`/mylibrary/${id}`);
    },

    // addAlbum(album) {
    //     return http.post(`/`, album);
    // },

    // updateAlbum(id, album) {
    //     return http.put(`//${id}`)
    // },

    // deleteAlbum(id) {
    //     return http.delete(`//${id}`);
    // }

}
