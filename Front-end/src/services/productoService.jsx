const API_URL = 'http://localhost:8080/productos'

export const getProducts = async () => {
    const response = await fetch(API_URL+"/listar");
    if(!response.ok) throw new Error("Error al obtener productos");
    return response.json()
}