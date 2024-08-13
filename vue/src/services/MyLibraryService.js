import axios from 'axios';


export default {

    getLibraryByRegUserId(id) {
        return axios.get(`/mylibrary/${id}`);
    },

    addAlbum(album) {
        return axios.post(`/albums`, album);
    },

    getCollection(id) {
        return axios.get(`/albumcollection/${id}`)
    },
    getAlbum(id) {
        return axios.get(`/album/${id}`)
    },
    updateAlbum(id, album) {
        return axios.put(`/album/${id}`)
    },

    // deleteAlbum(id) {
    //     return axios.delete(`//${id}`);
    // }

}
