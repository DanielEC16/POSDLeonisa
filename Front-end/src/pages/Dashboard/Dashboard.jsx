import { Outlet } from "react-router-dom";
import "./Dashboard.scss";
import { Sidebar } from "../../components/Sidebar";
export const Dashboard = () => {
  return (
    <>
      <div className="container-fluid">
        <div className="row">

          <Sidebar />

          <div className="col">
            a
          </div>

        </div>
      </div>
    </>
  );
};
