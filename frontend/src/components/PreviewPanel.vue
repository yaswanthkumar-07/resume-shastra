<!-- src/components/PreviewPanel.vue -->
<template>
  <div class="preview-panel">
    <!-- Desktop/Tablet View -->
    <div class="hidden md:flex flex-col bg-white rounded-xl shadow-sm border border-gray-200 h-full overflow-hidden">
      <div class="flex-1 overflow-y-auto">
        <!-- Resume Container -->
        <div class="w-full max-w-2xl mx-auto px-6 py-8">
          <!-- Header Section -->
          <div class="mb-6 pb-6 border-b border-gray-200">
            <h1 v-if="resumeData.fullName" class="text-2xl font-bold text-gray-900 mb-1" style="font-family: 'IBM Plex Sans', sans-serif;">
              {{ resumeData.fullName }}
            </h1>
            <p v-else class="text-2xl font-bold text-gray-300 mb-1" style="font-family: 'IBM Plex Sans', sans-serif;">
              Your Name
            </p>

            <div v-if="hasContactInfo" class="flex flex-wrap gap-4 text-sm text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">
              <span v-if="resumeData.email">{{ resumeData.email }}</span>
              <span v-if="resumeData.phoneNumber">{{ resumeData.phoneNumber }}</span>
              <span v-if="resumeData.location">{{ resumeData.location }}</span>
              <a v-if="resumeData.linkedinUrl" :href="resumeData.linkedinUrl" target="_blank" class="text-blue-600 hover:underline">
                LinkedIn
              </a>
              <a v-if="resumeData.githubUrl" :href="resumeData.githubUrl" target="_blank" class="text-blue-600 hover:underline">
                GitHub
              </a>
              <a v-if="resumeData.portfolioUrl" :href="resumeData.portfolioUrl" target="_blank" class="text-blue-600 hover:underline">
                Portfolio
              </a>
            </div>

            <div v-else class="space-y-2">
              <div class="h-4 bg-gray-100 rounded w-3/4"></div>
              <div class="h-3 bg-gray-100 rounded w-full"></div>
              <div class="h-3 bg-gray-100 rounded w-2/3"></div>
            </div>
          </div>

          <!-- Professional Summary Section -->
          <div v-if="resumeData.summary" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-2" style="font-family: 'IBM Plex Sans', sans-serif;">Professional Summary</h2>
            <p class="text-sm text-gray-700 leading-relaxed" style="font-family: 'IBM Plex Sans', sans-serif;">
              {{ resumeData.summary }}
            </p>
          </div>

          <!-- Experience Section -->
          <div v-if="resumeData.experience && resumeData.experience.length > 0" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-3" style="font-family: 'IBM Plex Sans', sans-serif;">Experience</h2>
            <div class="space-y-4">
              <div v-for="job in resumeData.experience" :key="job.id" class="text-sm">
                <div class="flex justify-between items-start mb-1">
                  <h3 class="font-semibold text-gray-900" style="font-family: 'IBM Plex Sans', sans-serif;">{{ job.title }}</h3>
                  <span v-if="job.duration" class="text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">{{ job.duration }}</span>
                </div>
                <p class="text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">{{ job.company }}</p>
                <p v-if="job.description" class="text-gray-700 mt-1" style="font-family: 'IBM Plex Sans', sans-serif;">
                  {{ job.description }}
                </p>
              </div>
            </div>
          </div>

          <!-- Education Section -->
          <div v-if="resumeData.education && resumeData.education.length > 0" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-3" style="font-family: 'IBM Plex Sans', sans-serif;">Education</h2>
            <div class="space-y-3">
              <div v-for="edu in resumeData.education" :key="edu.id" class="text-sm">
                <div class="flex justify-between items-start mb-1">
                  <h3 class="font-semibold text-gray-900" style="font-family: 'IBM Plex Sans', sans-serif;">{{ edu.degree }}</h3>
                  <span v-if="edu.year" class="text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">{{ edu.year }}</span>
                </div>
                <p class="text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">{{ edu.institution }}</p>
              </div>
            </div>
          </div>

          <!-- Skills Section -->
          <div v-if="resumeData.skills && resumeData.skills.length > 0" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-3" style="font-family: 'IBM Plex Sans', sans-serif;">Skills</h2>
            <div class="flex flex-wrap gap-2">
              <span
                v-for="(skill, idx) in resumeData.skills"
                :key="idx"
                class="inline-block px-3 py-1 bg-gray-100 text-gray-700 rounded text-sm"
                style="font-family: 'IBM Plex Sans', sans-serif;"
              >
                {{ skill }}
              </span>
            </div>
          </div>

          <!-- Projects Section -->
          <div v-if="resumeData.projects && resumeData.projects.length > 0" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-3" style="font-family: 'IBM Plex Sans', sans-serif;">Projects</h2>
            <div class="space-y-4">
              <div v-for="project in resumeData.projects" :key="project.id" class="text-sm">
                <h3 class="font-semibold text-gray-900" style="font-family: 'IBM Plex Sans', sans-serif;">{{ project.name }}</h3>
                <p v-if="project.description" class="text-gray-700 mt-1" style="font-family: 'IBM Plex Sans', sans-serif;">
                  {{ project.description }}
                </p>
              </div>
            </div>
          </div>

          <!-- Certifications Section -->
          <div v-if="resumeData.certifications && resumeData.certifications.length > 0" class="mb-6">
            <h2 class="text-lg font-semibold text-gray-900 mb-3" style="font-family: 'IBM Plex Sans', sans-serif;">Certifications</h2>
            <div class="space-y-2">
              <div v-for="cert in resumeData.certifications" :key="cert.id" class="text-sm">
                <p class="font-semibold text-gray-900" style="font-family: 'IBM Plex Sans', sans-serif;">{{ cert.name }}</p>
                <p v-if="cert.issuer" class="text-gray-600" style="font-family: 'IBM Plex Sans', sans-serif;">{{ cert.issuer }}</p>
              </div>
            </div>
          </div>

          <!-- Empty State -->
          <div v-if="isEmpty" class="text-center py-12">
            <svg class="w-12 h-12 text-gray-300 mx-auto mb-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z" />
            </svg>
            <p class="text-gray-500 text-sm">Your resume preview will appear here</p>
            <p class="text-gray-400 text-xs mt-1">Start filling in your details to see it grow</p>
          </div>
        </div>
      </div>

      <!-- Print Background -->
      <style scoped>
        @media print {
          .preview-panel {
            background: white;
          }
        }
      </style>
    </div>

    <!-- Mobile View - Button -->
    <div class="md:hidden">
      <button
        @click="isPreviewOpen = true"
        class="w-full px-4 py-3 text-white rounded-lg font-medium transition-colors flex items-center justify-center gap-2"
        style="background-color: #B00149;"
      >
        <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
        </svg>
        Preview
      </button>

      <!-- Mobile Preview Modal -->
      <Transition name="modal">
        <div v-if="isPreviewOpen" class="fixed inset-0 bg-black bg-opacity-50 z-50 flex items-end">
          <div class="bg-white w-full rounded-t-2xl shadow-xl max-h-[90vh] overflow-y-auto">
            <div class="sticky top-0 bg-white border-b border-gray-200 px-4 py-3 flex items-center justify-between">
              <h2 class="font-semibold text-gray-900">Resume Preview</h2>
              <button
                @click="isPreviewOpen = false"
                class="p-2 hover:bg-gray-100 rounded-lg transition"
              >
                <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                </svg>
              </button>
            </div>

            <div class="px-4 py-6">
              <!-- Same content as desktop preview -->
              <h1 v-if="resumeData.fullName" class="text-xl font-bold text-gray-900 mb-2" style="font-family: 'IBM Plex Sans', sans-serif;">
                {{ resumeData.fullName }}
              </h1>
              <p v-else class="text-xl font-bold text-gray-300 mb-2" style="font-family: 'IBM Plex Sans', sans-serif;">
                Your Name
              </p>

              <div v-if="hasContactInfo" class="space-y-1 text-sm text-gray-600 mb-6 pb-6 border-b border-gray-200">
                <p v-if="resumeData.email">{{ resumeData.email }}</p>
                <p v-if="resumeData.phoneNumber">{{ resumeData.phoneNumber }}</p>
                <p v-if="resumeData.location">{{ resumeData.location }}</p>
              </div>

              <p v-if="isEmpty" class="text-gray-500 text-center py-8">Your resume preview will appear here</p>
            </div>
          </div>
        </div>
      </Transition>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'

