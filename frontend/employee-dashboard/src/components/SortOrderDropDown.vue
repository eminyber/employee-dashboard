<script setup>
const emit = defineEmits(["sortOrderChanged"]);

const sortOrderChanged = (e) => {
  emit("sortOrderChanged", e.target.value);
};
</script>

<template>
  <div class="dropdown dropdown-hover">
    <div
      tabindex="0"
      role="button"
      class="btn input flex items-center justify-center"
    >
      Change Sort Order
    </div>
    <ul
      tabindex="-1"
      class="dropdown-content menu bg-base-100 rounded-box z-1 w-52 p-2 shadow-sm"
    >
      <li>
        <label class="cursor-pointer flex items-center">
          <input
            class="mr-2"
            type="radio"
            name="sortOrder"
            value="asc"
            @change="sortOrderChanged"
            checked
          />
          Ascending
        </label>
      </li>

      <li>
        <label class="cursor-pointer flex items-center">
          <input
            class="mr-2"
            type="radio"
            name="sortOrder"
            value="desc"
            @change="sortOrderChanged"
          />
          Descending
        </label>
      </li>
    </ul>
  </div>
</template>

<style scoped></style>
