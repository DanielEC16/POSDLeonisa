const API_URL = "http://localhost:8080/venta";

export const getVentas = async () => {
    const token = localStorage.getItem("token");

    const response = await fetch(API_URL+"/listar", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
        },
    });
    if(!response.ok) throw new Error("No se pudo obtener las ventas");
    return await response.json();
};