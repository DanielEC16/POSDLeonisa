import { Outlet } from "react-router-dom";
import "./Dashboard.scss";
import { Sidebar } from "../../components/Sidebar";
export const Dashboard = () => { 
  return (
    <>
      <div className="container-fluid p-0 dashboard-container">
        <div className="d-flex" style={{ height: "100vh" }}>
          {/* Sidebar */}
          <Sidebar />
          <div className=" ds-panel overflow-auto w-100">
            {/* Contenido de las rutas de la aplicacion */}
            <Outlet />
          </div>
        </div>
      </div>
    </>
  );
};
