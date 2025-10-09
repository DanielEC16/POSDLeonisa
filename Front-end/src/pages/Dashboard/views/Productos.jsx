import { useEffect, useState } from "react";
import { useTitle } from "../../../hooks/useTitle";
import { getProducts } from "../../../services/productoService";
import "./Productos.scss";
export const Productos = () => {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    const fetchProducts = async () => {
      const data = await getProducts();
      setProducts(data);
    };
    fetchProducts();
  }, []);
  useTitle("Dashboard | Productos");
  return (
    <div className="productos-panel">
      <div className="tittle">
        <h1>👥 Gestion de Clientes</h1>
        <button>
        Nuevo Cliente
      </button>
      </div>
      
      <div className="table-container">
        <table className="table table-hover">
        <thead>
          <tr className="text-center">
            <th>#</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>stock</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => (
            <tr style={{verticalAlign: 'middle'}} key={index}>
              <th className="text-center">{index + 1}</th>
              <td className="product-name" style={{ whiteSpace: "nowrap" }}>{product.nombre}</td>
              <td className="text-center">${product.precio}</td>
              <td className="text-center">60</td>
              <td className="text-center">
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
          ))}
        </tbody>
      </table>
      </div>
    </div>
  );
};
