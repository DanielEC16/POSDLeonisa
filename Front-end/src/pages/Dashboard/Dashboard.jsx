import { Outlet } from "react-router-dom";
import { Navbar } from "../../components/Navbar";
import "./Dashboard.scss";
import { Navigator } from "../../components/Navigator";
export const Dashboard = () => {
  return (
    <>
      <div className="container-fluid">
        <div className="row">
          <Navigator />
          <div className="col-md-9 ms-sm-auto col-lg-10">
          <Outlet />
          </div>
        </div>
      </div>
    </>
  );
};
