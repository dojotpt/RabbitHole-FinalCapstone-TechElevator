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
            album: {},
            stats: 0
        }
    }
   
}

</script>

<style scoped></style>