<template>
    <div id="collections-view"></div>
    <div class="blurred-background"></div>
    <div class="collections-container">
        <div class="container-view" >
           <MyCollections/>

           
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

<style scoped>
.container-view {
  display: flex;
  flex-direction: column;
  width: 80%;
  height: 100%;
  align-items: center;
}

#collections-view {
  display: flex;
}

.collections-container {
  display: flex;
  width: 100%;
  justify-content: center;
  font-family: 'caprasimo', sans-serif;
  font-weight: 190;
  color: #FCEBB6;
  font-size: 25px;
  scrollbar-color: #78c0A8 rgb(26, 20, 14, 0.3);
  height: 90%;
 
}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  background-image: url('src/images/mycollectionsclipped.png');
  background-size: cover;
  background-repeat: no-repeat;
  width: 100%;
  height: 100%;
  filter: blur(4px);
  z-index: -1;
}

</style>