<template>
     <div id="collections-view">
        <div class="blurred-background"></div>
    <div class="collections-container">
        <h1>Collections View</h1>
        <collection-list ></collection-list>
    </div>
</div>
</template>

<script>
import CollectionList from '../components/CollectionList.vue'
    export default {
     components:
     {CollectionList,
    }
  
  }



</script>

<style scoped>
#collections-view {
  display: flex;
  height: 100%;
  justify-content: center;
  align-items: center;
}

.collections-container {
  display: grid;
  grid-template-columns: 1.3fr 2fr;
  grid-template-areas: 
  "collections genre1"
  "collections genre2"
  "collections genre3";    
    width: 100%;
    height: 70vh;
    align-items:center;
    justify-content: center;   
    font-family: 'RabbitFont';
    font-weight: 300;
    color: #78c0A8;
    text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
    font-size: 25px;
    align-content: center;
    box-shadow: black 0px 0px 100px;
    
  
  
}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: linear-gradient(hwb(28 5% 89% / 0.247),hwb(29 9% 81% / 0.5) ),url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  filter: blur(0px);
  z-index: -1;
 
  
}
/* .collections-container {
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
    
} */
</style>
