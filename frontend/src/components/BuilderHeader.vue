<!-- src/components/BuilderHeader.vue -->
<template>
  <header class="sticky top-0 z-40 bg-white border-b border-gray-200">
    <div class="px-6 py-2">
      <div class="flex items-center justify-between gap-6 mb-4">
        <div class="flex items-center gap-2">
          <div class="w-7 h-7 bg-gradient-to-br from-red-600 to-red-700 rounded-lg flex items-center justify-center">
            <span class="text-white font-bold text-lg">R</span>
          </div>
          <div>
            <h1 class="text-lg font-semibold text-gray-900" style="font-family: Manrope, sans-serif;">ResumeShastra</h1>
            <p class="text-xs text-gray-500">Build. Optimize. Apply.</p>
          </div>
        </div>

        <div class="flex items-center gap-3">
          <button
            @click="$emit('save')"
            :disabled="loading"
            class="px-4 py-2 text-sm font-medium text-gray-700 bg-gray-50 hover:bg-gray-100 rounded-lg transition-colors disabled:opacity-50 disabled:cursor-not-allowed flex items-center gap-2"
          >
            <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
            </svg>
            <span class="hidden sm:inline">Save Draft</span>
            <span class="sm:hidden">Save</span>
          </button>

          <button
            @click="$emit('export')"
            class="px-4 py-2 text-sm font-medium text-white rounded-lg transition-colors flex items-center gap-2"
            style="background-color: #B00149;"
          >
            <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 19l9 2-9-18-9 18 9-2zm0 0v-8" />
            </svg>
            <span class="hidden sm:inline">Export PDF</span>
            <span class="sm:hidden">Export</span>
          </button>
        </div>
      </div>

      <div class="space-y-2">
        <div class="flex items-center justify-between">
          <span class="text-sm font-medium text-gray-600" style="font-family: Inter, sans-serif;">
            {{ currentStepLabel }}
          </span>
          <span class="text-sm font-medium text-gray-600">
            <span class="text-gray-900 font-semibold">{{ currentStep }}</span> of <span class="text-gray-900 font-semibold">5</span>
          </span>
        </div>

        <div class="w-full h-1.5 bg-gray-100 rounded-full overflow-hidden">
          <div
            :style="{ width: (currentStep / 5) * 100 + '%' }"
            class="h-full transition-all duration-500 ease-out rounded-full"
            style="background-color: #B00149;"
          />
        </div>
      </div>
    </div>
  </header>
</template>

<script setup>
defineProps({
  currentStep: {
    type: Number,
    default: 1,
    validator: (val) => val >= 1 && val <= 5
  },
  currentStepLabel: {
    type: String,
    default: 'Personal Details'
  },
  loading: {
    type: Boolean,
    default: false
  }
})

defineEmits(['save', 'export'])
</script>

<style scoped>
header {
  background-color: #FFFFFF;
}
</style>