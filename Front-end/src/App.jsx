import { Navigate, Route, Routes } from "react-router-dom";
import { Dashboard } from "./pages/Dashboard/Dashboard";
import { Login } from "./pages/Login/Login";
import { Home } from "./pages/Dashboard/views/Home";
import { Productos } from "./pages/Dashboard/views/Productos";
import { Clientes } from "./pages/Dashboard/views/Clientes";
import "./App.scss";

function App() {
  return (
    <>
      <Routes>
        {/* Rutas para Login */}
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        
        {/* Rutas del Dashboard */}
        <Route path="/dashboard" element={<Dashboard />}>
          {/* Rutas hacia vista Home */}
          <Route path="" element={<Home />} />
          {/* Rutas hacia vista Productos */}
          <Route path="productos" element={<Productos />} />
          {/* Rutas hacia vista Clientes */}
          <Route path="clientes" element={<Clientes />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
