<script setup lang="ts">
import { ref, onMounted } from "vue";
import { useFetchHiresAGivenYear } from "../composables/useFetchHiresAGivenYear";
import type { Ref } from "vue";

import OneYearLineGraph from "../components/graphs/OneYearLineGraph.vue";

const year: Ref<number> = ref(2022);

const { hireData, loading, error, fetchHiresAGivenYear } =
  useFetchHiresAGivenYear();

const handleYearChange = () => {
  fetchHiresAGivenYear(year.value);
};

onMounted(() => fetchHiresAGivenYear(year.value));
</script>

<template>
  <div
    v-if="loading && !error"
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-80 grid place-items-center"
  >
    <h1 class="text-xl font-medium">Loading...</h1>
  </div>

  <!--Show simple div on error. Change to toast if time permits it-->
  <div
    v-else-if="error && !loading"
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-80 grid place-items-center"
  >
    <h1 class="text-xl font-medium text-red-800">{{ error }}</h1>
  </div>

  <div v-else class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow">
    <div class="flex justify-start items-center mb-10">
      <label>Choose Year:</label>
      <input
        type="number"
        min="2000"
        max="2026"
        step="1"
        v-model="year"
        placeholder="YYYY"
        class="input ml-1"
      />
      <button class="btn ml-4" @click="handleYearChange">
        View Yearly Hires
      </button>
    </div>
    <OneYearLineGraph :data="hireData || []" :year="year" />
  </div>
</template>
