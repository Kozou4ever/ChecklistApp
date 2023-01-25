<script setup lang="ts">
import { ref } from 'vue';
import SignupForm from '../Forms/SignupForm.vue';
import CrossIcon from '../Icons/CrossIcon.vue';

const close = ref(false);

const isClose = () => close.value = !close.value
</script>

<template>
    <div id="defaultModal" tabindex="-1" aria-hidden="true"
        class="fixed grid h-screen place-items-center z-50 w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full"
        :class="close ? 'hidden' : ''">
        <div class="relative w-full h-full max-w-2xl md:h-auto">
            <div class="relative bg-white rounded-lg shadow">
                <div class="flex items-start justify-between p-4 border-b rounded-t ">
                    <h3 class="text-xl font-semibold text-gray-900 ">
                        Créer un compte
                    </h3>
                    <button type="button" @click="isClose()"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center "
                        data-modal-hide="defaultModal">
                        <CrossIcon />
                        <span class="sr-only">Fermer</span>
                    </button>
                </div>
                <SignupForm />

            </div>
        </div>
    </div>
</template>