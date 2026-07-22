// src/services/api.js
import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api'

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
})

apiClient.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('authToken')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  (error) => Promise.reject(error)
)

apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    let message = 'An error occurred'

    if (error.response) {
      message = error.response.data?.message || error.response.statusText || message
    } else if (error.request) {
      message = 'No response from server. Please check your connection.'
    } else {
      message = error.message
    }

    const customError = new Error(message)
    customError.status = error.response?.status
    customError.data = error.response?.data

    return Promise.reject(customError)
  }
)

export const resumeApi = {

  // =============================
  // Resume
  // =============================

  savePersonalDetails: (data) =>
    apiClient.post('/resumes/personal', data).then(res => res.data),

  getResume: (id) =>
    apiClient.get(`/resumes/${id}`).then(res => res.data),

  updateResume: (id, data) =>
    apiClient.put(`/resumes/${id}`, data).then(res => res.data),

  deleteResume: (id) =>
    apiClient.delete(`/resumes/${id}`).then(res => res.data),

  listResumes: () =>
    apiClient.get('/resumes').then(res => res.data),

  getPersonalDetails: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/personal-details`).then(res => res.data),

  // =============================
  // Professional Summary
  // =============================

  saveProfessionalSummary: (resumeId, data) =>
    apiClient.post(`/resumes/${resumeId}/summary`, data).then(res => res.data),

  getProfessionalSummary: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/summary`).then(res => res.data),

  updateProfessionalSummary: (resumeId, data) =>
    apiClient.put(`/resumes/${resumeId}/summary`, data).then(res => res.data),

  deleteProfessionalSummary: (resumeId) =>
    apiClient.delete(`/resumes/${resumeId}/summary`).then(res => res.data),

  // =============================
  // Summary Templates
  // =============================

  getSummaryTemplatesByCategory: (category) =>
    apiClient.get('/summary-templates', {
      params: { category }
    }).then(res => res.data),

  getSummaryTemplate: (id) =>
    apiClient.get(`/summary-templates/${id}`).then(res => res.data),

// =============================
// Education
// =============================

saveEducation: (resumeId, data) =>
  apiClient.post(`/resumes/${resumeId}/education`, data).then(res => res.data),

getEducation: (resumeId) =>
  apiClient.get(`/resumes/${resumeId}/education`).then(res => res.data),

getEducationById: (resumeId, id) =>
  apiClient.get(`/resumes/${resumeId}/education/${id}`).then(res => res.data),

updateEducation: (resumeId, id, data) =>
  apiClient.put(`/resumes/${resumeId}/education/${id}`, data).then(res => res.data),

updateEducationDisplayOrder: (resumeId, id, displayOrder) =>
  apiClient.patch(
    `/resumes/${resumeId}/education/${id}/display-order`,
    null,
    {
      params: {
        displayOrder
      }
    }
  ).then(res => res.data),

deleteEducation: (resumeId, id) =>
  apiClient.delete(`/resumes/${resumeId}/education/${id}`).then(res => res.data),

// =============================
  // Skills
  // =============================

  saveSkill: (resumeId, data) =>
    apiClient.post(`/skills/${resumeId}`, data).then(res => res.data),

  getSkills: (resumeId) =>
    apiClient.get(`/skills/${resumeId}`).then(res => res.data),

  // =============================
  // Projects
  // =============================

  saveProject: (resumeId, data) =>
    apiClient.post(`/resumes/${resumeId}/projects`, data).then(res => res.data),

  getProjects: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/projects`).then(res => res.data),

  deleteProject: (resumeId, id) =>
    apiClient.delete(`/resumes/${resumeId}/projects/${id}`).then(res => res.data),

  // =============================
  // Experience
  // =============================

  saveExperience: (resumeId, data) =>
    apiClient.post(`/resumes/${resumeId}/experience`, data).then(res => res.data),

  getExperience: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/experience`).then(res => res.data),

  deleteExperience: (resumeId, id) =>
    apiClient.delete(`/resumes/${resumeId}/experience/${id}`).then(res => res.data),

  // =============================
  // Certifications
  // =============================

  saveCertifications: (resumeId, data) =>
    apiClient.post(`/resumes/${resumeId}/certifications`, data).then(res => res.data),

  getCertifications: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/certifications`).then(res => res.data),

  deleteCertification: (resumeId, id) =>
    apiClient.delete(`/resumes/${resumeId}/certifications/${id}`).then(res => res.data),

  // =============================
  // ATS Analysis
  // =============================

  analyzeResume: (resumeId) =>
    apiClient.get(`/resumes/${resumeId}/ats-analysis`).then(res => res.data),

  // =============================
  // Export
  // =============================

  exportResume: (resumeId, format) =>
    apiClient.get(`/resumes/${resumeId}/export?format=${format}`, {
      responseType: 'blob'
    })
}

export default apiClient