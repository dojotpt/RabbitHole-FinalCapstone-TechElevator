<template>
  <div class="register-container">
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register">
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
        <input  type="checkbox" id="premium" v-model="user.role">
        
      </div>
      <button class="form-button" type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
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
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#confirmPassword{
 margin-right: 56px;
}
#password{
margin-left: 3px;
}
.form-button{
  background-color: #F0A830;
  margin-top: 20px;
}

.form-button:hover{
  background-color: #F07818;
}
.form-input-group {
  margin-bottom: 1rem;
}
.register-container {
  display: flex;
  justify-content: flex-end;
}
label {
  margin-right: 0.5rem;
}
#register {
  display: flex;
  background: rgba(94, 65, 36, 0.9);
  width: 370px;
  border-radius: 10px;
  text-align: center;
  justify-content: center;
  border: 2px solid black;
  
  

  
}
input{
  background-color: #FCEBB6;
  border-radius: 5px;
}


</style>
