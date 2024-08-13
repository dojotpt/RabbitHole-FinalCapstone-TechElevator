<template>
  <div id="home-view"> 
    <div class="blurred-background"></div>
    
    <div class="home-container">
     <div class="collection-card">
        </div>

        <div id="browse-collections" class="card">
          <a href="collections" class="card-text">Browse Collections</a>
        </div>

        <div class="collection-card">
        </div>

        <div id="about-us" class="card">
          <a href="mylibrary" class="card-text">My Library</a>
        </div>

        <div class="collection-card">
        </div>

        <!-- will add later for full functionality after demo -->

        <!-- <div id="profile" class="card">
          <a href="profile" class="card-text">Profile</a>
        </div> -->

        <div class="collection-card">
        </div>

        <div id="placeholder" class="card">
          <a href="mycollections" class="card-text">My Collections</a>
        </div>
      
    </div>
   

  </div>  
  
</template>

<script>

</script>

<style scoped>
#home-view {
  display: flex;
  height: 100%;
  justify-content: center;
  align-items: center;
}
.home {
  padding: 20px;
}
.home-container {
  display: grid;
  grid-template-columns: 1.3fr 2fr;
  grid-template-areas: 
  "collections genre1"
  "collections genre2"
  "collections genre3";    
    width: 100%;
    height: 50vh;
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
  background-image: linear-gradient(hwb(28 5% 89% / 0.247),hwb(29 9% 81% / 0.5) ), url('src/images/recordcollection2.jpeg');
  background-size: cover;
  background-position: center;
  filter: blur(4px);
  z-index: -1; 
}
#browse-collections{ 
  display: flex;
  grid-area: collections;
  width: 500px;
  height: 500px;
  border: 2PX #FCEBB6 solid;
  border-radius: 7PX;
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  justify-self: self-end;
  margin-right: 12px;
  color: white;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  font-size: 60px;
 }
 .card-text {
  font-family: "Caprasimo",sans-serif;
  font-weight: 400; 
  width: 100%;
  height: 100%;
  backdrop-filter: blur(5px);
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
  font-size: 40px;
  text-decoration: none;
  color:  #FCEBB6;
}
#placeholder .card-text{
  backdrop-filter: blur(3px); 
}
#about-us .card-text{
 backdrop-filter: blur(3px); 
}
#profile .card-text{
  backdrop-filter: blur(3px);
}
#about-us{
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url('src/images/playerStylus.jpg');
  background-size: cover;
  background-position: center;
  grid-area: genre1;
  border: 2PX #FCEBB6 solid;
  font-size: 80px;
  text-align: center;
  width:70%;
  text-decoration: none;
  height: 90%;
  border-radius: 7PX;
  color: white;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  align-self: end;
  margin-bottom: 10px;  
}
#profile{
  display: flex;
  align-items: center;
  justify-content: center;
  grid-area: genre2;
  border: 2PX #FCEBB6 solid;
  text-align: center;
  height: fit-content;
  font-size: 80px;
  width:70%;
  background-image: url('src/images/tab-photo-4.avif');
  background-size: 80%;
  background-position: center;
  background-position-y: -85px;
  margin-top: px;
  border-radius: 7PX;
  color: white;
  height: 96%;
  text-decoration: none;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
#placeholder{
  grid-area: genre3;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 2PX #FCEBB6 solid;
  text-align: center;
  font-size: 80px;
  width:70%;
  background-image: url('src/images/mycollections.jpg');
  background-size: cover;
  border-radius: 7PX;
  color: white;
  height: 90%;
  text-decoration: none;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  align-self: start;
  box-shadow: 0 0 0 0px #FF6347;
  margin-top: 10px;
}


</style>
