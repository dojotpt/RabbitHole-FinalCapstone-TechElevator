<template>
    <div class="add-album-container">
        <AddAlbum :album="album" />
    </div>
</template>

<script>
import AddAlbum from '../components/AddAlbum.vue';
import MyLibraryService from '../services/MyLibraryService';

export default {
    components: {
        AddAlbum
    },
    data() {
        return {
            album: {
                album_id: 0,
                registeredUserId: this.$store.state.user.id,
                title: '',
                artist: '',
                yearReleased: '',
                genre: '',
                notes: '',
                albumImage: ''
            }
        }
    },
    created() {
        let album_id = parseInt(this.$route.params.album_id);
        if (album_id != 0) {
            MyLibraryService
                .getAlbum(album_id)
                .then(response => {
                    this.album = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }
}
</script>
<style scoped>

.add-album-container {
    display: flex;
    flex-direction: column;
    height: 100%;
    justify-content: center;
}
</style>