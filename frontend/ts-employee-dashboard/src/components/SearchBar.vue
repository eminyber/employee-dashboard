<script setup lang="ts">
const emit = defineEmits<{ search: [searchWords: string] }>();

const search = (searchWords: string) => {
  emit("search", searchWords);
};
</script>
<template>
  <form class="py-3 px-4 flex items-center">
    <fieldset class="fieldset">
      <label class="input">
        <svg
          class="h-[1em] opacity-50"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 24 24"
        >
          <g
            stroke-linejoin="round"
            stroke-linecap="round"
            stroke-width="2.5"
            fill="none"
            stroke="currentColor"
          >
            <circle cx="11" cy="11" r="8"></circle>
            <path d="m21 21-4.3-4.3"></path>
          </g>
        </svg>
        <input
          type="search"
          placeholder="Search Employees"
          v-on:input="search(($event.target as HTMLInputElement).value)"
        />
      </label>
    </fieldset>
  </form>
</template>

<style scoped></style>
