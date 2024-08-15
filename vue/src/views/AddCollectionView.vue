<template>
    
    <div class="add-collections-container">
       
        <AddCollection :collection="collection" />
       
       
    </div>
</template>

<script>
import AddCollection from '../components/AddCollection.vue';
import MyLibrary from '../components/MyLibrary.vue';

export default {
    components: {
        AddCollection,
        MyLibrary
    },
    data() {
        return {
            collection: {
                user_id: this.$store.state.user.id,
                title: '',
                description: '',
                shared: ''
            },
        }
    },
}
</script>

<style scoped>
.add-collections-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    
 
}



</style>