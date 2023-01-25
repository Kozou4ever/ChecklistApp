<script setup lang="ts">
import EditIcon from '../Icons/EditIcon.vue'
import DeleteIcon from '../Icons/DeleteIcon.vue';
import ChevronIcon from '../Icons/ChevronIcon.vue';
import { ref } from 'vue';

const isDesc = ref(false);

const showDesc = () => isDesc.value = !isDesc.value;
</script>

<template>
    <div class="form-check py-5 px-2 border-t border-slate-300">
      <div class="flex flex-row justify-between">
        <div>
          <input
            class="form-check-input h-4 w-4 border border-gray-300 rounded-sm bg-white checked:bg-blue-600 checked:border-blue-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
            type="checkbox" value="" id="flexCheckChecked">
          <label class="form-check-label inline-block text-gray-800" for="flexCheckChecked">
            Acheter du pain
          </label>
        </div>
        <div class="flex flex-row gap-2">
          <EditIcon />
          <DeleteIcon />
          <ChevronIcon @click="showDesc()" :class="isDesc ? 'rotate-180' : ''"/>
        </div>
      </div>
      <div class="transition ease-out duration-300 mt-2" v-if="isDesc">
        <p class="text-sm text-slate-600 indent-5 ">Une description très bien détaillée</p>
      </div>
    </div>
</template>