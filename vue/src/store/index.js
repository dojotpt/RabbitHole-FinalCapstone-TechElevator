import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      myLibrary: {
        albums: [] //collection of albums
      }
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_LIBRARY(state, myLibrary) {
        state.myLibrary = myLibrary;
      },
      SET_ALBUM(state, album) {
        state.album = album;
      },
      SET_ALBUM_COLLECTION(state, albumcollection) {
        state.albumcollection = albumcollection;
      },
      SET_COLLECTIONS(state, collections) {
        state.collections = collections;
      },
    },
  });
  return store;
}
