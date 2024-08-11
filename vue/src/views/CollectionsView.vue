<template>
  <div id="collections-view">
    <div class="blurred-background"></div>
    <div class="collections-container">
      <div class="container-view">
        <collection-list></collection-list>
      </div>
    </div>
  </div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue'
export default {
  components:
  {
    CollectionList,
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
  height: 87vh;
  justify-content: center;
  font-family: 'caprasimo', sans-serif;
  font-weight: 190;
  color: #FCEBB6;
  font-size: 25px;
  scrollbar-color: #78c0A8 rgb(26, 20, 14, 0.3);
  flex-direction: row;
}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  filter: blur(4px);
  z-index: -1;
}
</style>
