<template>
  <div id="home-view"> 
    <div class="blurred-background"></div>
    <collection-list :collections="collections"/>
  </div>
  <div class="home-container">        
   <h1>Home</h1>
   
   <h2>Welcome to the Rabbit hole, a place were record collectors, enthusiasts or people who just like cataloging can come and make a digital library of a record collection. </h2>

    <li>As a guest of our website you can browse collections made public by users!</li>

     <li> As a user you can create your own library of up to 25 records  and curate 2 collections and browse friends collections!</li>

     <li>As a Premium user you can have unlimited records in your library and unlimited collections!</li>

     <li>So what are you waiting for how far down the Rabbit Hole do you want to go.</li>
    
   </div>
  
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
// import CollectionService from '../services/CollectionService';

export default {
  components: {
    
  },
  data() {
    return {
      
      
    };
  },

  

}
</script>

<style scoped>
.home {
  padding: 20px;
}
.home-container {
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
    font-family: 'RabbitFont';
  font-weight: 300;
  color: #78c0A8;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  font-size: 30px;
}


.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('src/images/record store.jpeg');
  background-size: cover;
  background-position: center;
  filter: blur(5px);
  z-index: -1;
}
</style>
