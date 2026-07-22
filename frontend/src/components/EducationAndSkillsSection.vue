<!-- src/components/EducationAndSkillsSection.vue -->
<template>
  <section class="space-y-8">
    <!-- Header -->
    <div>
      <h2 class="text-2xl font-bold">
        Education & Skills
      </h2>

      <p class="mt-2 text-sm text-gray-600">
        Add your educational qualifications and technical skills.
      </p>
    </div>

    <!-- Education Section -->
    <div class="rounded-lg border p-6">
      <div class="flex items-center justify-between">
        <div>
          <h3 class="text-lg font-semibold">
            Education
          </h3>

          <p class="mt-1 text-sm text-gray-500">
            Manage your academic qualifications.
          </p>
        </div>

        <button
          type="button"
          @click="openEducationForm"
          class="rounded-md border px-4 py-2 text-sm font-medium transition hover:bg-gray-50"
          :disabled="isSubmitting"
        >
          + Add Education
        </button>
      </div>

      <!-- Empty State -->
      <div
        v-if="!showEducationForm && educationList.length === 0"
        class="mt-8 rounded-lg border border-dashed p-10 text-center"
      >
        <p class="text-gray-500">
          No education added yet.
        </p>

        <p class="mt-2 text-sm text-gray-400">
          Click "Add Education" to get started.
        </p>
      </div>

      <!-- Education Cards -->
      <div
        v-if="!showEducationForm && educationList.length"
        class="mt-8 space-y-4"
      >
        <div
          v-for="(education, index) in educationList"
          :key="education.id || index"
          class="rounded-lg border p-5"
        >
          <div class="flex items-start justify-between">
            <div class="flex-1 pr-4">
              <h4 class="font-semibold text-gray-900">
                {{ education.degree || education.customDegree || education.educationLevel }}
                <span v-if="education.branch || education.major || education.specialization">
                  in {{ education.branch || education.major || education.specialization }}
                </span>
              </h4>

              <p class="mt-1 text-sm text-gray-700">
                {{ education.institution }} 
                <span v-if="education.universityBoard" class="text-gray-500">({{ education.universityBoard }})</span>
              </p>

              <div class="mt-2 flex flex-wrap gap-x-4 text-xs text-gray-500">
                <span v-if="education.startYear" class="flex items-center gap-1">
                  📅 {{ education.startMonth }} {{ education.startYear }} - 
                  {{ education.currentlyStudying ? "Present" : (education.endMonth + ' ' + education.endYear) }}
                </span>
                <span v-if="education.score" class="flex items-center gap-1">
                  🎯 {{ education.scoreType }}: {{ education.score }}
                </span>
              </div>

              <p v-if="education.description" class="mt-3 text-sm text-gray-600 line-clamp-2">
                {{ education.description }}
              </p>
            </div>

            <!-- Action Buttons -->
            <div class="flex gap-2">
              <button 
                @click="moveEducationUp(index)" 
                :disabled="index === 0" 
                class="rounded border px-3 py-1 text-sm disabled:opacity-40"
              >
                ↑
              </button> 
              
              <button 
                @click="moveEducationDown(index)" 
                :disabled="index === educationList.length - 1" 
                class="rounded border px-3 py-1 text-sm disabled:opacity-40"
              >
                ↓
              </button>

              <button
                @click="editEducation(index)"
                class="rounded border px-3 py-1 text-sm hover:bg-gray-100"
              >
                Edit
              </button>

              <button 
                @click="deleteEducation(index)" 
                class="rounded border px-3 py-1 text-sm text-red-600 hover:bg-red-50"
              >
                Delete
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Education Form -->
      <div
        v-else-if="showEducationForm"
        class="mt-8 rounded-lg border p-6"
      >
        <h4 class="text-lg font-semibold">
          {{ editingIndex === -1 ? 'Add Education' : 'Edit Education' }}
        </h4>

        <p class="mt-1 text-sm text-gray-500">
          Fill in your academic qualification.
        </p>

        <div class="mt-6">
          <div class="grid gap-6">
            <!-- Education Level -->
            <div>
              <label class="mb-2 block text-sm font-medium">
                Education Level
              </label>

              <select
                v-model="educationForm.educationLevel"
                class="w-full rounded-md border px-3 py-2"
              >
                <option disabled value="">
                  Select Education Level
                </option>
                <option>SSC (10th)</option>
                <option>Intermediate (12th)</option>
                <option>Diploma</option>
                <option>Bachelor's</option>
                <option>Master's</option>
                <option>Doctorate</option>
              </select>
            </div>

            <!-- Custom Education -->
            <div>
              <label class="mb-2 block text-sm font-medium">
                Custom Education Level (Optional)
              </label>
              
              <input
                v-model="educationForm.customEducationLevel"
                type="text"
                placeholder="Example: ITI, CA, MBBS..."
                class="w-full rounded-md border px-3 py-2"
              />
            </div>

            <!-- Degree -->
            <div v-if="educationForm.educationLevel === `Bachelor's` || educationForm.educationLevel === `Master's`">
              <label class="mb-2 block text-sm font-medium">
                Degree
              </label>

              <select
                v-model="educationForm.degree"
                class="w-full rounded-md border px-3 py-2"
              >
                <option disabled value="">Select Degree</option>
                <option>B.Sc</option>
                <option>BCA</option>
                <option>B.Com</option>
                <option>BBA</option>
                <option>BA</option>
                <option>B.Tech</option>
                <option>BE</option>
                <option>M.Sc</option>
                <option>MCA</option>
                <option>M.Com</option>
                <option>MBA</option>
                <option>MA</option>
                <option>M.Tech</option>
                <option>ME</option>
              </select>

              <input
                v-model="educationForm.customDegree"
                class="mt-3 w-full rounded-md border px-3 py-2"
                placeholder="Custom Degree (Optional)"
              />
            </div>

            <!-- Engineering -->
            <div
              v-if="educationForm.degree === 'B.Tech' ||
                    educationForm.degree === 'BE' ||
                    educationForm.degree === 'M.Tech' ||
                    educationForm.degree === 'ME'"
              class="grid gap-6 md:grid-cols-2"
            >
              <div>
                <label class="mb-2 block text-sm font-medium">Branch</label>
                <input
                  v-model="educationForm.branch"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Computer Science"
                />
              </div>
              <div>
                <label class="mb-2 block text-sm font-medium">Specialization (Optional)</label>
                <input
                  v-model="educationForm.specialization"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Artificial Intelligence"
                />
              </div>
            </div>

            <!-- Non Engineering -->
            <div
              v-else-if="educationForm.degree"
              class="grid gap-6 md:grid-cols-2"
            >
              <div>
                <label class="mb-2 block text-sm font-medium">Major</label>
                <input
                  v-model="educationForm.major"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Computer Science"
                />
              </div>
              <div>
                <label class="mb-2 block text-sm font-medium">Minor (Optional)</label>
                <input
                  v-model="educationForm.minor"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Cloud Computing"
                />
              </div>
            </div>

            <!-- Institution -->
            <div class="grid gap-6 md:grid-cols-2">
              <div>
                <label class="mb-2 block text-sm font-medium">Institution</label>
                <input
                  v-model="educationForm.institution"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Aditya Degree College"
                />
              </div>
              <div>
                <label class="mb-2 block text-sm font-medium">University / Board</label>
                <input
                  v-model="educationForm.universityBoard"
                  class="w-full rounded-md border px-3 py-2"
                  placeholder="Andhra University"
                />
              </div>
            </div>

            <div class="grid gap-6 md:grid-cols-2">
              <!-- Score Type -->
              <div>
                <label class="mb-2 block text-sm font-medium">Academic Score</label>
                <div class="flex gap-6 mt-2">
                  <label class="flex items-center gap-2">
                    <input
                      type="radio"
                      value="CGPA"
                      v-model="educationForm.scoreType"
                    />
                    CGPA
                  </label>
                  <label class="flex items-center gap-2">
                    <input
                      type="radio"
                      value="Percentage"
                      v-model="educationForm.scoreType"
                    />
                    Percentage
                  </label>
                </div>
              </div>

              <!-- Score -->
              <div>
                <label class="mb-2 block text-sm font-medium">
                  {{ educationForm.scoreType }}
                </label>
                <input
                  v-model="educationForm.score"
                  type="number"
                  step="0.01"
                  class="w-full rounded-md border px-3 py-2"
                  :placeholder="educationForm.scoreType === 'CGPA'
                    ? 'Example: 8.45'
                    : 'Example: 84.5'"
                />
              </div>
            </div>

            <div class="grid gap-6 md:grid-cols-2">
              <!-- Start -->
              <div>
                <label class="mb-2 block text-sm font-medium">Start Date</label>
                <div class="grid grid-cols-2 gap-3">
                  <select
                    v-model="educationForm.startMonth"
                    class="rounded-md border px-3 py-2"
                  >
                    <option disabled value="">Month</option>
                    <option>Jan</option>
                    <option>Feb</option>
                    <option>Mar</option>
                    <option>Apr</option>
                    <option>May</option>
                    <option>Jun</option>
                    <option>Jul</option>
                    <option>Aug</option>
                    <option>Sep</option>
                    <option>Oct</option>
                    <option>Nov</option>
                    <option>Dec</option>
                  </select>
                  <input
                    v-model="educationForm.startYear"
                    type="number"
                    placeholder="Year"
                    class="rounded-md border px-3 py-2"
                  />
                </div>
              </div>

              <!-- End -->
              <div>
                <label class="mb-2 block text-sm font-medium">End Date</label>
                <div class="grid grid-cols-2 gap-3">
                  <select
                    :disabled="educationForm.currentlyStudying"
                    v-model="educationForm.endMonth"
                    class="rounded-md border px-3 py-2"
                  >
                    <option disabled value="">Month</option>
                    <option>Jan</option>
                    <option>Feb</option>
                    <option>Mar</option>
                    <option>Apr</option>
                    <option>May</option>
                    <option>Jun</option>
                    <option>Jul</option>
                    <option>Aug</option>
                    <option>Sep</option>
                    <option>Oct</option>
                    <option>Nov</option>
                    <option>Dec</option>
                  </select>
                  <input
                    :disabled="educationForm.currentlyStudying"
                    v-model="educationForm.endYear"
                    type="number"
                    placeholder="Year"
                    class="rounded-md border px-3 py-2"
                  />
                </div>
              </div>
            </div>

            <div>
              <label class="flex items-center gap-3">
                <input
                  type="checkbox"
                  v-model="educationForm.currentlyStudying"
                />
                <span>I am currently studying here</span>
              </label>
            </div>

            <div>
              <label class="mb-2 block text-sm font-medium">
                Description (Optional)
              </label>
              <textarea
                v-model="educationForm.description"
                rows="4"
                class="w-full rounded-md border px-3 py-2"
                placeholder="Achievements, coursework, activities..."
              ></textarea>
            </div>
          </div>
        </div>

        <div class="mt-6 flex justify-end gap-3">
          <button
            type="button"
            @click="closeEducationForm"
            class="rounded-md border px-4 py-2 text-sm hover:bg-gray-50"
            :disabled="isSubmitting"
          >
            Cancel
          </button>

          <button
            type="button"
            @click="saveEducation"
            class="rounded-md bg-blue-600 px-4 py-2 text-sm font-medium text-white hover:bg-blue-700 disabled:opacity-50"
            :disabled="isSubmitting"
          >
            {{ isSubmitting ? "Saving..." : (editingIndex === -1 ? "Save Education" : "Update Education") }}
          </button>
        </div>
      </div>
    </div>

    <!-- Skills Section -->
    <div class="rounded-lg border p-6">
      <h3 class="text-lg font-semibold">
        Technical Skills
      </h3>
      <p class="mt-1 text-sm text-gray-500">
        Select popular skills or add your own.
      </p>

      <div
        v-for="category in skillCategories"
        :key="category.id"
        class="mt-8 border-b pb-6 last:border-b-0"
      >
        <div class="flex items-center justify-between mb-4">
          <h4 class="font-semibold">{{ category.name }}</h4>
        </div>

        <!-- Chips (Only if predefined skills exist) -->
        <div v-if="category.predefinedSkills.length" class="flex flex-wrap gap-3">
          <button
            v-for="skill in category.predefinedSkills"
            :key="skill"
            type="button"
            @click="toggleSkill(category, skill)"
            :class="[
              'rounded-full border px-4 py-2 text-sm transition',
              category.selectedSkills.includes(skill)
                ? 'bg-blue-600 text-white border-blue-600'
                : 'hover:bg-gray-100'
            ]"
          >
            {{ skill }}
          </button>
        </div>

        <!-- Additional / Custom Skills -->
        <div :class="category.predefinedSkills.length ? 'mt-5' : ''">
          <label class="mb-2 block text-sm font-medium">
            {{ category.isCustom ? 'Skills' : 'Additional Skills' }}
          </label>
          <textarea
            v-model="category.customSkills"
            rows="3"
            class="w-full rounded-md border px-3 py-2"
            :placeholder="category.isCustom ? 'Example:\nTensorFlow\nPyTorch\nOpenCV' : 'Example:\nFastAPI\nRust\n\nor\n\nFastAPI, Rust'"
          ></textarea>
        </div>

        <!-- Custom Category Action Buttons -->
        <div
          v-if="category.isCustom"
          class="mt-4 flex gap-3"
        >
          <button
            @click="editCustomCategory(category)"
            class="rounded border px-4 py-2 text-sm"
          >
            Edit
          </button>
          <button
            @click="deleteCustomCategory(category.id)"
            class="rounded border border-red-300 px-4 py-2 text-sm text-red-600 hover:bg-red-50"
          >
            Delete
          </button>
        </div>
        
        <!-- Selected Skills as Removable Chips -->
        <div v-if="category.selectedSkills.length" class="mt-5">
          <label class="mb-2 block text-sm font-medium">Selected Skills</label>
          <div class="flex flex-wrap gap-2">
            <button
              v-for="skill in category.selectedSkills"
              :key="skill"
              type="button"
              @click="removeSkill(category, skill)"
              class="flex items-center gap-2 rounded-full bg-blue-100 px-3 py-1 text-sm text-blue-700 transition hover:bg-blue-200"
            >
              <span>{{ skill }}</span>
              <span class="font-bold">&times;</span>
            </button>
          </div>
        </div>
      </div>

      <!-- Add Custom Category Section -->
      <div v-if="!showCustomCategoryForm" class="mt-8 flex justify-center">
        <button
          type="button"
          @click="showCustomCategoryForm = true"
          class="rounded-md border border-dashed px-6 py-3 hover:bg-gray-50"
        >
          + Add Custom Category
        </button>
      </div>

      <!-- Custom Category Form -->
      <div
        v-if="showCustomCategoryForm"
        class="mt-6 rounded-lg border p-6"
      >
        <h4 class="text-lg font-semibold">
          {{ editingCustomCategoryId ? 'Edit Custom Category' : 'Add Custom Category' }}
        </h4>

        <div class="mt-5">
          <label class="mb-2 block text-sm font-medium">
            Category Name
          </label>
          <input
            v-model="customCategoryForm.name"
            class="w-full rounded-md border px-3 py-2"
            placeholder="Example: AI / Machine Learning"
          />
        </div>

        <div class="mt-5">
          <label class="mb-2 block text-sm font-medium">
            Skills
          </label>
          <textarea
            v-model="customCategoryForm.customSkills"
            rows="4"
            class="w-full rounded-md border px-3 py-2"
            placeholder="TensorFlow&#10;PyTorch&#10;OpenCV&#10;&#10;or&#10;&#10;TensorFlow, PyTorch"
          ></textarea>
        </div>

        <div class="mt-6 flex justify-end gap-3">
          <button
            @click="closeCustomCategoryForm"
            class="rounded border px-4 py-2"
          >
            Cancel
          </button>
          <button
            @click="saveCustomCategory"
            class="rounded bg-blue-600 px-4 py-2 text-white"
          >
            Save Category
          </button>
        </div>
      </div>
    </div>

    <!-- Navigation Buttons -->
    <div class="mt-8 flex gap-3 border-t pt-6">
      <button
        @click="$emit('previous')"
        class="rounded-lg bg-gray-100 px-6 py-3 font-medium text-gray-700 transition-colors hover:bg-gray-200"
      >
        Previous
      </button>
      
      <button
        @click="handleNext"
        :disabled="isSubmitting"
        class="flex-1 rounded-lg text-white font-medium transition-colors disabled:opacity-50"
        style="background:#B00149"
      >
        {{ isSubmitting ? 'Saving...' : 'Continue' }}
      </button>
    </div>
  </section>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { resumeApi } from "../services/api";

