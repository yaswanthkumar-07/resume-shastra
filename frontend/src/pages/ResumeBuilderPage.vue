<template>
  <div class="flex flex-col h-screen bg-gray-50">
    <BuilderHeader
      :current-step="currentStep"
      :current-step-label="currentStepLabel"
      :loading="isSubmitting"
      @save="handleSaveDraft"
      @export="handleExport"
    />

    <div class="flex flex-1 overflow-hidden">
      <Sidebar
        :current-step="currentStep"
        :completed-steps="completedSteps"
        @navigate="navigateToStep"
      />

      <div class="flex-1 flex flex-col lg:flex-row gap-6 p-6 overflow-hidden">
        <div class="flex-1 lg:w-3/5 overflow-y-auto">
          <div class="max-w-2xl">
            <form
              v-if="currentStep === 1"
              @submit.prevent="handleNext"
              class="space-y-6"
            >
              <div class="mb-8">
                <h2 class="text-2xl font-bold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">
                  Personal Details
                </h2>
                <p class="text-gray-600" style="font-family: Inter, sans-serif;">
                  Help employers get to know you. All information is required unless marked optional.
                </p>
              </div>

              <div class="bg-white rounded-xl border border-gray-200 p-6 space-y-5">
                <h3 class="text-sm font-semibold text-gray-900 uppercase tracking-wide" style="font-family: Inter, sans-serif;">
                  Required Information
                </h3>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Full Name <span class="text-red-500">*</span>
                  </label>
                  <input
                    v-model="form.fullName"
                    type="text"
                    placeholder="Yaswanth Kumar Kolla"
                    @blur="validateField('fullName')"
                    :disabled="isSubmitting"
                    :class="[
                      'w-full px-4 py-2 border rounded-lg transition-colors',
                      errors.fullName ? 'border-red-500 bg-red-50' : 'border-gray-300 bg-white'
                    ]"
                    style="font-family: Inter, sans-serif;"
                  />
                  <p v-if="errors.fullName" class="text-sm text-red-600">{{ errors.fullName }}</p>
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Email <span class="text-red-500">*</span>
                  </label>
                  <input
                    v-model="form.email"
                    type="email"
                    placeholder="you@example.com"
                    @blur="validateField('email')"
                    :disabled="isSubmitting"
                    :class="[
                      'w-full px-4 py-2 border rounded-lg transition-colors',
                      errors.email ? 'border-red-500 bg-red-50' : 'border-gray-300 bg-white'
                    ]"
                    style="font-family: Inter, sans-serif;"
                  />
                  <p v-if="errors.email" class="text-sm text-red-600">{{ errors.email }}</p>
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Phone Number <span class="text-red-500">*</span>
                  </label>
                  <input
                    v-model="form.phone"
                    type="tel"
                    placeholder="+1 (555) 000-0000"
                    @blur="validateField('phone')"
                    :disabled="isSubmitting"
                    :class="[
                      'w-full px-4 py-2 border rounded-lg transition-colors',
                      errors.phone ? 'border-red-500 bg-red-50' : 'border-gray-300 bg-white'
                    ]"
                    style="font-family: Inter, sans-serif;"
                  />
                  <p v-if="errors.phone" class="text-sm text-red-600">{{ errors.phone }}</p>
                </div>
              </div>

              <div class="bg-white rounded-xl border border-gray-200 p-6 space-y-5">
                <div>
                  <h3 class="text-sm font-semibold text-gray-900 uppercase tracking-wide mb-1" style="font-family: Inter, sans-serif;">
                    Optional Information
                  </h3>
                  <p class="text-sm text-gray-500" style="font-family: Inter, sans-serif;">
                    Adding professional profiles helps recruiters know more about you, but you can always add them later.
                  </p>
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Professional Title
                  </label>
                  <input
                    v-model="form.title"
                    type="text"
                    placeholder="Backend Developer"
                    :disabled="isSubmitting"
                    class="w-full px-4 py-2 border border-gray-300 bg-white rounded-lg transition-colors"
                    style="font-family: Inter, sans-serif;"
                  />
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Location
                  </label>
                  <input
                    v-model="form.location"
                    type="text"
                    placeholder="San Francisco, CA"
                    :disabled="isSubmitting"
                    class="w-full px-4 py-2 border border-gray-300 bg-white rounded-lg transition-colors"
                    style="font-family: Inter, sans-serif;"
                  />
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    LinkedIn URL
                  </label>
                  <input
                    v-model="form.linkedin"
                    type="url"
                    placeholder="linkedin.com/in/yaswanthkumar-07"
                    @blur="validateField('linkedin')"
                    :disabled="isSubmitting"
                    class="w-full px-4 py-2 border border-gray-300 bg-white rounded-lg transition-colors"
                    style="font-family: Inter, sans-serif;"
                  />
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    GitHub URL
                  </label>
                  <input
                    v-model="form.github"
                    type="url"
                    placeholder="github.com/yaswanthkumar-07"
                    @blur="validateField('github')"
                    :disabled="isSubmitting"
                    class="w-full px-4 py-2 border border-gray-300 bg-white rounded-lg transition-colors"
                    style="font-family: Inter, sans-serif;"
                  />
                </div>

                <div class="space-y-2">
                  <label class="block text-sm font-medium text-gray-900" style="font-family: Inter, sans-serif;">
                    Portfolio URL
                  </label>
                  <input
                    v-model="form.portfolio"
                    type="url"
                    placeholder="yourportfolio.com"
                    @blur="validateField('portfolio')"
                    :disabled="isSubmitting"
                    class="w-full px-4 py-2 border border-gray-300 bg-white rounded-lg transition-colors"
                    style="font-family: Inter, sans-serif;"
                  />
                </div>
              </div>

              <div class="flex gap-3 pt-6">
                <button
                  type="button"
                  @click="handlePrevious"
                  :disabled="isSubmitting"
                  class="px-6 py-3 rounded-lg font-medium text-gray-700 bg-gray-100 hover:bg-gray-200 transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
                  style="font-family: Inter, sans-serif;"
                >
                  Previous
                </button>
                <button
                  type="button"
                  @click="handleSaveDraft"
                  :disabled="isSubmitting"
                  class="px-6 py-3 rounded-lg font-medium text-gray-700 bg-gray-100 hover:bg-gray-200 transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
                  style="font-family: Inter, sans-serif;"
                >
                  Save Draft
                </button>
                <button
                  type="submit"
                  :disabled="!isFormValid || isSubmitting"
                  class="flex-1 px-6 py-3 rounded-lg font-medium text-white transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
                  style="background-color: #B00149;"
                >
                  {{ isSubmitting ? 'Saving...' : 'Continue' }}
                </button>
              </div>
            </form>

            <div v-else class="bg-white rounded-xl border border-gray-200 p-8 text-center">
              <h2 class="text-2xl font-bold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">
                {{ currentStepLabel }}
              </h2>
              <p class="text-gray-600 mb-6">Coming soon</p>
              <div class="flex gap-3 justify-center">
                <button
                  @click="navigateToStep(currentStep - 1)"
                  class="px-6 py-3 rounded-lg font-medium text-gray-700 bg-gray-100 hover:bg-gray-200 transition-colors"
                  style="font-family: Inter, sans-serif;"
                >
                  Previous
                </button>
                <button
                  @click="navigateToStep(currentStep + 1)"
                  v-if="currentStep < 5"
                  class="px-6 py-3 rounded-lg font-medium text-white transition-colors"
                  style="background-color: #B00149;"
                >
                  Next
                </button>
              </div>
            </div>
          </div>
        </div>

        <div class="hidden lg:flex lg:w-2/5 flex-col">
          <PreviewPanel :resume-data="resumeData" />
        </div>
      </div>
    </div>

    <Toast
      v-if="toast.show"
      :type="toast.type"
      :message="toast.message"
      @close="toast.show = false"
    />
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import BuilderHeader from '../components/BuilderHeader.vue'
import PreviewPanel from '../components/PreviewPanel.vue'
import Sidebar from '../components/Sidebar.vue'
import Toast from '../components/Toast.vue'
import { resumeApi } from '../services/api'

