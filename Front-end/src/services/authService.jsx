const API_URL = 'http://localhost:8080/auth'

export const login = async (username, password) => {
    const response = await fetch(`${API_URL}/log-in`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password
        })
    })
    if(!response.ok) throw new Error("Error al iniciar sesión");
    const data = await response.json()
    localStorage.setItem('token', data.jwt)
    return data
}

export const logout = () => {
    localStorage.removeItem('token')
}