package co.edu.usbcali.gestionrh.service;

import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;

import java.util.List;

public interface EmpresaService {
    void crear(EmpresaDto empresaDto);

    void eliminar(Long id);

    EmpresaDto buscar(Long id);

    void actualizar(EmpresaDto empresaDto);

    List<EmpresaDto> obtenerTodos();
}
