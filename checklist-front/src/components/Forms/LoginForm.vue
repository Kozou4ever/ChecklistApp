<script setup lang="ts">
import { ref } from 'vue';
import AuthService from "@/services/AuthService";
import Auth from '@/types/auth/Auth';
import AuthResponse from '@/types/auth/AuthResponse';
import { useAuthStore } from '@/store/authStore';
import { storeToRefs } from 'pinia';
import SignupModal from '../Modals/SignupModal.vue';
import { AxiosError, AxiosResponse } from 'axios';

const store = useAuthStore();
let { isLogged } = storeToRefs(store);

const username = ref('');
const password = ref('');
const signup = ref(false);
const badCredits = ref(false);

const showSignupForm = () => signup.value = !signup.value

const login = () => {
    let data: Auth = {
        username: username.value,
        password: password.value
    };
    AuthService.signin(data).then((response: AuthResponse) => {
        isLogged.value = true;
        console.log(response);
    }).catch((e: AxiosError<AxiosResponse>) => {
        if (e.response?.data.status == 401) {
            badCredits.value = true
        }
        console.log(e)
    })
}


</script>

<template>

    <form v-on:submit.prevent="login" class="py-24 w-auto">
        <div v-if="badCredits" class="p-4 mb-4 text-sm text-red-800 rounded-lg bg-red-50" role="alert">
            <span class="font-medium">Oops!</span> L'utilisateur ou le mot de passe ne sont pas corrects :/
        </div>
        <div class="mb-6">
            <label for="text" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ton pseudo</label>
            <input v-model="username" type="text" id="text"
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-96 p-2.5 "
                placeholder="Kathy..." required>
        </div>
        <div class="mb-6">
            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Ton mot de
                passe</label>
            <input v-model="password" type="password" id="password"
                class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-96 p-2.5"
                placeholder="M0nSup3rbeP@ssw0rd" required>
        </div>
        <div class="flex items-start mb-6">
            <p>Pas de compte ? <a @click="showSignupForm()"
                    class="text-blue-500 hover:text-blue-700 cursor-pointer">Clique ici</a></p>
        </div>
        <button type="submit"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">Se
            connecter</button>
    </form>
    <SignupModal v-if="signup" />

</template>