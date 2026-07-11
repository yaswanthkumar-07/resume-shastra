<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

function start() {
  router.push("/builder");
}
</script>

<template>
  <div class="min-h-screen flex items-center justify-center bg-slate-100">
    <div class="text-center">
      <h1 class="text-6xl font-bold text-blue-600">
        ResumeShastra
      </h1>

      <p class="mt-4 text-xl text-gray-600">
        Build. Optimize. Apply.
      </p>

      <button
        @click="start"
        class="mt-10 rounded-xl bg-blue-600 px-8 py-3 text-white hover:bg-blue-700"
      >
        Start Building
      </button>
    </div>
  </div>
</template>