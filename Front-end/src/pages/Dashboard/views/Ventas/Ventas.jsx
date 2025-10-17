import './Ventas.scss'
export const Ventas = () => {
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

            </div>
        </>
    );
};