const emit = defineEmits(['educationUpdated', 'skillsUpdated', 'previous', 'next']);

// --- Education State & Logic ---
const showEducationForm = ref(false);
const educationList = ref([]);
const editingIndex = ref(-1);
const isSubmitting = ref(false);
const isLoading = ref(false);
const resumeId = ref(null);

const educationForm = ref({
  educationLevel: "",
  customEducationLevel: "",
  degree: "",
  customDegree: "",
  branch: "",
  major: "",
  minor: "",
  specialization: "",
  institution: "",
  university: "",
  scoreType: "CGPA",
  score: "",
  startMonth: "",
  startYear: "",
  endMonth: "",
  endYear: "",
  currentlyStudying: false,
  description: "",
});

// Watch educationList and emit changes to the parent (for PreviewPanel)
watch(educationList, (newList) => {
  emit('educationUpdated', newList);
}, { deep: true });

onMounted(() => {
  resumeId.value = localStorage.getItem("resumeId");
  if (resumeId.value) {
    loadEducations();
  }
});

async function loadEducations() {
  if (!resumeId.value) return;
  isLoading.value = true;
  try {
    const response = await resumeApi.getEducation(resumeId.value);
    educationList.value = response.data || response || [];
  } catch (error) {
    console.error("Failed to load educations:", error);
  } finally {
    isLoading.value = false;
  }
}

