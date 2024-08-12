<template>
    <div>
        <AlbumDetails :album="album" />
    </div>
</template>

<script>
import AlbumDetails from '../components/AlbumDetails.vue'
import MyLibraryService from '../services/MyLibraryService';

export default {
    components: {
        AlbumDetails
    },
    data() {
        return {
            album: {}
        }
    }
}

</script>

<style scoped></style>