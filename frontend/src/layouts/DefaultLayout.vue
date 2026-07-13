<!-- src/layouts/DefaultLayout.vue -->
<template>
  <div class="flex flex-col min-h-screen bg-white">
    <!-- Header -->
    <header class="sticky top-0 z-40 bg-white border-b border-gray-200">
      <div class="max-w-7xl mx-auto px-6 py-4">
        <div class="flex items-center justify-between">
          <!-- Logo -->
          <RouterLink to="/" class="flex items-center gap-2">
            <div class="w-8 h-8 bg-gradient-to-br from-red-600 to-red-700 rounded-lg flex items-center justify-center">
              <span class="text-white font-bold text-sm">R</span>
            </div>
            <div>
              <h1 class="text-lg font-semibold text-gray-900" style="font-family: Manrope, sans-serif;">ResumeShastra</h1>
              <p class="text-xs text-gray-500">Build. Optimize. Apply.</p>
            </div>
          </RouterLink>

          <!-- Navigation -->
          <nav class="hidden md:flex items-center gap-8">
            <a href="#features" class="text-gray-700 hover:text-gray-900 transition" style="font-family: Inter, sans-serif;">
              Features
            </a>
            <a href="#how-it-works" class="text-gray-700 hover:text-gray-900 transition" style="font-family: Inter, sans-serif;">
              How it works
            </a>
            <RouterLink to="/resume-builder" class="px-4 py-2 rounded-lg text-white font-medium transition" style="background-color: #B00149; font-family: Inter, sans-serif;">
              Start Building
            </RouterLink>
          </nav>

          <!-- Mobile Menu -->
          <div class="md:hidden">
            <RouterLink to="/resume-builder" class="px-4 py-2 rounded-lg text-white font-medium transition" style="background-color: #B00149;">
              Build
            </RouterLink>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <main class="flex-grow">
      <RouterView />
    </main>

    <!-- Footer -->
    <footer class="bg-gray-900 text-gray-300 border-t border-gray-800">
      <div class="max-w-7xl mx-auto px-6 py-12">
        <div class="grid grid-cols-1 md:grid-cols-4 gap-8 mb-8">
          <!-- Brand -->
          <div>
            <h3 class="text-white font-semibold text-lg mb-2" style="font-family: Manrope, sans-serif;">ResumeShastra</h3>
            <p class="text-sm text-gray-400" style="font-family: Inter, sans-serif;">
              Build honest, ATS-friendly resumes without design software.
            </p>
          </div>

          <!-- Product -->
          <div>
            <h4 class="text-white font-semibold mb-4" style="font-family: Manrope, sans-serif;">Product</h4>
            <ul class="space-y-2 text-sm" style="font-family: Inter, sans-serif;">
              <li><a href="#" class="hover:text-white transition">Features</a></li>
              <li><a href="#" class="hover:text-white transition">Pricing</a></li>
              <li><a href="#" class="hover:text-white transition">Build Now</a></li>
            </ul>
          </div>

          <!-- Company -->
          <div>
            <h4 class="text-white font-semibold mb-4" style="font-family: Manrope, sans-serif;">Company</h4>
            <ul class="space-y-2 text-sm" style="font-family: Inter, sans-serif;">
              <li><a href="#" class="hover:text-white transition">About</a></li>
              <li><a href="#" class="hover:text-white transition">Blog</a></li>
              <li><a href="#" class="hover:text-white transition">Contact</a></li>
            </ul>
          </div>

          <!-- Legal -->
          <div>
            <h4 class="text-white font-semibold mb-4" style="font-family: Manrope, sans-serif;">Legal</h4>
            <ul class="space-y-2 text-sm" style="font-family: Inter, sans-serif;">
              <li><a href="#" class="hover:text-white transition">Privacy</a></li>
              <li><a href="#" class="hover:text-white transition">Terms</a></li>
            </ul>
          </div>
        </div>

        <!-- Copyright -->
        <div class="border-t border-gray-800 pt-8">
          <p class="text-sm text-gray-500 text-center" style="font-family: Inter, sans-serif;">
            © 2024 ResumeShastra. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<style scoped>
::-webkit-scrollbar {
  width: 8px;
}

::-webkit-scrollbar-track {
  background: #F3F4F6;
}

::-webkit-scrollbar-thumb {
  background: #D1D5DB;
  border-radius: 4px;
}

::-webkit-scrollbar-thumb:hover {
  background: #9CA3AF;
}
</style>