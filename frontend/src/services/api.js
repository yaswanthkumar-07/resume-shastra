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

  saveEducation: (resumeId, data) => 
    apiClient.post(`/resumes/${resumeId}/education`, data).then(res => res.data),

  getEducation: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/education`).then(res => res.data),

  deleteEducation: (resumeId, id) => 
    apiClient.delete(`/resumes/${resumeId}/education/${id}`).then(res => res.data),

  saveSkills: (resumeId, data) => 
    apiClient.post(`/resumes/${resumeId}/skills`, data).then(res => res.data),

  getSkills: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/skills`).then(res => res.data),

  saveProject: (resumeId, data) => 
    apiClient.post(`/resumes/${resumeId}/projects`, data).then(res => res.data),

  getProjects: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/projects`).then(res => res.data),

  deleteProject: (resumeId, id) => 
    apiClient.delete(`/resumes/${resumeId}/projects/${id}`).then(res => res.data),

  saveExperience: (resumeId, data) => 
    apiClient.post(`/resumes/${resumeId}/experience`, data).then(res => res.data),

  getExperience: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/experience`).then(res => res.data),

  deleteExperience: (resumeId, id) => 
    apiClient.delete(`/resumes/${resumeId}/experience/${id}`).then(res => res.data),

  saveCertifications: (resumeId, data) => 
    apiClient.post(`/resumes/${resumeId}/certifications`, data).then(res => res.data),

  getCertifications: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/certifications`).then(res => res.data),

  deleteCertification: (resumeId, id) => 
    apiClient.delete(`/resumes/${resumeId}/certifications/${id}`).then(res => res.data),

  analyzeResume: (resumeId) => 
    apiClient.get(`/resumes/${resumeId}/ats-analysis`).then(res => res.data),

  exportResume: (resumeId, format) => 
    apiClient.get(`/resumes/${resumeId}/export?format=${format}`, { responseType: 'blob' })
}

export default apiClient
