import { Link } from "react-router-dom";
import "./Navbar.scss";
import { useState } from "react";
export const Navbar = () => {
  const [activeNav, setActiveNav] = useState(false);

  return (
    <>
      <div className={`nav-bar-container ${activeNav ? "active" : ""}`}>
        <button className="side-bar" onClick={() => setActiveNav(!activeNav)}>
          <i className="fa-solid fa-arrow-left"></i>
        </button>

        <div className="nav-bar-info-user">
          <div className="user-foto">
            <img
              src="https://avatars.githubusercontent.com/u/115848645?v=4&size=64"
              alt="user"
            />
          </div>
          <div className="user-info">
            <span>Admin</span>
            <h2>DanielCairo</h2>
          </div>
        </div>
        <hr />
        <nav className="nav-bar-option">
          <ul>
            <li>
              <Link to="/dashboard/inicio">
                <i className="fa-solid fa-house"></i>
                <span>Inicio</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/clientes">
                <i className="fa-solid fa-user"></i>
                <span>Clientes</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/productos">
                <i className="fa-solid fa-cake-candles"></i>
                <span>Productos</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/usuarios">
                <i className="fa-solid fa-screwdriver-wrench"></i>
                <span>Usuarios</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/configuration">
                <i className="fa-solid fa-gear"></i>
                <span>Configuracion</span>
              </Link>
            </li>
          </ul>
        </nav>
        <hr />

        <button className="logout-user">
          <i className="fa-solid fa-right-from-bracket"></i>
          <p>Logout</p>
        </button>
      </div>
    </>
  );
};
