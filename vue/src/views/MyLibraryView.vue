<template>
    <div class="library-container">
    <div id="my-library">
        
   <h1>Library View</h1>
   <MyLibrary />
    </div>
</div>
</template>

<script>
import MyLibrary from '../components/MyLibrary.vue';
    export default {
        components: {
            MyLibrary,
        }
        
    }
</script>

<style scoped>

</style>