<script setup>
defineProps({
  employees: {
    type: Array,
    required: true,
  },
});

const emit = defineEmits(["sortBy"]);

const sortBy = (column) => {
  emit("sortBy", column);
};
</script>

<template>
  <div
    class="m-1 overflow-x-auto rounded-box border border-base-content/5 bg-base-100"
  >
    <table class="table table-fixed min-w-full">
      <thead>
        <tr class="bg-gray-200 text-black">
          <th
            class="w-16 px-4 py-2 text-left cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('id')"
          >
            ID
          </th>
          <th
            class="px-4 py-2 text-left cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('firstName')"
          >
            First Name
          </th>
          <th
            class="px-4 py-2 text-left cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('lastName')"
          >
            Last Name
          </th>
          <th
            class="px-4 py-2 text-left cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('email')"
          >
            Email
          </th>
          <th
            class="px-4 py-2 text-left cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('jobTitle')"
          >
            Job Title
          </th>
          <th class="px-4 py-2 text-left">Projects</th>
          <th
            class="px-4 py-2 text-right cursor-pointer hover:bg-gray-300"
            @click="() => sortBy('employedDate')"
          >
            Employed Date
          </th>
        </tr>
      </thead>

      <tbody>
        <tr
          v-for="employee in employees"
          :key="employee.id"
          class="hover:bg-gray-10"
        >
          <td class="px-4 py-2">{{ employee.id }}</td>
          <td class="px-4 py-2">
            {{ employee.firstName }}
          </td>
          <td class="px-4 py-2">
            {{ employee.lastName }}
          </td>
          <td class="px-4 py-2">
            {{ employee.email }}
          </td>
          <td class="px-4 py-2">
            {{ employee.jobTitle.title }}
          </td>
          <td class="px-4 py-2">
            <span v-if="employee.projects && employee.projects.length > 0">
              {{ employee.projects.map((project) => project.name).join(", ") }}
            </span>
            <span v-else>No projects</span>
          </td>
          <td class="px-4 py-2 text-right">{{ employee.employedDate }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped></style>
