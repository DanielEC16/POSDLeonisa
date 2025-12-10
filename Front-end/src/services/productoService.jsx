const API_URL = 'http://localhost:8080/productos'

export const getProducts = async () => {
    const token = localStorage.getItem('token');

    const response = await fetch(API_URL+"/listarTodo",{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
            ,'Authorization': `Bearer ${token}`
        }
    });
    if(!response.ok) throw new Error("Error al obtener productos");
    return await response.json()
}

export const getProductsByCode = async (code) => {
    const token = localStorage.getItem('token');

    const response = await fetch(`${API_URL}/buscar-${code}`,{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
            ,'Authorization': `Bearer ${token}`
        }
    })
    if(!response.ok) throw new Error("Error al obtener productos");
    return await response.json()
}