<template>

  <div id="capstone-app">

    <header id="app-header">
      <h1 class="title">
        <router-link :to="{ name: 'home' }" class="title-link">Rabbit H<i
            class="fa-solid fa-compact-disc"></i>le</router-link>
      </h1>

          <!-- search bar to be added later  -->

     <!-- <div class="search-bar">
      <form @submit.prevent="handleSearch" class="search-form">
        <select id="collection-filter" @change="handleFilterChange">
        <option value=""></option>
        <option value="All">All</option>
        <option value="value1">Rock</option>
        <option value="value2">Jazz</option> 
        <option value="value3">Country</option>
        <option value="value4">Alternative</option>
       
      </select>
        <input type="search" id="search" name="q" placeholder="Search Collections">
        <button id="search-button" type="submit">
          <img id="search-icon" src="src/images/search_.png" alt="Search">
        </button>
      </form>
    </div> -->


    
      <nav id="header-buttons">
        <button  v-if="!isAuthenticated" :class="['header-register']" @click="toggleRegisterPopup">Register</button>
        <button  v-if="!isAuthenticated" :class="['header-login']" @click="togglePopup('login')">Login</button>
        <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </nav>

    </header>
    <body>    
      <Popup v-if="popupTriggers.login" @toggle-popup="togglePopup('login')"/>
    <RegisterPopup v-if="popupTriggers.register" @toggle-popup="toggleRegisterPopup"/>
  </body>

    <router-view />
    <footer>
      <p class="company-info">Contact Us | 1-800-339-6887 | 1776 Paper St, Springfield</p>
      <i class="logo"> <img class="logo-image" src="@/images/rabbit_.png" alt="logo"></i>
      <div class="social">
        <i class="fa-brands fa-facebook" style="color: #4460A0;"></i>
        <i class="insta-icon"> <img src="@/images/insta.png" alt=""></i>
        <i class="fa-brands fa-twitter" style="color: #74C0FC;"></i>
      </div>
    </footer>
  </div>


</template>

<script>
import Popup from './components/LoginPopup.vue'
import RegisterPopup from './components/RegisterPopup.vue';

export default {
  name: 'App',
  components: {
    Popup,
    RegisterPopup
  },
  data() {
    return {
      popupTriggers: {
        login: false,
        register: false
      }
    }
  },

  computed: {
    isAuthenticated() {
      return this.$store.state.token !== '';
    }
  },
  methods: {
    goTo(routeName) {
      this.$router.push({ name: routeName });
    },

    logout() {
      this.$store.commit('setToken', '');
      this.$store.commit('setUser', null);
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      this.$router.push({ name: 'login' });
    },
     togglePopup(trigger) {
      this.popupTriggers[trigger] = !this.popupTriggers[trigger];
    },
    toggleRegisterPopup() {
      this.popupTriggers.register = !this.popupTriggers.register;
    }
  }
}
</script>

<style scoped>
@font-face {
  font-family: 'RabbitFont';
  src: url('@/assets/fonts/RABBITZ HOLE_PERSONALUSEONLY.TTF') format('truetype');
}
.insta-icon img{
  display: flex;
  width: 30px; 
  height: 30px; 
  object-fit: contain; 
}

.logo {
  display: flex;
  width: 50px;
  height: 50px;
  object-fit: contain;
  color: grey;
}

#logo {
  text-decoration: none;
}

.fa-brands.fa-facebook {
  font-size: 30px;
}
.fa-brands.fa-twitter {
  font-size: 30px;
}
.fa-compact-disc{
  font-size: 45px;
}

.social {
  display: flex;
  justify-content: space-between;
  width: 180px;
  margin-right: 50px;
  margin-left: 180px;
}

.company-info {
  margin-left: 50px;
}
footer{
  display: flex;
  background-color: #FCEBB6;
  display: flex;
  justify-content: center;
  align-items: center;
  border-top: 2px solid black;
  height: 70px;
  margin-top: auto;
  justify-content: space-between;
}

.show {
  display: inline-block;
}
.hidden {
  display: none;
}
.title {
  grid-area: title;
  justify-self: baseline;
  justify-content: center;
  height: 70px;
  margin-left: 30px; 
}

#collection-filter {
  display: flex;
  border-radius: 20px 0 0 20px;
  width: 100px;
  height: 46px;
  cursor: pointer;
  background-color: #78c0A8;
  border: none;
  background-image: url('src/images/vinyl_.png');
  background-size: 40px 40px;
  background-position: center;
  background-repeat: no-repeat;
  border: black 2px solid;
}

header {
  background-color: black;
  height: 70px;
  text-align: left;
  align-content: center;
  padding: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
  border-bottom: 2px solid black;
}
#app-header {
  background-color: #FCEBB6;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "title search buttons";
  align-items: center;
  border-bottom: 2px solid black;
}

.search-bar {
  grid-area: search;

}
#capstone-app {
  display: flex;
  background-size: cover;
  position: relative;
  height: 100vh;
  flex-direction: column;
  background-size: cover;
}
#header-buttons {
  grid-area: buttons;
  display: flex;
  gap: 40px;
  justify-content: end;
  margin-right: 50px;
}
#my-library-font ,#my-collections-font, #my-friends-font {
  text-decoration: none;
  color: #78c0A8;
  text-shadow: -5px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

.title-link {
.title-link {  
  text-decoration: none;
  color: #78c0A8;
  font-family: 'RabbitFont';
  font-size: 90px;
  width: 400px;
  height: 50%;
  font-weight: 300;
  text-shadow: -6px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  border-bottom: ; 
}
h1 , h2 {
  font-family: 'RabbitFont';
  font-weight: 300;
  color: #78c0A8;
  text-shadow: -3px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
label {
  margin-right: 0.5rem;
  color: #FCEBB6;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
input[type="search"] {

  height: 46px;
  font-weight: 700;
  background-color: #FCEBB6;
  text-align: center;
  border-left: none;
  border-right: none;
  border-bottom: #000 2px solid;
}
.header-register, .header-login  {
  font-family: "Caprasimo",sans-serif;
  font-weight: 400; 
  background-color: #F07818;
  font-size: large;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  color: #FCEBB6;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
#logout {
  font-family: "Caprasimo", sans-serif;
  font-weight: 400;
  background-color: #F07818;
  font-size: large;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  color: #FCEBB6;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
  text-decoration: none;
  border: #000 2px solid;
}

#logout:hover {
  background-color: #F0A830; 
}
.header-login{
  width: 120px;;
}
.header-login:hover, .header-register:hover {
  background-color: #F0A830;
}
.search-form {
  display: flex;
  max-width: 500px;
  margin: 0 auto;
}
.search-form input[type="search"] {
  flex: 1;
  font-size: 16px;
  outline: none;
}
.search-form button {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 0 20px 20px 0;
  width: 100px;
  height: 46px;
  cursor: pointer;
  background-color: #78c0A8;
  border: black 2px solid;
}
#search-icon {
  width: 30px;
  height: auto; 
}
</style>
