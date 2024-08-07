<template>
    <div class="collections-container">
        <div class="blurred-background"></div>

    <div id="collections">
        
   <h1>Collections View</h1>
    </div>
</div>
</template>

<script>
    export default {
        
    }
</script>

<style scoped>

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('src/images/browsecollectionsbutton.png');
  background-size: cover;
  background-position: center;
  filter: blur(4px);
  z-index: -1;
  
}
.collections-container {
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
    
}
</style>
