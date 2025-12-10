import { useState, useEffect } from 'react';
import './Ventas.scss'
import { useTitle } from '../../../../hooks/useTitle';
import { getVentas } from '../../../../services/ventasService';

export const Ventas = () => {
    const [ventas, setVentas] = useState([]);
    useEffect(() => {
        const fetchVentas = async () => {
            const data = await getVentas();
            setVentas(data);
        };
        fetchVentas();
    }, []);
    useTitle('Dashboard | Ventas');
    return (
        <>
            <div className="ventas-panel">
                <div className="tittle">
                    <h3>💰Gestion de Ventas</h3>
                    <button>
                        <i className="fa-solid fa-plus"></i>
                        Nueva Venta
                    </button>
                </div>
                <div className="cards-ventas">
                    <div className="card">
                        <p>Total de Ventas</p>
                        <span>10</span>
                    </div>
                    <div className="card">
                        <p>Total de Ventas</p>
                        <span>10</span>
                    </div>
                    <div className="card">
                        <p>Total de Ventas</p>
                        <span>10</span>
                    </div>
                </div>
                <div className="filter-container">
                    <input className='search-input' type="text" placeholder="🔍Buscar venta" name='search' />
                    <div className='filters'>
                        <div className="export">
                            <button>
                                Filtros
                            </button>
                            <hr />
                            <button>
                                Exportar
                            </button>
                        </div>
                    </div>
                </div>
                <div className="table-ventas">
                    <table>
                        <thead>
                            <tr className="text-center">
                                <th>#</th>
                                <th>Cliente</th>
                                <th>Fecha</th>
                                <th>Metodo de Pago</th>
                                <th>Total</th>
                                <th>Vendedor</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            {ventas.map((venta, index) => (
                                <tr key={index}>
                                    <td className="text-center">{index + 1}</td>
                                    <td>{venta.cliente_nombre}
                                        <br />
                                        {venta.cliente_dni}</td>
                                    <td>{venta.fecha_venta}</td>
                                    <td className="text-center">{venta.metodo_pago}</td>
                                    <td className="text-center">S/{venta.total.toFixed(2)}</td>
                                    <td>{venta.vendedor}</td>
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
        </>
    );
};