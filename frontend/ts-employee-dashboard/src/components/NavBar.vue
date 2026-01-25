<script setup lang="ts">
import { useRouter, type Router } from "vue-router";

const router: Router = useRouter();

const navigate = (routeName: string) => {
  router.push({ name: routeName });
};
</script>

<template>
  <div class="navbar bg-base-200 shadow-sm space-x-4">
    <a class="btn btn-ghost text-xl" @click="navigate('employees')"
      >Employees</a
    >
    <a class="btn btn-ghost text-xl" @click="navigate('dashboard')"
      >Dashboard</a
    >
  </div>
</template>

<style scoped></style>
