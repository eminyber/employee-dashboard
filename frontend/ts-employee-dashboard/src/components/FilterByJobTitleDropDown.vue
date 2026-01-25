<script setup lang="ts">
import { onMounted, ref } from "vue";
import { useFetchJobTitles } from "../composables/useFectchJobTitles";

const { jobTitles, loading, error, fetchJobTitles } = useFetchJobTitles();

const emit = defineEmits<{ filter: [filterStrings: string[]] }>();

const appliedFilters = ref<string[]>([]);

const filter = (jobTitle: string): void => {
  if (appliedFilters.value.includes(jobTitle)) {
    appliedFilters.value.splice(appliedFilters.value.indexOf(jobTitle), 1);
  } else {
    appliedFilters.value.push(jobTitle);
  }

  emit("filter", appliedFilters.value);
};

onMounted(fetchJobTitles);
</script>

<template>
  <div class="dropdown dropdown-hover">
    <div
      tabindex="0"
      role="button"
      class="btn input flex items-center justify-center"
    >
      Filter By JobTitles
    </div>

    <ul
      v-if="(jobTitles ?? []).length > 0 && !error && !loading"
      class="dropdown-content menu bg-base-100 rounded-box z-1 w-52 p-2 space-y-2 shadow-sm"
    >
      <li v-for="jobTitle in jobTitles" :key="jobTitle.id">
        <label class="flex items-center gap-2 cursor-pointer">
          <input
            @change="filter(($event.target as HTMLInputElement).value)"
            type="checkbox"
            :value="jobTitle.id"
            class="checkbox checkbox-sm"
          />
          <span class="text-sm font-medium">
            {{ jobTitle.title }}
          </span>
        </label>
      </li>
    </ul>
  </div>
</template>

<style scoped></style>
