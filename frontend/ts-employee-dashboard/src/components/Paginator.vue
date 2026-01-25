<script setup lang="ts">
defineProps<{
  pageDetails: {
    currentPage: number;
    totalPages: number;
  };
}>();

const emit = defineEmits<{
  pageChange: [page: number];
}>();

const changePage = (newPage: number) => {
  emit("pageChange", newPage);
};
</script>

<template>
  <div class="join grid grid-cols-2">
    <button
      class="join-item btn btn-outline"
      :disabled="pageDetails.currentPage === 1"
      @click="() => changePage(pageDetails.currentPage - 1)"
    >
      Previous page
    </button>

    <button
      class="join-item btn btn-outline"
      :disabled="pageDetails.currentPage === pageDetails.totalPages"
      @click="() => changePage(pageDetails.currentPage + 1)"
    >
      Next
    </button>
  </div>
</template>

<style scoped></style>