function openEducationForm() {
  showEducationForm.value = true;
}

function resetEducationForm() {
  educationForm.value = {
    educationLevel: "",
    customEducationLevel: "",
    degree: "",
    customDegree: "",
    branch: "",
    major: "",
    minor: "",
    specialization: "",
    institution: "",
    university: "",
    scoreType: "CGPA",
    score: "",
    startMonth: "",
    startYear: "",
    endMonth: "",
    endYear: "",
    currentlyStudying: false,
    description: "",
  };
}

function closeEducationForm() {
  showEducationForm.value = false;
  resetEducationForm();
}

async function saveEducation() {
  if (!educationForm.value.educationLevel) {
    alert("Please select Education Level");
    return;
  }

  if (!educationForm.value.institution.trim()) {
    alert("Institution is required");
    return;
  }

  if (!resumeId.value) {
    alert("Resume ID not found. Please complete Personal Details first.");
    return;
  }

  const data = { ...educationForm.value };
  isSubmitting.value = true;

  try {
    if (editingIndex.value !== -1) {
      // Update existing
      const educationId = educationList.value[editingIndex.value].id;
      if (educationId) {
        await resumeApi.updateEducation(resumeId.value, educationId, data);
        educationList.value[editingIndex.value] = { id: educationId, ...data };
      } else {
        // Fallback for edge cases where id might be missing locally
        educationList.value[editingIndex.value] = data; 
      }
    } else {
      // Create new
      const response = await resumeApi.saveEducation(resumeId.value, data);
      const savedData = response.data || response;
      educationList.value.push(savedData);
    }
    
    editingIndex.value = -1;
    closeEducationForm();
  } catch (error) {
    alert("Failed to save education: " + (error.message || "Unknown error"));
  } finally {
    isSubmitting.value = false;
  }
}

