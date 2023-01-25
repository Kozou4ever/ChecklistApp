import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
  state: () => ({ isLogged: false}),
  actions: {
  },
})