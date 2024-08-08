<template>
    <div class="library-container">
        <div id="my-library">
            <ViewAlbumCollection />
        </div>
    </div>
</template>

<script>
import ViewAlbumCollection from '../components/ViewAlbumCollection';
export default {
    components: {
        ViewAlbumCollection,
    }
}
</script>

<style scoped></style>