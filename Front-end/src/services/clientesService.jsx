const API_URL = 'http://localhost:8080/clientes'

export const getClientes = async () => {
    const token = localStorage.getItem('token');

    const response = await fetch(API_URL+"/listar",{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
            ,'Authorization': `Bearer ${token}`
        }
    });
    if(!response.ok) throw new Error("Error al obtener clientes");
    return await response.json()
}