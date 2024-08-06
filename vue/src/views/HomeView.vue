<template>
  <div id="home-view"> 
    <div class="blurred-background"></div>
    
    <div class="home-container">
     <div class="collection-card">
        </div>

        <div id="browse-collections" class="card">
          <div class="card-text">Browse Collections</div>
        </div>

        <div class="collection-card">
        </div>

        <div id="about-us" class="card">
          <div class="card-text">About Us</div>
        </div>

        <div class="collection-card">
        </div>

        <div id="profile" class="card">
          <div class="card-text">Profile</div>
        </div>

        <div class="collection-card">
        </div>

        <div id="placeholder" class="card">
          <div class="card-text">Placeholder</div>
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
  grid-template-columns: 2fr 2fr;
  grid-template-areas: 
  "collections genre1"
  "collections genre2"
  "collections genre3";   
    background-color: black;
    border-radius: 10px;
    width: 100%;
    height: 130%;
    align-items:center;
    justify-content: center;
    border: white 1px solid;
    margin: auto; 
    font-family: 'RabbitFont';
  font-weight: 300;
  color: #78c0A8;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  font-size: 25px;
  
  
  
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
  filter: blur(2px);
  z-index: -1;
  
}


#browse-collections{
  
  display: flex;
  grid-area: collections;
  width: 500px;
  height: 500px;
  border: 1PX white solid;
  border-radius: 7PX;
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  justify-self: self-end;
  margin-right: 10px;
  color: white;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  font-size: 60px;
  
  
  
 }
 .card-text {
  
  width: 100%;
  height: 100%;
  backdrop-filter: blur(5px); 
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 7px; 
  font-size: 60px;
  
}
  
  
  

 
#about-us{
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url('src/images/playerStylus.jpg');
  background-size: cover;
  background-position: center;
  grid-area: genre1;
  border : white 1px solid;
  font-size: 80px;
  text-align: center;
  width:90%;
  text-decoration: none;
  height: 76%;
  border-radius: 7PX;
  color: white;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  align-self: end;
  
}
#profile{
  display: flex;
  align-items: center;
  justify-content: center;
grid-area: genre2;
border : white 1px solid;
text-align: center;
height: fit-content;
font-size: 80px;
width:90%;
background-image: url('src/images/tab-photo-4.avif');
  background-size: 80%;
  background-position: center;
  background-position-y: -85px;
  
  border-radius: 7PX;
  color: white;
  height: 76%;
  text-decoration: none;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  

}
#placeholder{
  grid-area: genre3;
  display: flex;
  align-items: center;
  justify-content: center;
  border : white 1px solid;
  text-align: center;
  height: fit-content;
  font-size: 80px;
  width:90%;
  background-image: url('src/images/tab-photo3.avif');
  background-size: cover;
  background-position: center;
  border-radius: 7PX;
  color: white;
  height: 76%;
  text-decoration: none;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  align-self: start;
  

}

</style>
