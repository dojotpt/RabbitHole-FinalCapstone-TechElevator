<template>
    <div class="add-collection-container">
        <AddCollection :collection="collection" />
        <div class="my-library-container">
        <modify-collection />
    </div>
    </div>
    
</template>

<script>
import AddCollection from '../components/AddCollection.vue';
import ModifyCollection from '../components/ModifyCollection.vue';
import MyLibrary from '../components/MyLibrary.vue';
export default {
    components: {
        AddCollection,
        MyLibrary,
        ModifyCollection
    },
    data () {
        return {
            collection: {
                user_id: this.$store.state.user.id,
                title: '',
                description: '',
                shared:''
            }
        }
    }
}
</script>

<style scoped>
.add-collection-container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    height:100%;
    padding-top: 60px;
}
.my-library-container {
width: 150vh;
overflow-x: scroll;
scrollbar-color: #F07818 rgb(94, 65, 36);

}

</style>