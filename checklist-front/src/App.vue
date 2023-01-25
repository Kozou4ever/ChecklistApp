<script setup lang="ts">
import AuthentificationView from './views/AuthentificationView.vue';
import MainView from './views/MainView.vue';
import { useAuthStore } from './store/authStore';
import { storeToRefs } from 'pinia';

const store = useAuthStore();
const { isLogged } = storeToRefs(store);
</script>

<template>
  <div>
    <MainView v-if="isLogged" />
    <AuthentificationView v-else />
  </div>
</template>