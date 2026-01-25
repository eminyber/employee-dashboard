<script setup lang="ts">
const emit = defineEmits<{ sortOrderChanged: [sortorderValue: string] }>();

const sortOrderChanged = (sortorderValue: string) => {
  emit("sortOrderChanged", sortorderValue);
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
            @change="
              sortOrderChanged(($event.target as HTMLInputElement).value)
            "
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
            @change="
              sortOrderChanged(($event.target as HTMLInputElement).value)
            "
          />
          Descending
        </label>
      </li>
    </ul>
  </div>
</template>

<style scoped></style>
