import { useTitle } from "../../../hooks/useTitle";
import "./Clientes.scss";

export const Clientes = () => {
  useTitle("Dashboard | Clientes");
  return (
    <>
      <div className="clientes-panel">
        <div className="tittle">
          <h3>👤Gestion de Clientes</h3>
          <button>
            <i class="fa-solid fa-plus"></i>
            Nuevo Cliente
          </button>
        </div>
        <div className="filter-container">
          <input className="input-search" type="text" placeholder="🔍Buscar cliente" />
          <div className="export">
            <button>
              Exportar
            </button>
            <button>
              Exportar
            </button>
          </div>
        </div>
        <div className="table-clientes">
          <table>
            <thead>
              <tr className="text-center">
                <th>Nombre</th>
                <th>Email</th>
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Juan Perez</td>
                <td>juanperez@gmail.com</td>
                <td>+56 987654321</td>
                <td>Av. Juan Perez, 123</td>
                <td>
                  <div className="d-flex justify-content-center gap-2">
                    <button className="btn btn-warning">
                      <i className="fa-solid fa-pen-to-square"></i>
                    </button>
                    <button className="btn btn-danger">
                      <i className="fa-solid fa-trash"></i>
                    </button>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Juan Perez</td>
                <td>juanperez@gmail.com</td>
                <td>+56 987654321</td>
                <td>Av. Juan Perez, 123</td>
                <td>
                  <div className="d-flex justify-content-center gap-2">
                    <button className="btn btn-warning">
                      <i className="fa-solid fa-pen-to-square"></i>
                    </button>
                    <button className="btn btn-danger">
                      <i className="fa-solid fa-trash"></i>
                    </button>
                  </div>
                </td>
              </tr>
              <tr>
                <td>Juan Perez</td>
                <td>juanperez@gmail.com</td>
                <td>+56 987654321</td>
                <td>Av. Juan Perez, 123</td>
                <td>
                  <div className="d-flex justify-content-center gap-2">
                    <button className="btn btn-warning">
                      <i className="fa-solid fa-pen-to-square"></i>
                    </button>
                    <button className="btn btn-danger">
                      <i className="fa-solid fa-trash"></i>
                    </button>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};
