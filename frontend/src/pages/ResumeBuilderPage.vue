<!-- src/pages/ResumeBuilderPage.vue -->
<template>
  <div class="resume-builder">
    <BuilderHeader @save="handleSavePersonalDetails" :loading="isSubmitting" />
    
    <div class="builder-content">
      <Sidebar />
      
      <div class="builder-main">
        <div class="form-container">
          <h2 class="form-title">Personal Details</h2>
          
          <form @submit.prevent="handleSavePersonalDetails" class="form">
            <!-- Full Name -->
            <div class="form-group">
              <label for="fullName" class="form-label">
                Full Name <span class="required">*</span>
              </label>
              <input
                id="fullName"
                v-model="form.fullName"
                type="text"
                placeholder="John Doe"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('fullName')"
              />
              <span v-if="errors.fullName" class="error-text">{{ errors.fullName }}</span>
            </div>

            <!-- Email -->
            <div class="form-group">
              <label for="email" class="form-label">
                Email <span class="required">*</span>
              </label>
              <input
                id="email"
                v-model="form.email"
                type="email"
                placeholder="john@example.com"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('email')"
              />
              <span v-if="errors.email" class="error-text">{{ errors.email }}</span>
            </div>

            <!-- Phone Number -->
            <div class="form-group">
              <label for="phoneNumber" class="form-label">Phone Number</label>
              <input
                id="phoneNumber"
                v-model="form.phoneNumber"
                type="tel"
                placeholder="+1 (555) 000-0000"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('phoneNumber')"
              />
              <span v-if="errors.phoneNumber" class="error-text">{{ errors.phoneNumber }}</span>
            </div>

            <!-- Location -->
            <div class="form-group">
              <label for="location" class="form-label">Location</label>
              <input
                id="location"
                v-model="form.location"
                type="text"
                placeholder="San Francisco, CA"
                class="form-input"
                :disabled="isSubmitting"
              />
            </div>

            <!-- LinkedIn URL -->
            <div class="form-group">
              <label for="linkedinUrl" class="form-label">LinkedIn URL</label>
              <input
                id="linkedinUrl"
                v-model="form.linkedinUrl"
                type="url"
                placeholder="https://linkedin.com/in/johndoe"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('linkedinUrl')"
              />
              <span v-if="errors.linkedinUrl" class="error-text">{{ errors.linkedinUrl }}</span>
            </div>

            <!-- GitHub URL -->
            <div class="form-group">
              <label for="githubUrl" class="form-label">GitHub URL</label>
              <input
                id="githubUrl"
                v-model="form.githubUrl"
                type="url"
                placeholder="https://github.com/johndoe"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('githubUrl')"
              />
              <span v-if="errors.githubUrl" class="error-text">{{ errors.githubUrl }}</span>
            </div>

            <!-- Portfolio URL -->
            <div class="form-group">
              <label for="portfolioUrl" class="form-label">Portfolio URL</label>
              <input
                id="portfolioUrl"
                v-model="form.portfolioUrl"
                type="url"
                placeholder="https://johndoe.com"
                class="form-input"
                :disabled="isSubmitting"
                @blur="validateField('portfolioUrl')"
              />
              <span v-if="errors.portfolioUrl" class="error-text">{{ errors.portfolioUrl }}</span>
            </div>

            <!-- Form Actions -->
            <div class="form-actions">
              <button
                type="button"
                class="btn btn-secondary"
                :disabled="isSubmitting"
              >
                Previous
              </button>
              <button
                type="submit"
                class="btn btn-primary"
                :disabled="!isFormValid || isSubmitting"
              >
                <span v-if="isSubmitting" class="btn-loader"></span>
                <span>{{ isSubmitting ? 'Saving...' : 'Next' }}</span>
              </button>
            </div>
          </form>
        </div>

        <PreviewPanel />
      </div>
    </div>

    <!-- Toast Notification -->
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
import Sidebar from '../components/Sidebar.vue'
import PreviewPanel from '../components/PreviewPanel.vue'
import Toast from '../components/Toast.vue'
import { resumeApi } from '../services/api'

const isSubmitting = ref(false)

const form = ref({
  fullName: '',
  email: '',
  phoneNumber: '',
  location: '',
  linkedinUrl: '',
  githubUrl: '',
  portfolioUrl: ''
})

const errors = ref({
  fullName: '',
  email: '',
  phoneNumber: '',
  location: '',
  linkedinUrl: '',
  githubUrl: '',
  portfolioUrl: ''
})

const toast = ref({
  show: false,
  type: 'success',
  message: ''
})

const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
const phoneRegex = /^[\d\s\-+()]{10,}$/
const urlRegex = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/

