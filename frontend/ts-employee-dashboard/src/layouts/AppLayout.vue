<script setup lang="ts">
import NavBar from "../components/NavBar.vue";
</script>
<template>
  <div class="flex flex-col min-h-screen overflow-auto">
    <nav-bar />
    <div class="flex-1 bg-gray-300">
      <router-view />
    </div>
  </div>
</template>
