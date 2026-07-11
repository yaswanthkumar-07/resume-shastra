import { createRouter, createWebHistory } from "vue-router";

import HomePage from "../pages/HomePage.vue";
import ResumeBuilderPage from "../pages/ResumeBuilderPage.vue";
import NotFoundPage from "../pages/NotFoundPage.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: HomePage,
    },
    {
      path: "/builder",
      component: ResumeBuilderPage,
    },
    {
      path: "/:pathMatch(.*)*",
      component: NotFoundPage,
    },
  ],
});

export default router;