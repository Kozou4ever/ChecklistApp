import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
  state: () => ({ isLogged: false}),
  actions: {
    changeLogState() {
      this.isLogged = !this.isLogged;
    }
  },
})