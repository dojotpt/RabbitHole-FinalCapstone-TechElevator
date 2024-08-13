<template>
    <div>
        <AddAlbum :album="album" />
    </div>
</template>

<script>
import AddAlbum from '../components/AddAlbum.vue';

export default {
    components: {
        AddAlbum
    },
    data() {
        return {
            album: {
                albumId: 0,
                registeredUserId: this.$store.state.user.id,
                title: '',
                artist: '',
                yearReleased: '',
                genre: '',
                notes: '',
                albumImage: ''
            }
        }
    }
}
</script>
<style scoped></style>