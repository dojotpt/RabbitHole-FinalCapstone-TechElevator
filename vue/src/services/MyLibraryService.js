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
    updateAlbum(album) {
        return axios.put(`/album/${album.albumId}/edit`, album)
    },
    getCollectionStats(id) {
        return axios.get(`/album/${id}/stats`)
    }

}
