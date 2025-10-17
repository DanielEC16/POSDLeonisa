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
        <h3>🎂Gestion de Productos</h3>
        <button>
          <i className="fa-solid fa-plus"></i>
          Nuevo Producto
        </button>
      </div>
      <div className="cards-clients">
        <div className="card">
          <p>Total de Productos</p>
          <span>{products.length}</span>
        </div>
        <div className="card">
          <p>Total de Productos</p>
          <span>10</span>
        </div>
        <div className="card">
          <p>Total de Productos</p>
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
      <div className="table-productos">
        <table>
          <thead>
            <tr className="text-center">
              <th>#</th>
              <th>Codigo</th>
              <th className="text-start">Nombre Producto</th>
              <th>Precio</th>
              <th>stock</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product, index) => (
              <tr style={{ verticalAlign: 'middle' }} key={index}>
                <th className="text-center">{index + 1}</th>
                <td className="text-center">{product.codigoProducto}</td>
                <td>{product.nombre}</td>
                <td className="text-center">S/ {product.precio.toFixed(2)}</td>
                <td className="text-center">{product.stock}</td>
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
