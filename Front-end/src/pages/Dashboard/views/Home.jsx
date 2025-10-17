import { useTitle } from "../../../hooks/useTitle";
import "./Home.scss";
import { Mybarchart } from "../../../components/Graficos/Mybarchart";
import { Linechart } from "../../../components/Graficos/Linechart";
import { Multiaxischart } from "../../../components/Graficos/Multiaxischart";
import { jwtDecode } from "jwt-decode";
export const Home = () => {
  useTitle("Dashboard | Home");
  return (
    <>
      <div className="cards-container">
        <div className="card">
          <div className="card-body">
            <h5>Ventas Totales</h5>
            <div className="card-information">
              <h3 className="m-0">S/2,456.00</h3>
              <i className="fa-solid fa-dollar-sign"></i>
            </div>
            <span>+15.3%</span>
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            <h5>Ventas Totales</h5>
            <div className="card-information">
              <h3>S/2,456.00</h3>
              <i className="fa-solid fa-dollar-sign"></i>
            </div>
            <span>+15.3%</span>
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            <h5>Ventas Totales</h5>
            <div className="card-information">
              <h3>S/2,456.00</h3>
              <i className="fa-solid fa-dollar-sign"></i>
            </div>
            <span>+15.3%</span>
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            <h5>Ventas Totales</h5>
            <div className="card-information">
              <h3>S/2,456.00</h3>
              <i className="fa-solid fa-dollar-sign"></i>
            </div>
            <span>+15.3%</span>
          </div>
        </div>
      </div>
      <div className="grafics-container">
        <div className="card">
          <div className="card-body">
            <Mybarchart />
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            <Linechart />
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            <Multiaxischart/>       
          </div>
        </div>
        <div className="card">
          <div className="card-body">
            
          </div>
        </div>
      </div>
    </>
  );
};