const currentStep = ref(1)
const isSubmitting = ref(false)
const completedSteps = ref([])

const form = ref({
  fullName: '',
  email: '',
  phone: '',
  title: '',
  location: '',
  linkedin: '',
  github: '',
  portfolio: ''
})

const errors = ref({
  fullName: '',
  email: '',
  phone: '',
  linkedin: '',
  github: '',
  portfolio: ''
})

const toast = ref({
  show: false,
  type: 'success',
  message: ''
})

const resumeData = computed(() => ({
  fullName: form.value.fullName,
  email: form.value.email,
  phoneNumber: form.value.phone,
  location: form.value.location,
  linkedinUrl: form.value.linkedin,
  githubUrl: form.value.github,
  portfolioUrl: form.value.portfolio
}))

const currentStepLabel = computed(() => {
  const labels = ['Personal Details', 'Professional Summary', 'Education + Skills', 'Projects + Experience', 'Review']
  return labels[currentStep.value - 1]
})

const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
const phoneRegex = /^[\d\s\-+()]{10,}$/
const urlRegex = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/

const validateField = (field) => {
  const value = form.value[field]

  if (field === 'fullName') {
    errors.value.fullName = !value || value.trim().length < 2 ? 'Please enter a valid name' : ''
  }

  if (field === 'email') {
    errors.value.email = !value || !emailRegex.test(value) ? 'Please enter a valid email' : ''
  }

  if (field === 'phone') {
    errors.value.phone = value && !phoneRegex.test(value) ? 'Please enter a valid phone number' : ''
  }

  if (field === 'linkedin') {
    errors.value.linkedin = value && !urlRegex.test(value) ? 'Please enter a valid URL' : ''
  }

  if (field === 'github') {
    errors.value.github = value && !urlRegex.test(value) ? 'Please enter a valid URL' : ''
  }

  if (field === 'portfolio') {
    errors.value.portfolio = value && !urlRegex.test(value) ? 'Please enter a valid URL' : ''
  }
}

