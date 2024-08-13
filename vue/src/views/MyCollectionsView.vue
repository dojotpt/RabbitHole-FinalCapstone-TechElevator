<template>
    <div class="my-collections-container">
        <div id="my-collections" >
           <MyCollections />
        </div>
    </div>
</template>

<script>
import MyCollections from '../components/MyCollections.vue';
export default {
    components: {
        MyCollections,
    }

}
</script>

<style scoped></style>