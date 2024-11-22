package co.edu.usbcali.gestionrh.service;

import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;

import java.util.List;

public interface EmpresaService {
    void crear(EmpresaDto empresaDto) throws Exception;

    void eliminar(Long id) throws Exception;

    EmpresaDto buscar(Long id) throws Exception;

    void actualizar(EmpresaDto empresaDto) throws Exception;

    List<EmpresaDto> obtenerTodos();
}
