import { useState, useEffect } from "react";
import { useTitle } from "../../../hooks/useTitle";
import { getClientes } from "../../../services/clientesService";
import { ClienteModal } from "../../../components/Modals/ClienteModal";
import "./Clientes.scss";

export const Clientes = () => {
  const [clientes, setClientes] = useState([]);
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedCliente, setSelectedCliente] = useState(null);

  // Haciendo uso de useEffect para obtener los clientes del servidor
  useEffect(() => {
    const fetchClientes = async () => {
      const data = await getClientes();
      setClientes(data);
    };
    fetchClientes();
  }, []);

  useTitle("Dashboard | Clientes");

  const handleNuevoCliente = () => {
    setSelectedCliente(null);
    setModalOpen(true);
  };

  const handleEditarCliente = (cliente) => {
    setSelectedCliente(cliente);
    setModalOpen(true);
  };

  const handleGuardarCliente = (cliente) => {
    if (selectedCliente) {
      // Lógica para actualizar cliente (PUT)
      console.log("Editar cliente:", cliente);
    } else {
      // Lógica para crear cliente (POST)
      console.log("Nuevo cliente:", cliente);
    }
  };


  return (
    <>
      <div className="clientes-panel">
        <div className="tittle">
          <h3>👤Gestion de Clientes</h3>
          <button onClick={handleNuevoCliente}>
            <i className="fa-solid fa-plus"></i>
            Nuevo Cliente
          </button>
        </div>
        <div className="cards-clients">
          <div className="card">
            <p>Total de Clientes</p>
            <span>{clientes.length}</span>
          </div>
          <div className="card">
            <p>Total de Clientes</p>
            <span>10</span>
          </div>
          <div className="card">
            <p>Total de Clientes</p>
            <span>10</span>
          </div>
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
                <th>#</th>
                <th className="text-start">Nombre Completo</th>
                <th>DNI</th>
                <th>Fecha Cracion</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {clientes.map((cliente, index) => (
                <tr key={index}>
                  <td className="text-center">{index + 1}</td>
                  <td>{cliente.nombre + ' ' + cliente.apellido}</td>
                  <td className="text-center">{cliente.dni}</td>
                  <td className="text-center">{cliente.fechaCreacion}</td>
                  <td>
                    <div className="d-flex justify-content-center gap-2">
                      <button
                        className="btn btn-warning"
                        onClick={() => handleEditarCliente(cliente)}
                      >
                        <i className="fa-solid fa-pen-to-square"></i>
                      </button>
                      <button className="btn btn-danger">
                        <i className="fa-solid fa-trash"></i>
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <ClienteModal
        show={modalOpen}
        onClose={() => setModalOpen(false)}
        onSave={handleGuardarCliente}
        initialData={selectedCliente}
      />
      </div>
    </>
  );
};
