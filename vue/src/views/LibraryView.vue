<template>
    <div class="library-container">
    <div id="my-library">
        <h1>Library View</h1>
        <my-library />
    </div>
</div>
</template>

<script>
    import MyLibrary from "../components/MyLibrary.vue"
    export default {
        components: {
        MyLibrary
        }
    }
</script>

<style scoped>
.library-container {
    display: flex;
    flex-direction: column;
    background-color: rgba(94, 65, 36, 0.9);
    border-radius: 10px;
    width: 80%;
    height: 80%;
    align-items:center;
    border: black 2px solid;
    margin: auto; 
    justify-content: center;
    
}
</style>