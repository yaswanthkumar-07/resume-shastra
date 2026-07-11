<script setup>
import { ref, onMounted } from "vue";
import api from "./services/api";

const status = ref("Connecting...");

onMounted(async () => {
  try {
    const response = await api.get("/health");
    status.value = `${response.data.project} Backend Connected ✅`;
  } catch (error) {
    status.value = "Backend Connection Failed ❌";
    console.error(error);
  }
});
</script>

<template>
  <div class="min-h-screen flex items-center justify-center bg-slate-100">
    <div class="bg-white p-10 rounded-2xl shadow-xl text-center w-[420px]">
      <h1 class="text-4xl font-bold text-blue-600">
        ResumeShastra
      </h1>

      <p class="mt-4 text-gray-600">
        Build. Optimize. Apply.
      </p>

      <div class="mt-8 text-lg font-medium">
        {{ status }}
      </div>
    </div>
  </div>
</template>