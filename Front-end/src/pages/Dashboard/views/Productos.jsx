import { useEffect, useState } from "react";
import { useTitle } from "../../../hooks/useTitle";
import { getProducts } from "../../../services/productoService";

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
      {products.map((prod) => (
        <div key={prod.id} className="producto">
          <p>{prod.nombre}</p>
          <p>
            {prod.sabores.map((sabor, index) => (
              <span key={index}>
                {sabor.nombre}
                {index < prod.sabores.length - 1 ? ", " : ""}
              </span>
            ))}
          </p>
        </div>
      ))}
    </div>
  );
};
