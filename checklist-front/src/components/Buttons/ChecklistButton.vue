<script setup lang="ts">
defineProps({
    name: String
})
</script>

<template>
    <button type="button"
        class="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 min-w-max">{{ name }}</button>
</template>