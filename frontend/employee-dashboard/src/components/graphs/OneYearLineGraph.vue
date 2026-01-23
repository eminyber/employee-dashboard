<script setup>
import { ref, watch, onMounted } from "vue";
import {
  Chart,
  LineController,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale,
  Title,
  Tooltip,
  Legend,
} from "chart.js";

Chart.register(
  LineController,
  LineElement,
  PointElement,
  CategoryScale,
  LinearScale,
  Title,
  Tooltip,
  Legend,
);

const oneYearChartRef = ref(null);
let myChart = null;

const props = defineProps({
  data: {
    type: Array,
    required: true,
  },
  year: {
    type: Number,
    required: true,
  },
  required: true,
});

const monthNames = [
  "Jan",
  "Feb",
  "Mar",
  "Apr",
  "May",
  "Jun",
  "Jul",
  "Aug",
  "Sep",
  "Oct",
  "Nov",
  "Dec",
];

//Always show one year - handle missing months
const normalizeData = (data) => {
  const hiresPerMonth = Array(12).fill(0);
  data.forEach((item) => {
    if (item.monthIndex >= 1 && item.monthIndex <= 12) {
      hiresPerMonth[item.monthIndex - 1] = item.hireCount;
    }
  });
  return hiresPerMonth;
};

const buildChart = () => {
  if (!oneYearChartRef.value) return;

  const hiresPerMonth = normalizeData(props.data);
  const ctx = oneYearChartRef.value.getContext("2d");

  if (myChart) myChart.destroy();

  myChart = new Chart(ctx, {
    type: "line",
    data: {
      labels: monthNames,
      datasets: [
        {
          label: `Hires in ${props.year}`,
          data: hiresPerMonth,
          borderColor: "#3b82f6",
          backgroundColor: "rgba(59,130,246,0.2)",
          tension: 0.3,
          fill: true,
          pointRadius: 5,
        },
      ],
    },
    options: {
      responsive: true,
      plugins: {
        legend: { position: "top" },
        title: { display: true, text: `Hires in ${props.year}` },
      },
      scales: {
        y: { beginAtZero: true, stepSize: 1 },
        x: { title: { display: true, text: "Month" } },
      },
    },
  });
};

watch(() => props.data, buildChart, { deep: true });

onMounted(buildChart);
</script>

<template>
  <div class="w-full max-w-3xl mx-auto">
    <canvas ref="oneYearChartRef"></canvas>
  </div>
</template>
