<template>
    <div>
        <AddCollection :collection="collection" />
    </div>
</template>

<script>
import AddCollection from '../components/AddCollection.vue';
export default {
    components: {
        AddCollection
    },
    data () {
        return {
            collection: {
                userId: this.$store.state.user.id,
                title: '',
                description: '',
                shared:''
            }
        }
    }
}
</script>

<style scoped></style>