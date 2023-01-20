import { defineStore } from 'pinia';

export const useModalStore = defineStore('modal', {
  state: () => ({ checklistCreate: false, todoCreate: false}),
  actions: {
    toggleChecklistCreateModal() {
          this.checklistCreate = !this.checklistCreate;
      },
      toggleTodoCreateModal() {
          this.todoCreate = !this.todoCreate;
    }
  },
})