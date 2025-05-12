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
        <Route path="/" element={<Navigate to = "/login"/>} />
        <Route path="/login" element={<Login/>} />
        <Route path="/dashboard" element={<Dashboard />}>
          <Route path="inicio" element={<Home/>} />
          <Route path="productos" element={<Productos/>} />
          <Route path="clientes" element={<Clientes/>} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
