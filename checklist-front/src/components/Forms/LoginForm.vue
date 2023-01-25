<script setup lang="ts">
import { ref } from 'vue';
import http from "@/http-common";
import AuthService from "@/services/AuthService";
import Auth from '@/types/auth/Auth';
import AuthResponse from '@/types/auth/AuthResponse';
import { useAuthStore } from '@/store/authStore';
import { storeToRefs } from 'pinia';

const store = useAuthStore();
let { isLogged } = storeToRefs(store);

const User = ref('');
const Pwd = ref('');

const login = () => {
    let data: Auth = {
        username: User.value,
        password: Pwd.value
    };
    AuthService.signin(data).then((response: AuthResponse) => {
        isLogged.value = true;
    }).catch((e: Error) => {
        console.error(e);
    })
}


</script>

<template>
    <form v-on:submit.prevent="login" class="p-24 ">
        <div class="mb-6">
            <label for="text" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ton pseudo</label>
            <input v-model="User" type="text" id="text"
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 "
                placeholder="Kathy..." required>
        </div>
        <div class="mb-6">
            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ton mot de passe</label>
            <input v-model="Pwd" type="password" id="password"
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="M0nSup3rbeP@ssw0rd" required>
        </div>
        <div class="flex items-start mb-6">
            <p>Pas de compte ? <a href="" class="text-blue-500 hover:text-blue-700">Clique ici</a></p>
        </div>
        <button type="submit"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">Se connecter</button>
    </form>

</template>