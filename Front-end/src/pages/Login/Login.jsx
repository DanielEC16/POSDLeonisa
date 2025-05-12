import html2pdf from "html2pdf.js";
import { useTitle } from "../../hooks/useTitle";
import "./Login.scss";
import { useRef } from "react";

export const Login = () => {
  const voucherRef = useRef();

  const venta = {
    id: 456,
    cliente: "María López",
    total: 35.5,
    detalles: [
      { producto: "Empanada de Pollo", cantidad: 2, subtotal: 7.0 },
      { producto: "Torta de Fresa", cantidad: 1, subtotal: 25.0 },
      { producto: "Porción de Coco", cantidad: 1, subtotal: 3.5 },
      { producto: "Porción de Coco", cantidad: 1, subtotal: 3.5 },
      { producto: "Porción de Coco", cantidad: 1, subtotal: 3.5 },
      { producto: "Porción de Coco", cantidad: 1, subtotal: 3.5 }
    ],
  };

  const handleClick = () => {
    const element = voucherRef.current;

    setTimeout(() => {
      const heightPx = element.scrollHeight;
      const heightMm = heightPx * 0.264583; // Conversión a milímetros

      console.log("Alto en px:", heightPx);
      console.log("Alto en mm:", heightMm);

      html2pdf()
        .set({
          margin: 0,
          filename: "voucher.pdf",
          image: { type: "jpeg", quality: 0.98 },
          html2canvas: { scale: 2 },
          jsPDF: {
            unit: "mm",
            format: [80, heightMm + 15],
            orientation: "portrait",
          },
        })
        .from(element)
        .toPdf()
        .get("pdf")
        .then((pdf) => {
          const blob = pdf.output("blob");
          const url = URL.createObjectURL(blob);
          window.open(url, "_blank");
        });
    }, 100);
  };

  useTitle("Login");
  return (
    <>
      <button onClick={handleClick} style={{ padding: "10px 20px" }}>
        Mirar Voucher
      </button>
      <div style={{ position: "absolute", top: "-9999px", left: "-9999px" }}>
        <div
          ref={voucherRef}
          style={{
            padding: "10px",
            fontFamily: "Arial",
            width: "200px",
            border: "1px solid #ccc",
            fontSize: "12px",
          }}
        >
          <h3 style={{ textAlign: "center" }}>🍰 Pastelería Delicia</h3>
          <p>Boleta N°: {venta.id}</p>
          <p>Cliente: {venta.cliente}</p>
          <hr />
          <ul style={{ listStyle: "none", padding: 0 }}>
            {venta.detalles.map((item, i) => (
              <li key={i}>
                {item.producto} x{item.cantidad} - S/
                {item.subtotal.toFixed(2)}
              </li>
            ))}
          </ul>
          <hr />
          <p style={{ textAlign: "right" }}>
            <strong>Total: S/{venta.total.toFixed(2)}</strong>
          </p>
        </div>
      </div>

      <div className="container-login">
        <div className="parent">
          <div className="img-container">Imagen</div>
          <div className="form-container">Form</div>
        </div>
      </div>
    </>
  );
};
