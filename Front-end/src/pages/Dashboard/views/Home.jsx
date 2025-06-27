import { useTitle } from "../../../hooks/useTitle";
import { Mybarchart } from "../../../components/Mybarchart";
import "./Home.scss";
import { Linechart } from "../../../components/Linechart";
import { Multiaxischart } from "../../../components/Multiaxischart";
import { jwtDecode } from "jwt-decode";
export const Home = () => {
  useTitle("Dashboard | Home");
  const token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJZby1zb3ktdHVCYWNrZW5kIiwic3ViIjoic2FudGlhZ28iLCJyb2xlIjoiUk9MRV9BRE1JTiIsImlhdCI6MTc1MDkxNTM3MSwiZXhwIjoxNzUwOTE3MTcxLCJqdGkiOiIyZmI4MWIwMC0zZjkwLTQ5MGItYjY4Yi02NDc3NGE0MzU4ZTUiLCJuYmYiOjE3NTA5MTUzNzF9.56KmlHMERVFQR0AiMMuti-AC7S3-GuuMmUyF70gmdmY"
  const decode = jwtDecode(token);
  console.log(decode.sub);
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
