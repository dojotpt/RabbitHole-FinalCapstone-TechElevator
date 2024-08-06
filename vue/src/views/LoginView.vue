<template>
  
  
  <div class="login-container">
    <div class="blurred-background"></div>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button class="form-button" type="submit">Sign in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {
    
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

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

#password{
margin-left: 3px;
}

.form-button{
  background-color: #F0A830;
}

.form-button:hover{
  background-color: #F07818;
}
.login-container {
  display: flex;
  justify-content: flex-end;
/* Full viewport height */
}
.form-input-group {
  margin-bottom: 1rem;
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
#login {
  background: rgba(94, 65, 36, 0.9);
  width: 370px;
  border-radius: 10px;
  text-align: center;
  border: 2px solid black;
  
}
input{
  background-color: #FCEBB6;
  border-radius: 5px;
}
</style>