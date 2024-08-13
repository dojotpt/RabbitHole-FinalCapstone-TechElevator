<template>
    <div class="library-container">
        <div id="my-library">
            <ViewAlbumCollection v-bind:collection="collection" />
        </div>
    </div>
</template>

<script>
import MyLibraryService from '../services/MyLibraryService';
import ViewAlbumCollection from '../components/ViewAlbumCollection';
export default {
    components: {
        ViewAlbumCollection,
    },
    data() {
        return {
            collection: {}
        }
    },
}
</script>

<style scoped></style>