const validateField = (field) => {
  const value = form.value[field]

  if (field === 'fullName') {
    if (!value || value.trim().length === 0) {
      errors.value.fullName = 'Full name is required'
    } else if (value.trim().length < 2) {
      errors.value.fullName = 'Please enter a valid name'
    } else {
      errors.value.fullName = ''
    }
  }

  if (field === 'email') {
    if (!value || value.trim().length === 0) {
      errors.value.email = 'Email is required'
    } else if (!emailRegex.test(value)) {
      errors.value.email = 'Please enter a valid email address'
    } else {
      errors.value.email = ''
    }
  }

  if (field === 'phoneNumber') {
    if (value && !phoneRegex.test(value)) {
      errors.value.phoneNumber = 'Please enter a valid phone number'
    } else {
      errors.value.phoneNumber = ''
    }
  }

  if (field === 'linkedinUrl') {
    if (value && !urlRegex.test(value)) {
      errors.value.linkedinUrl = 'Please enter a valid LinkedIn URL'
    } else {
      errors.value.linkedinUrl = ''
    }
  }

  if (field === 'githubUrl') {
    if (value && !urlRegex.test(value)) {
      errors.value.githubUrl = 'Please enter a valid GitHub URL'
    } else {
      errors.value.githubUrl = ''
    }
  }

  if (field === 'portfolioUrl') {
    if (value && !urlRegex.test(value)) {
      errors.value.portfolioUrl = 'Please enter a valid portfolio URL'
    } else {
      errors.value.portfolioUrl = ''
    }
  }
}

const isFormValid = computed(() => {
  const requiredFieldsValid = 
    form.value.fullName.trim() !== '' &&
    form.value.email.trim() !== '' &&
    emailRegex.test(form.value.email) &&
    !errors.value.fullName &&
    !errors.value.email

  const noErrors = 
    !errors.value.phoneNumber &&
    !errors.value.linkedinUrl &&
    !errors.value.githubUrl &&
    !errors.value.portfolioUrl

  return requiredFieldsValid && noErrors
})

const showToast = (type, message) => {
  toast.value = {
    show: true,
    type,
    message
  }
}

const handleSavePersonalDetails = async () => {
  Object.keys(form.value).forEach(field => {
    validateField(field)
  })

  if (!isFormValid.value) {
    return
  }

  isSubmitting.value = true
  try {
    const payload = {
      fullName: form.value.fullName.trim(),
      email: form.value.email.trim(),
      phoneNumber: form.value.phoneNumber.trim() || null,
      location: form.value.location.trim() || null,
      linkedinUrl: form.value.linkedinUrl.trim() || null,
      githubUrl: form.value.githubUrl.trim() || null,
      portfolioUrl: form.value.portfolioUrl.trim() || null
    }

    await resumeApi.savePersonalDetails(payload)
    showToast('success', 'Personal details saved successfully')
  } catch (error) {
    showToast('error', error.message || 'Failed to save personal details')
  } finally {
    isSubmitting.value = false
  }
}
</script>

<style scoped>
.resume-builder {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background: #f9fafb;
}

.builder-content {
  display: flex;
  flex: 1;
  overflow: hidden;
}

.builder-main {
  flex: 1;
  display: flex;
  gap: 24px;
  padding: 32px;
  overflow-y: auto;
}

.form-container {
  flex: 1;
  background: white;
  border-radius: 12px;
  border: 1px solid #e5e7eb;
  padding: 32px;
  max-width: 600px;
}

.form-title {
  font-size: 24px;
  font-weight: 700;
  color: #111827;
  margin-bottom: 32px;
}

.form {
  display: flex;
  flex-direction: column;
  gap: 24px;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.form-label {
  font-size: 14px;
  font-weight: 500;
  color: #111827;
}

.required {
  color: #ef4444;
}

.form-input {
  padding: 12px 16px;
  border: 1px solid #d1d5db;
  border-radius: 8px;
  font-size: 16px;
  font-family: inherit;
  transition: all 0.2s ease;
}

.form-input:focus {
  outline: none;
  border-color: #3b82f6;
  box-shadow: 0 0 0 3px rgba(59, 130, 246, 0.1);
}

.form-input:disabled {
  background: #f3f4f6;
  color: #9ca3af;
  cursor: not-allowed;
}

.error-text {
  font-size: 13px;
  color: #ef4444;
}

.form-actions {
  display: flex;
  gap: 12px;
  margin-top: 32px;
  padding-top: 24px;
  border-top: 1px solid #e5e7eb;
}

.btn {
  padding: 12px 24px;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
}

.btn:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.btn-primary {
  background: #3b82f6;
  color: white;
}

.btn-primary:hover:not(:disabled) {
  background: #2563eb;
}

.btn-secondary {
  background: #e5e7eb;
  color: #111827;
}

.btn-secondary:hover:not(:disabled) {
  background: #d1d5db;
}

.btn-loader {
  display: inline-block;
  width: 16px;
  height: 16px;
  border: 2px solid rgba(255, 255, 255, 0.3);
  border-top-color: white;
  border-radius: 50%;
  animation: spin 0.8s linear infinite;
}

@keyframes spin {
  to {
    transform: rotate(360deg);
  }
}

@media (max-width: 1024px) {
  .builder-main {
    flex-direction: column;
    gap: 16px;
    padding: 24px;
  }

  .form-container {
    max-width: none;
  }
}

@media (max-width: 640px) {
  .builder-main {
    padding: 16px;
    gap: 12px;
  }

  .form-container {
    padding: 20px;
  }

  .form-title {
    font-size: 20px;
    margin-bottom: 24px;
  }

  .form {
    gap: 16px;
  }
}
</style>
