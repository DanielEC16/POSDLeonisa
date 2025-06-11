import { Link } from "react-router-dom";
import { useState } from "react";
import "./Sidebar.scss"

export const Sidebar = () => {
    const [active, setActive] = useState(true);

    const option = [
        {
            name: "Dashboard",
            path: "",
            icon: "fa-solid fa-gauge-high"
        },
        {
            name: "Clientes",
            path: "/clientes",
            icon: "fa-solid fa-user"
        },
        {
            name: "Productos",
            path: "/productos",
            icon: "fa-solid fa-cake-candles"
        }
    ]
    return (
        <div className={`sidebar-container ${active ? "" : "hidden"}`}>
            <div className="first-section">
                <div className="perfil-container">
                    <img src="https://www.strikegently.co/cdn/shop/files/penguin.png?v=1737571513" alt="user" />
                    <div className="perfil-info">
                        <h2>Daniel Cairo</h2>
                        <p>Rol : Admin</p>
                    </div>
                    <i className={
                        active ? "fa-solid fa-x" : "fa-solid fa-bars"
                    }
                    onClick={() => setActive(!active)}></i>
                </div>
                <hr />
                <div className="option-container">
                    <nav>
                        <ul>
                            {
                                option.map((item, index) => (
                                    <li key={index}>
                                        <Link to={`/dashboard${item.path}`}>
                                            <i className={item.icon}></i>
                                            <span>{item.name}</span>
                                        </Link>
                                    </li>
                                ))
                            }
                        </ul>
                    </nav>
                </div>
            </div>
            <div className="second-section">
                <hr />
                <div className="user-configuration">
                    <Link className="config" to="/dashboard/configuration">
                        <i className="fa-solid fa-gear"></i>
                        <span>Configuracion</span>
                    </Link>
                    <Link className="logout" to="/dashboard/exit">
                        <i className="fa-solid fa-right-from-bracket"></i>
                        <span>Logout</span>
                    </Link>
                </div>
            </div>
        </div>
    )
}