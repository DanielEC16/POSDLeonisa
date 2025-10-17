import {
  Chart as ChartJS,
  LineElement,
  PointElement,
  LinearScale,
  CategoryScale,
  Filler,
  Tooltip,
  Legend,
} from "chart.js";
import { Line } from "react-chartjs-2";

// Registrar los componentes que usará Chart.js
ChartJS.register(
  LineElement,
  PointElement,
  LinearScale,
  CategoryScale,
  Filler, // ← esto permite el área rellena
  Tooltip,
  Legend
);

export const Linechart = () => {
  const data = {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo"],
    datasets: [
      {
        label: "Ventas",
        data: [30, 50, 45, 60, 80],
        fill: true, // ← activa el área rellena
        backgroundColor: "rgba(59, 130, 246, 0.2)", // azul claro
        borderColor: "rgba(59, 130, 246, 1)", // azul fuerte
        tension: 0.4, // curva suave
        pointRadius: 5,
        pointBackgroundColor: "#3b82f6",
      },
    ],
  };

  const options = {
    responsive: true,
    plugins: {
      legend: {
        display: true,
        position: "top",
      },
    },
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  };
  return <Line data={data} options={options} />;
};
