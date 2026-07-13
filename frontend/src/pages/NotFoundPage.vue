<!-- src/pages/NotFoundPage.vue -->
<template>
  <div class="min-h-screen bg-white flex items-center justify-center px-6">
    <div class="text-center max-w-md">
      <div class="text-6xl font-bold text-gray-900 mb-4" style="font-family: Manrope, sans-serif;">
        404
      </div>
      <h1 class="text-2xl font-bold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">
        Page Not Found
      </h1>
      <p class="text-gray-600 mb-8" style="font-family: Inter, sans-serif;">
        Sorry, the page you're looking for doesn't exist or has been moved.
      </p>
      <RouterLink
        to="/"
        class="inline-block px-6 py-3 rounded-lg font-medium text-white transition-all hover:shadow-lg"
        style="background-color: #B00149; font-family: Inter, sans-serif;"
      >
        Back to Home
      </RouterLink>
    </div>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router'
</script>

<style scoped>
</style>