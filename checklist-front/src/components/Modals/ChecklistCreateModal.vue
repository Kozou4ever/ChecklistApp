<script setup lang="ts">
import CrossIcon from '../Icons/CrossIcon.vue';
import { useModalStore } from '../../store/modalStore';
import { storeToRefs } from 'pinia';

const store = useModalStore();
const { checklistCreate } = storeToRefs(store);
const { toggleChecklistCreateModal } = store;
</script>

<template>
    <div id="defaultModal" tabindex="-1" aria-hidden="true"
        class="fixed grid h-screen place-items-center z-50 w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full"
        v-if="checklistCreate">
        <div class="relative w-full h-full max-w-2xl md:h-auto">
            <div class="relative bg-white rounded-lg shadow">
                <div class="flex items-start justify-between p-4 border-b rounded-t">
                    <h3 class="text-xl font-semibold text-gray-900">
                        Créer une nouvelle liste de TODO
                    </h3>
                    <button type="button" @click="toggleChecklistCreateModal()"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center "
                        data-modal-hide="defaultModal">
                        <CrossIcon />
                        <span class="sr-only">Fermer</span>
                    </button>
                </div>
                <div class="p-6 space-y-6">
                    <div class="mb-6">
                        <label for="email" class="block mb-2 text-sm font-medium text-gray-900">Nom :</label>
                        <input type="email" id="email"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                            placeholder="Liste des courses à faire..." required>
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
