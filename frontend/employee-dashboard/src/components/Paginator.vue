<script setup>
defineProps({
  pageDetails: {
    type: Object,
    currentPage: {
      type: Number,
      required: true,
    },
    totalPages: {
      type: Number,
      required: true,
    },

    required: true,
  },
});

const emit = defineEmits(["pageChange"]);

const changePage = (newPage) => {
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
