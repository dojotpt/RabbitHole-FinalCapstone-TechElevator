<template>
  <div class="home">
    <div class="blurred-background"></div>
    <header>
      <router-link v-bind:to="{ name: 'home' }" id="logo">
      <h1 class="title">Rabbit Hole</h1>
    </router-link>&nbsp;
      <form action="/search" method="get" class="search-form">
  <input type="search" id="search" name="q" placeholder="Search Collections">
  <button id="search-button">
    <img id="search-icon" src="src/images/search_.png" alt="Search">
  </button>
</form>
      <nav id="header-buttons">
        
        
        <!-- <button id="browse-collections">Browse Collections</button> -->
        
        <button id="header-register" @click="goTo('register')">Register</button>

        <button id="header-login" @click="goTo('login')">Login</button>
      </nav>
      <!-- Add any navigation links or other header elements here -->
    </header>
    
    <div id="nav">
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    goTo(routeName) {
      this.$router.push({ name: routeName });
    }
  }
}
</script>

<style>

@font-face {
  font-family: 'RabbitFont';
  src: url('@/assets/fonts/RABBITZ HOLE_PERSONALUSEONLY.TTF') format('truetype');
  font-weight: normal;
  font-style: normal;
}
#login ,#register {
  border: 2px solid black;
}
#logo {
  text-decoration: none;
}


/* Add styles for your header here */

.home {
  position: relative; /* Required for the pseudo-element */
  height: 100vh;
  display: flex;
  flex-direction: column;
  overflow: hidden; /* Prevent content overflow */
}

.blurred-background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('C:\Users\Student\workspace\record-collection-mgr\vue\src\images\record store.jpeg'); /* Use the correct path */
  background-size: cover;
  background-position: center;
  filter: blur(4px); /* Adjust the blur level */
  z-index: -1; /* Place it behind other content */
}

header {
  background-color: rgba(94, 65, 36, 0.9); /* Semi-transparent background for header */

  text-align: left;
  align-content: center;

  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
  border-bottom:  2px solid black;
}
#header-buttons {
  display: flex;
  gap: 10px;
}
.title {
  color: #78c0A8;
  font-family: 'RabbitFont';
  font-size: 90px;
  width: 400px;
  font-weight: 300; /* Use a lighter weight */
  display: flex;
  align-items: center;
  text-shadow: 
    -1px -1px 0 #000,  
    1px -1px 0 #000,
    -1px 1px 0 #000,
    1px 1px 0 #000;
}
h1 {
  font-family: 'RabbitFont';
  font-weight: 300;
  color: #78c0A8;
  text-shadow: 
    -1px -1px 0 #000,  
    1px -1px 0 #000,
    -1px 1px 0 #000,
    1px 1px 0 #000;
}
label {
  margin-right: 0.5rem;
  color: #FCEBB6;
  text-shadow: 
    -1px -1px 0 #000,  
    1px -1px 0 #000,
    -1px 1px 0 #000,
    1px 1px 0 #000;
}




input[type="search"] {
  height: 46px;
  font-weight: 700;
  background-color: #FCEBB6;
  text-align: center;
  
}

button {
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  opacity: 1;
}

#headerlogin, #browsecollections {
  background-color: #2C2C2C;
  color: white;
  border: 1px white solid;
}

#nav {
  margin-top: 10px;
}
.search-form {
  display: flex;
  max-width: 500px; 
  margin: 0 auto; 
}

.search-form input[type="search"] {
  flex: 1; 
  border-radius: 20px 0 0 20px; 
  font-size: 16px;
  outline: none;
}

.search-form button {
  display: flex;
  justify-content: center; 
  align-items: center; 
  border-radius: 0 20px 20px 0;
  background-repeat: no-repeat;
  background-position: center;
  width: 100px; 
  height: 45px; 
  cursor: pointer;
  background-color: #FCEBB6;
  border: none; 
}

#search-icon {
  width: 30px; 
  height: auto; 
}
</style>
