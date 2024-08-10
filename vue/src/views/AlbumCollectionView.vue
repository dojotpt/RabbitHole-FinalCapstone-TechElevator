<template>
    <div class="library-container">
        <!-- revisit collection in vbind -->
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
    // methods: {
    //     getCollection(id)
    // }
}
</script>

<style scoped></style>