function editEducation(index) {
  educationForm.value = { ...educationList.value[index] };
  editingIndex.value = index;
  showEducationForm.value = true;
}

async function deleteEducation(index) {
  if (!confirm("Are you sure you want to delete this education entry?")) {
    return;
  }
  
  const educationId = educationList.value[index].id;
  if (!educationId) {
    educationList.value.splice(index, 1);
    return;
  }

  try {
    await resumeApi.deleteEducation(resumeId.value, educationId);
    educationList.value.splice(index, 1);
  } catch (error) {
    alert("Failed to delete education: " + (error.message || "Unknown error"));
  }
}

async function moveEducationUp(index) {
  if (index > 0) {
    const educationId = educationList.value[index].id;
    try {
      if (educationId) {
        await resumeApi.updateEducationDisplayOrder(resumeId.value, educationId, index);
      }
      const temp = educationList.value[index];
      educationList.value[index] = educationList.value[index - 1];
      educationList.value[index - 1] = temp;
    } catch (error) {
      alert("Failed to reorder education: " + (error.message || "Unknown error"));
    }
  }
}

async function moveEducationDown(index) {
  if (index < educationList.value.length - 1) {
    const educationId = educationList.value[index].id;
    try {
      if (educationId) {
        await resumeApi.updateEducationDisplayOrder(resumeId.value, educationId, index + 2);
      }
      const temp = educationList.value[index];
      educationList.value[index] = educationList.value[index + 1];
      educationList.value[index + 1] = temp;
    } catch (error) {
      alert("Failed to reorder education: " + (error.message || "Unknown error"));
    }
  }
}