const props = defineProps({
  resumeData: {
    type: Object,
    default: () => ({
      fullName: '',
      email: '',
      phoneNumber: '',
      location: '',
      linkedinUrl: '',
      githubUrl: '',
      portfolioUrl: '',
      summary: '',
      experience: [],
      education: [],
      skills: [],
      projects: [],
      certifications: []
    })
  }
})

const isPreviewOpen = ref(false)

const hasContactInfo = computed(() => {
  return props.resumeData.email || props.resumeData.phoneNumber || props.resumeData.location ||
    props.resumeData.linkedinUrl || props.resumeData.githubUrl || props.resumeData.portfolioUrl
})

const isEmpty = computed(() => {
  return !props.resumeData.fullName &&
    !hasContactInfo.value &&
    !props.resumeData.summary &&
    (!props.resumeData.experience || props.resumeData.experience.length === 0) &&
    (!props.resumeData.education || props.resumeData.education.length === 0) &&
    (!props.resumeData.skills || props.resumeData.skills.length === 0)
})
</script>

<style scoped>
.preview-panel {
  height: 100%;
  overflow: hidden;
}

.modal-enter-active,
.modal-leave-active {
  transition: all 0.3s ease;
}

.modal-enter-from {
  opacity: 0;
}

.modal-enter-to {
  opacity: 1;
}

.modal-leave-from {
  opacity: 1;
}

.modal-leave-to {
  opacity: 0;
}
</style>