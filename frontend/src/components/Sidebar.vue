<!-- src/components/Sidebar.vue -->
<template>
  <aside class="hidden lg:flex flex-col w-56 bg-white border-r border-gray-200 p-5 space-y-6">
    <!-- Steps List -->
    <nav class="space-y-3">
      <button
        v-for="step in steps"
        :key="step.id"
        @click="$emit('navigate', step.id)"
        :class="[
          'w-full text-left px-4 py-3 rounded-lg transition-all duration-200',
          currentStep === step.id
            ? 'bg-red-50 border border-red-200'
            : 'hover:bg-gray-50 border border-transparent'
        ]"
      >
        <div class="flex items-start gap-3">
          <!-- Step Number Circle -->
          <div
            :class="[
              'flex-shrink-0 w-8 h-8 rounded-full flex items-center justify-center text-sm font-semibold transition-all',
              currentStep === step.id
                ? 'text-white'
                : 'bg-gray-100 text-gray-600'
            ]"
            :style="currentStep === step.id ? { backgroundColor: '#B00149' } : {}"
          >
            <span v-if="!completedSteps.includes(step.id)">{{ step.number }}</span>
            <svg v-else class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
              <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
            </svg>
          </div>

          <!-- Step Info -->
          <div class="flex-1 min-w-0">
            <p
              :class="[
                'text-sm font-medium transition-colors',
                currentStep === step.id ? 'text-gray-900' : 'text-gray-700'
              ]"
              style="font-family: Manrope, sans-serif;"
            >
              {{ step.label }}
            </p>
            <p class="text-xs text-gray-500 mt-0.5">{{ step.description }}</p>
          </div>
        </div>
      </button>
    </nav>

    <!-- Progress Info -->
    <div class="pt-6 border-t border-gray-200">
      <div class="space-y-2">
        <div class="flex items-center justify-between">
          <span class="text-xs font-medium text-gray-600">Overall Progress</span>
          <span class="text-xs font-semibold text-gray-900">{{ Math.round((completedSteps.length / steps.length) * 100) }}%</span>
        </div>
        <div class="w-full h-2 bg-gray-100 rounded-full overflow-hidden">
          <div
            :style="{ width: (completedSteps.length / steps.length) * 100 + '%' }"
            class="h-full transition-all duration-500 ease-out rounded-full"
            style="background-color: #B00149;"
          />
        </div>
        <p class="text-xs text-gray-500 mt-2">
          {{ completedSteps.length }} of {{ steps.length }} completed
        </p>
      </div>
    </div>

    <!-- Tips Section -->
    <div class="pt-6 border-t border-gray-200 space-y-3">
      <p class="text-xs font-medium text-gray-600">💡 Quick Tips</p>
      <ul class="space-y-2 text-xs text-gray-600">
        <li class="flex gap-2">
          <span class="flex-shrink-0">•</span>
          <span>Be honest and truthful in all your information</span>
        </li>
        <li class="flex gap-2">
          <span class="flex-shrink-0">•</span>
          <span>Use simple, clear language in descriptions</span>
        </li>
        <li class="flex gap-2">
          <span class="flex-shrink-0">•</span>
          <span>Focus on metrics and quantifiable results</span>
        </li>
      </ul>
    </div>
  </aside>
</template>

<script setup>
defineProps({
  currentStep: {
    type: Number,
    default: 1,
    validator: (val) => val >= 1 && val <= 5
  },
  completedSteps: {
    type: Array,
    default: () => []
  }
})

defineEmits(['navigate'])

const steps = [
  {
    id: 1,
    number: 1,
    label: 'Personal Details',
    description: 'Your name, contact info'
  },
  {
    id: 2,
    number: 2,
    label: 'Professional Summary',
    description: 'Brief overview of you'
  },
  {
    id: 3,
    number: 3,
    label: 'Education + Skills',
    description: 'Degrees and abilities'
  },
  {
    id: 4,
    number: 4,
    label: 'Projects + Experience',
    description: 'Work and portfolio'
  },
  {
    id: 5,
    number: 5,
    label: 'Review',
    description: 'Check and export'
  }
]
</script>

<style scoped>
aside {
  background-color: #FFFFFF;
}
</style>