import React, { forwardRef } from 'react';

export const Voucher = forwardRef(({ venta }, ref) => {
  return (
    <div ref={ref} style={{ padding: '20px', width: '280px', fontFamily: 'monospace' }}>
      <h2 style={{ textAlign: 'center' }}>🍰 Pastelería Dulce Sabor 🍰</h2>
      <p><strong>Boleta N°:</strong> {venta.id}</p>
      <p><strong>Fecha:</strong> {new Date().toLocaleDateString()}</p>
      <p><strong>Cliente:</strong> {venta.cliente}</p>
      <hr />
      {venta.detalles.map((item, i) => (
        <p key={i}>{item.producto} x{item.cantidad} — S/ {item.subtotal}</p>
      ))}
      <hr />
      <p><strong>Total:</strong> S/ {venta.total}</p>
      <p style={{ textAlign: 'center' }}>¡Gracias por su compra!</p>
    </div>
  );
});