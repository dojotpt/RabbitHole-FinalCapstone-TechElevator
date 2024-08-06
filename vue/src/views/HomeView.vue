<template>
  <div id="home-view"> 
    <div class="blurred-background"></div>
    
    <collection-list :collections="collections"/>
    <div class="home-container">
      
      <card id="browse-collections"><img src="src/images/browsecollectionsbutton.png" alt=""></card>
      <div class="genre-container">
      <card id="about-us"><img src="src/images/recordlgenrecard.png" alt="">about us</card>
      <router-link id="my-library-font" :to="{name: 'my-library'}"> <card id="profile"><img src="src/images/recordlgenrecard.png" alt="">profile</card></router-link>
      <router-link id="my-friends-font" :to="{name: 'my-friends'}"><card id="placeholder"><img src="src/images/recordlgenrecard.png" alt="">placehol</card></router-link>
    </div>
    </div>
   
  </div>  
</template>

<script>
import CollectionList from '../components/CollectionList.vue';


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
  display: grid;
  grid-template-columns: 2fr 1fr 1fr 1fr;
  grid-template-rows: 1fr ;
  grid-template-areas: 
  "collections genre1"
  "collections genre2"
  "collections genre3";   
grid-auto-rows: auto;
  
    background-color: black;
    border-radius: 10px;
    width: 100%;
    height: 50vh;
    align-items:center;
    justify-content: center;
    border: white 2px solid;
    margin: auto; 
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
  background-image: url('src/images/recordcollection2.jpeg');
  background-size: cover;
  background-position: center;
  filter: blur(1px);
  z-index: -1;
}

#browse-collections{
  display: flex;
  grid-area: collections;
  width:fit-content;
  height:fit-content;
  width: 0px;
  height: 390px;
  justify-self: center;

}
#about-us{
  grid-area: genre1;
  border : white 2px solid;
margin-bottom: 10px;
font-size: 100px;
text-align: center;;
background-image: url('src/images/about-us.avif');


}
#profile{
grid-area: genre2;
border : white 2px solid;
text-align: center;

font-size: 100px;

background-image: url('src/images/tab-photo2.avif');

;

}
#placeholder{
  grid-area: genre3;
  border : white 2px solid;
text-align: center;

font-size: 100px;

background-image: url('src/images/tab-photo1.avif');


}
.genre-container{
  display: flex;
  flex-direction: column;
  width: 80%;
  
  
  
  
}


</style>
