import { useState } from "react";
import { useTitle } from "../../hooks/useTitle";
import "./Login.scss";
export const Login = () => {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch('http://localhost:8080/auth/log-in', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
      });
      const data = await res.json();
      // Guardar token
      localStorage.setItem('token', data.jwt);
      // Mostrar info (opcional)
      alert(`Bienvenido ${data.username} - Rol: ${data.role}`);
    } catch (err) {
      console.error(err);
    }
  };

  useTitle("Login");
  return (
    <>

      <div className="container-login">
        <div className="parent">
          <div className="form-container">
            <form onSubmit={handleLogin}>
              <label>Usuario:</label>
              <input type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required />
              <label>Contraseña:</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <button type="submit">Entrar</button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};