// --- Skills State & Logic ---
const skillCategories = ref([
  {
    id: 1,
    name: "Programming Languages",
    predefinedSkills: ["C", "C++", "Java", "Python", "JavaScript", "TypeScript"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 2,
    name: "Frontend",
    predefinedSkills: ["HTML", "CSS", "React", "Vue.js", "Angular", "Bootstrap", "Tailwind CSS", "Vite"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 3,
    name: "Backend",
    predefinedSkills: ["Node.js", "Express.js", "Spring Boot", "Django", "Flask", "Laravel"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 4,
    name: "Databases",
    predefinedSkills: ["MySQL", "PostgreSQL", "MongoDB", "SQLite", "Oracle"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 5,
    name: "Authentication & Security",
    predefinedSkills: ["JWT", "OAuth", "Firebase Authentication", "Spring Security"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 6,
    name: "Cloud & DevOps",
    predefinedSkills: ["AWS", "Azure", "Google Cloud", "Docker", "Kubernetes", "Render", "Cloudflare Pages"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 7,
    name: "Developer Tools",
    predefinedSkills: ["Git", "GitHub", "VS Code", "Postman", "Linux", "npm"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  },
  {
    id: 8,
    name: "Concepts",
    predefinedSkills: ["REST APIs", "CRUD", "MVC", "DBMS", "OOP", "Responsive Design"],
    selectedSkills: [],
    customSkills: "",
    isCustom: false
  }
]);

// Watch skills and emit to parent for Preview Panel
watch(skillCategories, (newCategories) => {
  const allSkills = newCategories.map(cat => {
    const customSkillsArr = cat.customSkills 
      ? cat.customSkills.split(/[\n,]+/).map(s => s.trim()).filter(Boolean) 
      : [];
    
    return {
      category: cat.name,
      skills: [...cat.selectedSkills, ...customSkillsArr]
    };
  }).filter(cat => cat.skills.length > 0);
  
  emit('skillsUpdated', allSkills);
}, { deep: true });

// Skill Selection Toggle
function toggleSkill(category, skill) {
  const index = category.selectedSkills.indexOf(skill);
  if (index === -1) {
    category.selectedSkills.push(skill);
  } else {
    category.selectedSkills.splice(index, 1);
  }
}

// Remove Selected Skill specifically via 'x' click
function removeSkill(category, skill) {
  category.selectedSkills = category.selectedSkills.filter((s) => s !== skill);
}

// --- Custom Category Logic ---
const showCustomCategoryForm = ref(false);
const editingCustomCategoryId = ref(null);

const customCategoryForm = ref({
  name: "",
  customSkills: ""
});

let nextCategoryId = 9;

function closeCustomCategoryForm() {
  showCustomCategoryForm.value = false;
  customCategoryForm.value = { name: "", customSkills: "" };
  editingCustomCategoryId.value = null;
}

function saveCustomCategory() {
  if (!customCategoryForm.value.name.trim()) {
    alert("Category name is required");
    return;
  }

  const skills = customCategoryForm.value.customSkills
    .split(/[\n,]+/)
    .map(skill => skill.trim())
    .filter(Boolean);

  if (!skills.length) {
    alert("Please add at least one skill.");
    return;
  }

  const exists = skillCategories.value.some(
    category =>
      category.name.toLowerCase() ===
        customCategoryForm.value.name.trim().toLowerCase() &&
      category.id !== editingCustomCategoryId.value
  );

  if (exists) {
    alert("Category already exists.");
    return;
  }

  const category = {
    id: editingCustomCategoryId.value ?? nextCategoryId++,
    name: customCategoryForm.value.name.trim(),
    predefinedSkills: [], 
    selectedSkills: [],
    customSkills: skills.join("\n"),
    isCustom: true
  };

  if (editingCustomCategoryId.value === null) {
    skillCategories.value.push(category);
  } else {
    const index = skillCategories.value.findIndex(
      c => c.id === editingCustomCategoryId.value
    );
    skillCategories.value[index] = category;
  }

  closeCustomCategoryForm();
}

function editCustomCategory(category) {
  customCategoryForm.value = {
    name: category.name,
    customSkills: category.customSkills
  };
  editingCustomCategoryId.value = category.id;
  showCustomCategoryForm.value = true;
}

function deleteCustomCategory(id) {
  if (!confirm("Delete this category?")) return;
  
  skillCategories.value = skillCategories.value.filter(
    category => category.id !== id
  );
}
async function handleNext() {
  if (!resumeId.value) {
    emit('next');
    return;
  }

  isSubmitting.value = true;
  try {
    const savePromises = [];

    skillCategories.value.forEach(cat => {
      // Get all custom skills typed in the text area
      const customArr = cat.customSkills 
        ? cat.customSkills.split(/[\n,]+/).map(s => s.trim()).filter(Boolean) 
        : [];
        
      // Combine chips and custom skills
      const allCatSkills = [...cat.selectedSkills, ...customArr];

      // Create a save request for each individual skill
      allCatSkills.forEach(skillName => {
        savePromises.push(
          // Notice it is saveSkill (no "s" at the end)
          resumeApi.saveSkill(resumeId.value, {
            category: cat.name,
            name: skillName
          })
        );
      });
    });

    // Wait for all skills to finish saving to the database
    if (savePromises.length > 0) {
      await Promise.all(savePromises);
    }
    
    // Move to next step!
    emit('next');
  } catch (error) {
    alert("Failed to save skills: " + (error.message || "Unknown error"));
  } finally {
    isSubmitting.value = false;
  }
}
</script>