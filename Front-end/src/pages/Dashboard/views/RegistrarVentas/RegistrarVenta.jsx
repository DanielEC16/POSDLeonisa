import { useState } from "react";
import "./RegistrarVenta.scss";
import { getProductsByCode } from "../../../../services/productoService";

export const RegistrarVenta = () => {
  const [dni, setDni] = useState("");
  const [productos, setProductos] = useState([]);
  const total = productos.reduce((total, p) => total + p.precio * p.cantidad, 0);

  const [codigo, setCodigo] = useState("");

  const agregarProducto = async () => {
    if (!codigo.trim()) return;

    try {
      const prod = await getProductsByCode(codigo);

      setProductos(prev => {
        const existe = prev.find(item => item.id === prod.id);

        if (existe) {
          // Aumentar cantidad
          return prev.map(item =>
            item.id === prod.id
              ? { ...item, cantidad: item.cantidad + 1 }
              : item
          );
        } else {
          // Agregar con cantidad = 1
          return [...prev, { ...prod, cantidad: 1 }];
        }
      });

      setCodigo(""); // limpiar input

    } catch (error) {
      console.log("Producto no encontrado");
    }
  };



  return (
    <>
      <div className="registrar-ventas-panel">
        <div className="tittle">
          <h3>🪪Registrar Nueva Venta</h3>
        </div>
        <div className="venta-container">
          <div className="boleta">
            <div className="detalle-boleta">
              <table>
                <thead>
                  <tr >
                    <th>#</th>
                    <th>Codigo</th>
                    <th>Producto</th>
                    <th>Precio Unit.</th>
                    <th>Cant.</th>
                    <th>Sub-Total</th>
                    <th className="text-center">Accion</th>
                  </tr>
                </thead>
                <tbody>
                  {productos.map((producto, index) =>
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{producto.codigo}</td>
                      <td>{producto.nombre}</td>
                      <td className="text-center">S/{producto.precio}</td>
                      <td className="text-center">{producto.cantidad}</td>
                      <td className="text-center">S/{producto.precio * producto.cantidad}</td>
                      <td className="buttons">
                        <button className="btn btn-primary"><i className="fa-solid fa-plus"></i></button>
                        <button className="btn btn-secondary"><i className="fa-solid fa-minus"></i></button>
                        <button className="btn btn-danger"><i className="fa-solid fa-trash"></i></button>
                      </td>
                    </tr>
                  )}
                </tbody>
              </table>
            </div>
          </div>
          <div className="producto-info">
            <label for="dni">Producto</label>
            <input
              type="text"
              value={codigo}
              onChange={e => setCodigo(e.target.value)}
              onKeyDown={e => {
                if (e.key === "Enter") {
                  agregarProducto();
                }
              }}
              maxLength={10}
              required
              placeholder="Cod.Producto"
            />
          </div>
          <div className="cliente-info">
            <label for="dni">DNI CLIENTE (8 dígitos)</label>
            <input
              id="dni"
              name="dni"
              type="text"
              maxLength={8}
              required
              placeholder="Ej. 12345678"
            />
            <div className="info">
              <label htmlFor="">Nombres:</label>
              <label htmlFor="">Daniel Enrique</label>
              <label htmlFor="">Apellidos:</label>
              <label htmlFor="">Cairo Condoray</label>
              <label htmlFor="">Vendedor:</label>
              <label htmlFor="">Mike Izagami</label>
              <label htmlFor="">Total Valor:</label>
              <label htmlFor="">S/ {(total - total * 0.18).toFixed(2)}</label>
              <label htmlFor="">IGV:</label>
              <label htmlFor="">S/ {(total * 0.18).toFixed(2)}</label>
            </div>
          </div>

          <div className="total">
            <div className="monto-total">
              <p>Total<br /><span>S/ {total.toFixed(2)}</span></p>
            </div>
            <select className="form-select" name="" id="">
              <option value="yape">Yape</option>
              <option value="plin">Plin</option>
              <option value="efectivo">Efectivo</option>
            </select>
            <button className="btn btn-success">💰 Procesar Venta</button>
          </div>

        </div>

      </div>
    </>
  )
};