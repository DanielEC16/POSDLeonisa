import { useEffect, useState } from "react";

export const ClienteModal = ({ show, onClose, onSave, initialData }) => {
    const [cliente, setCliente] = useState({
        nombre: "",
        apellido: "",
        dni: "",
    })

    useEffect(() => {
        if (initialData) setCliente(initialData)
        else setCliente({
            nombre: "",
            apellido: "",
            dni: "",
        })
    }, [initialData, show])

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCliente({ ...cliente, [name]: value });
    };

    const handleSubmit = () => {
        onSave(cliente);
        onClose();
    };

    if (!show) return null;

    return (
        <div className="modal fade show d-block dark-mode" data-bs-theme="dark" tabIndex="-1" style={{ backgroundColor: "rgba(0,0,0,0.5)" }}>
            <div className="modal-dialog modal-dialog-centered ">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title">
                            {initialData ? "Editar Cliente" : "Nuevo Cliente"}
                        </h5>
                        <button type="button" className="btn-close" onClick={onClose}></button>
                    </div>

                    <div className="modal-body">
                        <div className="mb-3">
                            <label className="form-label">Nombre</label>
                            <input
                                type="text"
                                name="nombre"
                                className="form-control"
                                value={cliente.nombre}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Apellido</label>
                            <input
                                type="text"
                                name="apellido"
                                className="form-control"
                                value={cliente.apellido}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="mb-3">
                            <label className="form-label">DNI</label>
                            <input
                                type="text"
                                name="dni"
                                className="form-control"
                                value={cliente.dni}
                                onChange={handleChange}
                            />
                        </div>
                    </div>

                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" onClick={onClose}>
                            Cancelar
                        </button>
                        <button type="button" className="btn btn-primary" onClick={handleSubmit}>
                            Guardar
                        </button>
                    </div>
                </div>
            </div>
        </div>
    )
}