<script setup lang="ts">
import AddButton from '../components/Buttons/AddButton.vue';
import CheckTodo from '../components/Checkbox/CheckTodo.vue';
import ChecklistButton from '../components/Buttons/ChecklistButton.vue';
import ChecklistCreateModal from '../components/Modals/ChecklistCreateModal.vue';
import TodoCreateModal from '../components/Modals/TodoCreateModal.vue';

import { useModalStore } from '../store/modalStore';
import { storeToRefs } from 'pinia';
import LogoutIcon from '@/components/Icons/LogoutIcon.vue';
import { useAuthStore } from '@/store/authStore';

const modalStore = useModalStore();
const authStore = useAuthStore();

const { checklistCreate, todoCreate } = storeToRefs(modalStore);
let { isLogged } = storeToRefs(authStore);

const { toggleChecklistCreateModal, toggleTodoCreateModal } = modalStore;

const changeLogState = () => isLogged.value = !isLogged.value

</script>

<template>
    <div class="min-h-screen flex" :class="checklistCreate || todoCreate ? 'blur' : ''">
        <div class="w-56 flex flex-col justify-between border-r border-black p-4">
            <div class="flex flex-col">
                <AddButton @click="toggleChecklistCreateModal()" class="self-end" />
                <div class="space-y-2 flex flex-col mt-6">
                    <ChecklistButton name="Checklist1" />
                    <ChecklistButton name="Checklist1" />
                    <ChecklistButton name="Checklist1" />
                    <ChecklistButton name="Checklist1" />
                </div>
            </div>
            <div class="flex">
                <button @click="changeLogState()"><LogoutIcon class="self-end" /></button>
            </div>
        </div>

        <main class="flex-1 min-w-0 p-12">
            <div class="flex flex-row justify-between">
                <h1 class="font-bold text-6xl mb-12 break-all max-w-xl">Liste des courses </h1>
                <AddButton class="ml-5" @click="toggleTodoCreateModal()" />
            </div>

            <CheckTodo />
            <CheckTodo />
            <CheckTodo />
        </main>
    </div>
    <ChecklistCreateModal />
    <TodoCreateModal />
</template>