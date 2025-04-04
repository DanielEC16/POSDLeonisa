import { Link } from "react-router-dom";
import "./Navbar.scss";
import { useState } from "react";
export const Navbar = () => {
  const [activeNav, setActiveNav] = useState(true);

  return (
    <>
      <div className={`nav-bar-container ${activeNav ? "active" : ""}`}>
        <nav className="nav-bar-option">
          <ul>
            <li>
              <Link to="/dashboard/inicio">
                <i class="fa-solid fa-house"></i>
                <span>Inicio</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/clientes">
                <i class="fa-solid fa-user"></i>
                <span>Clientes</span>
              </Link>
            </li>
            <li>
              <Link to="/dashboard/productos">
                <i class="fa-solid fa-cake-candles"></i>
                <span>Productos</span>
              </Link>
            </li>
          </ul>
        </nav>
      </div>
    </>
  );
};
