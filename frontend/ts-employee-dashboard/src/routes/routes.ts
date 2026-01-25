import {
  createRouter,
  createWebHistory,
  type RouteRecordRaw,
} from "vue-router";

import AppLayout from "../layouts/AppLayout.vue";
import EmployeesView from "../views/EmployeesView.vue";
import DashboardView from "../views/DashboardView.vue";

const routes: RouteRecordRaw[] = [
  {
    path: "/",
    component: AppLayout,
    children: [
      {
        path: "",
        name: "employees",
        component: EmployeesView,
      },
      {
        path: "dashboard",
        name: "dashboard",
        component: DashboardView,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
