<template>
  <div class="popup">
    <div class="popup-inner">
      <div class="login-container">
        <div class="blurred-background"></div>
        <div id="login">
          <form @submit.prevent="loginAndClose">
            <h1>Please Sign In</h1>
            <div role="alert" v-if="invalidCredentials">
              Invalid username and password!
            </div>
            <div role="alert" v-if="$route.query.registration">
              Thank you for registering, please sign in.
            </div>
            <div class="form-input-group">
              <label for="username">Username</label>
              <input type="text" id="username" v-model="user.username" required/>
            </div>
            <div class="form-input-group">
              <label for="password">Password</label>
              <input type="password" id="password" v-model="user.password" required />
            </div>
            <button class="form-button" @click="handleClose">Cancel</button>
            <button class="form-button" type="submit">Sign in</button>
            <p>
              <router-link id="hyperlink" :to="{ name: 'register' }">Need an account? Sign up.</router-link>
            </p>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  props: ['togglePopup'],

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
    handleClose() {
      this.$emit('toggle-popup');
    },

    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status === 200) {
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
    },

    loginAndClose() {
      this.login(); // Call the login method
      this.handleClose(); // Call the handleClose method
    }
  }
};
</script>

<style scoped>
.popup {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  backdrop-filter: blur(4px);
  display: flex;
  align-self: center;
  justify-content: flex-end;
  height: 100%;
  width: 100%;
}

.form-button {
  font-family: "Caprasimo", sans-serif;
  font-weight: 400;
  background-color: #f07818;
  font-size: large;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 10px;
  color: #fcebb6;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

.form-button:hover {
  background-color: #f07818;
}

.login-container {
  font-family: 'RabbitFont';
  color: #78c0a8;
  display: flex;
  margin-top: 100px;
  margin-right: 10px;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

#hyperlink {
  color: #f07818;
  font-size: 20px;
  text-decoration: none;
  font-family: "Caprasimo", sans-serif;
}

.form-input-group {
  margin-bottom: 1rem;
}

label {
  font-size: 1.5rem;
  margin-right: 0.5rem;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

#login {
  background: #fcebb6;
  width: 370px;
  border-radius: 10px;
  text-align: center;
  border: 2px solid black;
}

input {
  background-color: #fcebb6;
  border-radius: 5px;
}
</style>
