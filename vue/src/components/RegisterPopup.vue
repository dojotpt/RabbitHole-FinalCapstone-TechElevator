<template>
    <div class="popup">
      <div class="popup-inner">
        <div class="register-container">
          <div class="blurred-background"></div>
          <div id="register" class="text-center">
            <form @submit.prevent="register">
              <h1>Create Account</h1>
              <div role="alert" v-if="registrationErrors">
                {{ registrationErrorMsg }}
              </div>
              <div class="form-input-group">
                <label for="username">Username</label>
                <input type="text" id="username" v-model="user.username" required autofocus />
              </div>
              <div class="form-input-group">
                <label id="passwordText" for="password">Password</label>
                <input type="password" id="password" v-model="user.password" required />
              </div>
              <div class="form-input-group">
                <label id="confirmText" for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
              </div>
              <div>
                <label for="premium">Premium</label>
                <input type="checkbox" id="premium" v-model="user.role" />
              </div>
              
              <button class="form-button" type="submit">Create Account</button>
              <button class="form-button-cancel" @click="handleClose">Cancel</button>
              
              <!-- <p><router-link  id="hyperlink" :to="{ name: 'login' }">Already have an account? Log in.</router-link></p> -->
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
          username: '',
          password: '',
          confirmPassword: '',
          role: 'user',
        },
        registrationErrors: false,
        registrationErrorMsg: 'There were problems registering this user.',
      };
    },
    methods: {
        handleClose() {
      this.$emit('toggle-popup');
    },
    
      register() {
        if (this.user.password !== this.user.confirmPassword) {
          this.registrationErrors = true;
          this.registrationErrorMsg = 'Password & Confirm Password do not match.';
        } else {
          authService
            .register(this.user)
            .then((response) => {
              if (response.status === 201) {
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
                this.$router.push({
                  path: '/',
                  query: { registration: 'success' },
                  
                });
              }
              this.$emit('toggle-popup');
            })
            .catch((error) => {
              const response = error.response;
              this.registrationErrors = true;
              if (response.status === 400) {
                this.registrationErrorMsg = 'User name already taken.';
              }
            });
        }
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

  #confirmPassword{
 margin-right: 56px;
}
#password{
margin-left: 3px;
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
.form-button-cancel {
    margin-right: 20px;
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

.form-button:hover{
  background-color: #F0A830;
}
.form-button-cancel:hover{
  background-color: #F0A830;
}
.form-input-group {
  margin-bottom: 1rem;
}
.register-container {
    font-family: 'RabbitFont';
  color: #78c0a8;
  display: flex;
  margin-top: 100px;
  margin-right: 10px;
  text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}
label {
font-size: 1.3rem;
margin-right: 0.5rem;
text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -1px 1px 0 #000, 1px 1px 0 #000;
}

#register {
    background: #fcebb6;
  width: 385px;
  height: 283px;
  border-radius: 10px;
  text-align: center;
  border: 2px solid black;
  
  

  
}

#hyperlink {
  color: #f07818;
  font-size: 20px;
  text-decoration: none;
  font-family: "Caprasimo", sans-serif;
}
input{
  background-color: #FCEBB6;
  border-radius: 5px;
}
#premium{
  margin-bottom: 20px;
}


  </style>