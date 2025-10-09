import { useState } from "react";
import { useTitle } from "../../hooks/useTitle";
import "./Login.scss";
import { useNavigate } from "react-router-dom";
import { login } from "../../services/authService";
export const Login = () => {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      await login(username, password);
      navigate("/dashboard");
    } catch (err) {
      console.error("no se pudo entrar");
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