const isFormValid = computed(() => {
  return form.value.fullName.trim() !== '' &&
    form.value.email.trim() !== '' &&
    emailRegex.test(form.value.email) &&
    form.value.phone.trim() !== '' &&
    phoneRegex.test(form.value.phone) &&
    !errors.value.fullName &&
    !errors.value.email &&
    !errors.value.phone &&
    !errors.value.linkedin &&
    !errors.value.github &&
    !errors.value.portfolio
})

const showToast = (type, message) => {
  toast.value = { show: true, type, message }
}

const handleSaveDraft = async () => {
  Object.keys(form.value).forEach(field => {
    if (['fullName', 'email', 'phone', 'linkedin', 'github', 'portfolio'].includes(field)) {
      validateField(field)
    }
  })

  if (!isFormValid.value) {
    showToast('error', 'Please fix the errors above')
    return
  }

  isSubmitting.value = true
  try {
    const response = await resumeApi.savePersonalDetails({
      fullName: form.value.fullName.trim(),
      professionalTitle: form.value.title.trim() || null,
      email: form.value.email.trim(),
      phoneNumber: form.value.phone.trim(),
      location: form.value.location.trim() || null,
      linkedinUrl: form.value.linkedin.trim() || null,
      githubUrl: form.value.github.trim() || null,
      portfolioUrl: form.value.portfolio.trim() || null
    })
    
    localStorage.setItem("resumeId", response.data.resumeId)
   
    
    showToast('success', 'Draft saved successfully')
  } catch (error) {

  if (error.data?.errors?.length) {
    showToast(
      'error',
      error.data.errors.join('\n')
    )
  } else {
    showToast(
      'error',
      error.message || 'Failed to save draft'
    )
  }

} finally {
    isSubmitting.value = false
  }
}

const handleNext = async () => {
  Object.keys(form.value).forEach(field => {
    if (['fullName', 'email', 'phone', 'linkedin', 'github', 'portfolio'].includes(field)) {
      validateField(field)
    }
  })

  if (!isFormValid.value) {
    showToast('error', 'Please fill in all required fields correctly')
    return
  }

  isSubmitting.value = true
  try {
    const response = await resumeApi.savePersonalDetails({
      fullName: form.value.fullName.trim(),
      professionalTitle: form.value.title.trim() || null,
      email: form.value.email.trim(),
      phoneNumber: form.value.phone.trim(),
      location: form.value.location.trim() || null,
      linkedinUrl: form.value.linkedin.trim() || null,
      githubUrl: form.value.github.trim() || null,
      portfolioUrl: form.value.portfolio.trim() || null
    })

    localStorage.setItem("resumeId", response.data.resumeId)
    

    if (!completedSteps.value.includes(1)) {
      completedSteps.value.push(1)
    }

    currentStep.value += 1
    showToast('success', 'Personal details saved')
  } catch (error) {

  if (error.data?.errors?.length) {
    showToast(
      'error',
      error.data.errors.join('\n')
    )
  } else {
    showToast(
      'error',
      error.message || 'Failed to save'
    )
  }

} finally {
    isSubmitting.value = false
  }
}

const handlePrevious = () => {
  if (currentStep.value > 1) {
    currentStep.value -= 1
  }
}

const handleExport = () => {
  showToast('info', 'Export feature coming soon')
}

const navigateToStep = (step) => {
  if (step >= 1 && step <= 5) {
    currentStep.value = step
  }
}
</script>

<style scoped>
::-webkit-scrollbar {
  width: 8px;
}

::-webkit-scrollbar-track {
  background: transparent;
}

::-webkit-scrollbar-thumb {
  background: #D1D5DB;
  border-radius: 4px;
}

::-webkit-scrollbar-thumb:hover {
  background: #9CA3AF;
}
</style>