<template>
  <div id="capstone-app">
    <div class="blurred-background"></div>
    <header id="app-header">
      <h1 class="title">
        <router-link :to="{ name: 'home' }" class="title-link">Rabbit Hole</router-link>
      </h1>
      <h2 class="my-buttons">
        <router-link id="my-library-font" :to="{ name: 'my-library' }">My Library </router-link>
        <router-link id="my-collections-font" :to="{ name: 'my-collections' }">My Collections </router-link>
        <router-link id="my-friends-font" :to="{ name: 'my-friends' }">My Friends </router-link>
      </h2>
      <div class="search-bar">
        <form @submit.prevent="handleSearch" class="search-form">
          <select id="collection-filter" v-model="selectedFilter" @change="handleFilterChange">
            <option value=""></option>
            <option value="All">All</option>
            <option value="value1">Rock</option>
            <option value="value2">Jazz</option>
            <option value="value3">Country</option>
            <option value="value4">Alternative</option>

          </select>
          <input type="search" v-model="searchQuery" id="search" name="q" placeholder="Search Collections">
          <button id="search-button" type="submit">
            <img id="search-icon" src="@/images/search_.png" alt="Search">
          </button>
        </form>
      </div>
      <nav id="header-buttons">
        <button :class="['header-register', { show: !isAuthenticated, hidden: isAuthenticated }]"
          @click="goTo('register')">Register</button>
        <button :class="['header-login', { show: !isAuthenticated, hidden: isAuthenticated }]"
          @click="goTo('login')">Login</button>
        <button v-if="isAuthenticated" id="logout" @click="logout()">Logout</button>
        <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      </nav>

    </header>




    <router-view />

  </div>

</template>

<script>
import CollectionService from './services/CollectionService';

export default {
  name: 'App',
  data() {
    return {
    };
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

.show {
  display: inline-block;
}

.hidden {
  display: none;
}

.title {
  grid-area: title;
}

#collection-filter {
  display: flex;
  border-radius: 20px 0 0 20px;
  width: 100px;
  height: 45px;
  cursor: pointer;
  background-color: #FCEBB6;
  border: none;
  background-image: url('src/images/vinyl_.png');
  background-size: 40px 40px;
  background-position: center;
  background-repeat: no-repeat;

}

header {
  background-color: rgba(94, 65, 36, 0.9);
  height: 120px;
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
  background-color: rgba(94, 65, 36, 0.9);
  height: 180px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;

  grid-template-areas:
    "title search buttons"
    "title library buttons";
  /* My Library spans all columns at the bottom */
  align-items: center;
  /* Center elements vertically */
  border-bottom: 2px solid black;
}

.search-bar {
  grid-area: search;
  align-self: end;
}

#capstone-app {
  position: relative;
  height: 100vh;
  display: flex;
  flex-direction: column;
  overflow: hidden;
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



#header-buttons {
  grid-area: buttons;
  display: flex;
  gap: 40px;
  justify-content: end;
  align-items: end;


}

.my-buttons {
  display: flex;
  grid-area: library;
  font-size: 45px;
  justify-content: space-around;
  align-items: end;
  justify-items: end;


}

#my-library-font,
#my-collections-font,
#my-friends-font {
  text-decoration: none;
  color: #78c0A8;
  text-shadow: -5px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;


}


.title-link {
  text-decoration: none;
  color: #78c0A8;
  font-family: 'RabbitFont';
  font-size: 90px;
  width: 400px;
  height: 50%;
  font-weight: 300;
  text-shadow: -5px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}





h1,
h2 {
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
}

button {
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  opacity: 1;
}

.header-register,
.header-login {
  background-color: #F07818;

}

.header-login:hover,
.header-register:hover {
  background-color: #F0A830;

}

#headerlogin,
#browsecollections {
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

  font-size: 16px;
  outline: none;
}

.search-form button {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 0 20px 20px 0;
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

.collection-container {
  margin-top: 20px;
  background-color: rgba(94, 65, 36, 0.9);
  /* Slight background color for visibility */
  border: #000 solid 2px;
  border-radius: 10px;
  width: 400px;
}
</style>
