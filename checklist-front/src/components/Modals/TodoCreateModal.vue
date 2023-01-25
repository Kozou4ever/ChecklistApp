<script setup lang="ts">
import CrossIcon from '../Icons/CrossIcon.vue';
import { useModalStore } from '../../store/modalStore';
import { storeToRefs } from 'pinia';

const store = useModalStore();
const { todoCreate } = storeToRefs(store);
const { toggleTodoCreateModal } = store;
</script>

<template>
    <div id="defaultModal" aria-hidden="true"
        class="fixed grid h-screen place-items-center z-50 w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full"
        v-if="todoCreate">
        <div class="relative w-full h-full max-w-2xl md:h-auto">
            <div class="relative bg-white rounded-lg shadow">
                <div class="flex items-start justify-between p-4 border-b rounded-t">
                    <h3 class="text-xl font-semibold text-gray-900">
                        Créer un nouveau TODO pour
                    </h3>
                    <button type="button" @click="toggleTodoCreateModal()"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
                        data-modal-hide="defaultModal">
                        <CrossIcon />
                        <span class="sr-only">Fermer</span>
                    </button>
                </div>
                <div class="p-6 space-y-6">
                    <div class="mb-6">
                        <label for="text" class="block mb-2 text-sm font-medium text-gray-900">Nom
                            :</label>
                        <input type="text" id="text"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                            placeholder="Acheter du pain..." required>
                    </div>
                    <div class="mb-6">
                        <label for="message" class="block mb-2 text-sm font-medium text-gray-900">Description :</label>
                        <textarea id="message" rows="4"
                            class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
                            placeholder="Prendre pain à la Place St Cardon..."></textarea>
                    </div>
                    <div class="flex items-center justify-end space-x-2">
                        <button data-modal-hide="defaultModal" type="submit"
                            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Créer</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>