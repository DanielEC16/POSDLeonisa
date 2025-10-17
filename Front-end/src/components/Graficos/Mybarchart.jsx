import { Bar } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);
export const Mybarchart = () => {
  const data = {
    labels: [
      "Enero",
      "Febrero",
      "Marzo",
      "Abril",
      "Mayo",
      "Junio",
      "Julio",
      "Agosto",
      "Septiembre",
      "Octubre",
      "Noviembre",
      "Diciembre",
    ], // datos de las etiquetas eje x
    datasets: [
      // datos que iran en el grafico de barras
      {
        label: "Ventas", // etiqueta del dataset
        data: [12, 19, 3, 5, 2, 3, 5, 2, 3, 4, 6, 3], // datos de las barras
        backgroundColor: "rgba(255, 99, 132, 0.5)", // color de las barras
        borderRadius: 5, // radio de los bordes
        categoryPercentage: 1, 
        barPercentage: 1, 
      },
      {
        label: "Compras",
        data: [2, 2, 3, 5, 2, 3, 5, 2, 3, 4, 6, 3],
        backgroundColor: "rgba(53, 162, 235, 0.5)",
        borderRadius: 5,
        categoryPercentage: 1, 
        barPercentage: 1,
      },
    ],
  };
  // configuracion de las opciones del grafico
  const options = {
    responsive: true, // si se quiere que el grafico se ajuste a la ventana
    plugins: {
      legend: {
        position: "bottom", // posicion de la leyenda (top, bottom, left, right)
        labels: {
          color: "#333", // color del texto
          font: {
            size: 15,
          },
        },
      },
      title: {
        display: true, // si se quiere mostrar el titulo
        text: "Ventas Mensuales", // texto del titulo
        color: "#555", // color del texto
        font: {
          // configuracion de la fuente
          size: 40, // tamaño de la fuente
        },
      },
    },
    scales: {
      y: {
        beginAtZero: false,
        ticks: {
          color: "#000",
          stepSize: 5,
        },
      },
      x: {
        ticks: {
          color: "#555",
        },
      },
    },
  };
  return <Bar data={data} options={options} />;
};
