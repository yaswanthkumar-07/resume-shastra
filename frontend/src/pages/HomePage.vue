<!-- src/pages/HomePage.vue -->
<template>
  <div class="space-y-0">
    <!-- Hero Section -->
    <section class="relative overflow-hidden bg-white">
      <div class="max-w-7xl mx-auto px-6 py-20 md:py-28">
        <div class="text-center max-w-3xl mx-auto">
          <h1 class="text-4xl md:text-6xl font-bold text-gray-900 mb-6 leading-tight" style="font-family: Manrope, sans-serif;">
            Build Your Professional Resume in Minutes
          </h1>
          <p class="text-lg md:text-xl text-gray-600 mb-8" style="font-family: Inter, sans-serif;">
            Create honest, ATS-friendly, industry-standard resumes without learning design software. Focus on content. We handle presentation.
          </p>
          <div class="flex flex-col sm:flex-row gap-4 justify-center">
            <RouterLink
              to="/resume-builder"
              class="px-8 py-3 rounded-lg font-medium text-white transition-all hover:shadow-lg text-center"
              style="background-color: #B00149; font-family: Inter, sans-serif;"
            >
              Start Building Free
            </RouterLink>
            <a
              href="#features"
              class="px-8 py-3 rounded-lg font-medium text-gray-700 bg-gray-100 hover:bg-gray-200 transition text-center"
              style="font-family: Inter, sans-serif;"
            >
              See How It Works
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="bg-gray-50 py-20">
      <div class="max-w-7xl mx-auto px-6">
        <div class="text-center mb-16">
          <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4" style="font-family: Manrope, sans-serif;">
            Why ResumeShastra?
          </h2>
          <p class="text-lg text-gray-600" style="font-family: Inter, sans-serif;">
            Everything you need to create a standout resume
          </p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          <!-- Feature 1 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">ATS-Friendly Format</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              Your resume will pass through Applicant Tracking Systems without losing formatting or information.
            </p>
          </div>

          <!-- Feature 2 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">No Design Skills Needed</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              We handle the design. You focus on writing content about your experience and achievements.
            </p>
          </div>

          <!-- Feature 3 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Smart Templates</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              Professional templates designed by recruiters and hiring managers.
            </p>
          </div>

          <!-- Feature 4 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 14l-7 7m0 0l-7-7m7 7V3" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Instant Export</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              Download your resume as a PDF instantly. No watermarks, no hidden costs.
            </p>
          </div>

          <!-- Feature 5 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Real-time Preview</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              See your resume update in real-time as you fill in your information.
            </p>
          </div>

          <!-- Feature 6 -->
          <div class="bg-white rounded-xl border border-gray-200 p-6">
            <div class="w-12 h-12 bg-red-100 rounded-lg flex items-center justify-center mb-4">
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" style="color: #B00149;">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12l2 2 4-4m7 0a9 9 0 11-18 0 9 9 0 0118 0z" />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Optimized for Success</h3>
            <p class="text-gray-600" style="font-family: Inter, sans-serif;">
              Built with best practices recommended by recruiters and hiring managers worldwide.
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- How It Works Section -->
    <section id="how-it-works" class="bg-white py-20">
      <div class="max-w-7xl mx-auto px-6">
        <div class="text-center mb-16">
          <h2 class="text-3xl md:text-4xl font-bold text-gray-900 mb-4" style="font-family: Manrope, sans-serif;">
            How It Works
          </h2>
          <p class="text-lg text-gray-600" style="font-family: Inter, sans-serif;">
            Get your resume ready in just 5 simple steps
          </p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-5 gap-4 md:gap-2">
          <!-- Step 1 -->
          <div class="text-center">
            <div class="w-12 h-12 rounded-full text-white flex items-center justify-center font-bold text-lg mx-auto mb-4" style="background-color: #B00149; font-family: Manrope, sans-serif;">
              1
            </div>
            <h3 class="font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Personal Details</h3>
            <p class="text-sm text-gray-600" style="font-family: Inter, sans-serif;">
              Enter your name, contact info, and links
            </p>
          </div>

          <!-- Arrow -->
          <div class="hidden md:flex items-center justify-center">
            <svg class="w-4 h-4 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
          </div>

          <!-- Step 2 -->
          <div class="text-center">
            <div class="w-12 h-12 rounded-full text-white flex items-center justify-center font-bold text-lg mx-auto mb-4" style="background-color: #B00149; font-family: Manrope, sans-serif;">
              2
            </div>
            <h3 class="font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Professional Summary</h3>
            <p class="text-sm text-gray-600" style="font-family: Inter, sans-serif;">
              Tell us about your background
            </p>
          </div>

          <!-- Arrow -->
          <div class="hidden md:flex items-center justify-center">
            <svg class="w-4 h-4 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
          </div>

          <!-- Step 3 -->
          <div class="text-center">
            <div class="w-12 h-12 rounded-full text-white flex items-center justify-center font-bold text-lg mx-auto mb-4" style="background-color: #B00149; font-family: Manrope, sans-serif;">
              3
            </div>
            <h3 class="font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Education + Skills</h3>
            <p class="text-sm text-gray-600" style="font-family: Inter, sans-serif;">
              Add your degrees and abilities
            </p>
          </div>

          <!-- Arrow -->
          <div class="hidden md:flex items-center justify-center">
            <svg class="w-4 h-4 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
          </div>

          <!-- Step 4 -->
          <div class="text-center">
            <div class="w-12 h-12 rounded-full text-white flex items-center justify-center font-bold text-lg mx-auto mb-4" style="background-color: #B00149; font-family: Manrope, sans-serif;">
              4
            </div>
            <h3 class="font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Experience + Projects</h3>
            <p class="text-sm text-gray-600" style="font-family: Inter, sans-serif;">
              List your work and portfolio
            </p>
          </div>

          <!-- Arrow -->
          <div class="hidden md:flex items-center justify-center">
            <svg class="w-4 h-4 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
          </div>

          <!-- Step 5 -->
          <div class="text-center">
            <div class="w-12 h-12 rounded-full text-white flex items-center justify-center font-bold text-lg mx-auto mb-4" style="background-color: #B00149; font-family: Manrope, sans-serif;">
              5
            </div>
            <h3 class="font-semibold text-gray-900 mb-2" style="font-family: Manrope, sans-serif;">Review & Export</h3>
            <p class="text-sm text-gray-600" style="font-family: Inter, sans-serif;">
              Download your PDF and apply
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="py-20" style="background-color: #B00149;">
      <div class="max-w-3xl mx-auto px-6 text-center">
        <h2 class="text-3xl md:text-4xl font-bold text-white mb-6" style="font-family: Manrope, sans-serif;">
          Ready to Build Your Resume?
        </h2>
        <p class="text-lg text-red-100 mb-8" style="font-family: Inter, sans-serif;">
          Join thousands of professionals who have created their perfect resume with ResumeShastra.
        </p>
        <RouterLink
          to="/resume-builder"
          class="inline-block px-8 py-3 rounded-lg font-medium text-red-600 bg-white hover:bg-gray-100 transition"
          style="font-family: Inter, sans-serif;"
        >
          Get Started Free
        </RouterLink>
      </div>
    </section>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router'
</script>

<style scoped>
</style>