import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { Dashboard } from "./pages/Dashboard/Dashboard";
import { Login } from "./pages/Login/Login";
import { Home } from "./pages/Dashboard/views/Home";
import { Productos } from "./pages/Dashboard/views/Productos";
import { Clientes } from "./pages/Dashboard/views/Clientes";
import { logout } from "./services/authService";
import { useEffect } from "react";
import { isTokenExpired } from "./utils/checkToken";
import "./App.scss";
import { useState } from "react";

export default function App() {
  const navigate = useNavigate();
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    console.log("🧠 Ejecutando verificación de token...");

    const token = localStorage.getItem("token");
    if (!token || isTokenExpired(token)) {
      logout();
      setIsAuthenticated(false);
      navigate("/login", { replace: true });
    } else {
      console.log("✅ Token no expirado");
      setIsAuthenticated(true);
    }
    setLoading(false);
  }, [navigate]);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <Routes>
        {/* Redirección raíz */}
        <Route path="/" element={<Navigate to="/login" replace />} />

        {/* Ruta login */}
        <Route
          path="/login"
          element={isAuthenticated ? <Navigate to="/dashboard" /> : <Login />}
        />

        {/* Rutas protegidas */}
        <Route
          path="/dashboard"
          element={
            isAuthenticated ? <Dashboard /> : <Navigate to="/login" replace />
          }
        >
          <Route index element={<Home />} />
          <Route path="productos" element={<Productos />} />
          <Route path="clientes" element={<Clientes />} />
        </Route>

        {/* Cualquier otra ruta */}
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </>
  );
}

