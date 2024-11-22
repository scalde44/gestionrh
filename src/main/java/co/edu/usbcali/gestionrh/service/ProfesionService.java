package co.edu.usbcali.gestionrh.service;

import co.edu.usbcali.gestionrh.model.dto.ProfesionDTO;

import java.util.List;

public interface ProfesionService {
    void crear(ProfesionDTO profesionDTO) throws Exception;

    void eliminar(Long id) throws Exception;

    ProfesionDTO buscar(Long id) throws Exception;

    void actualizar(ProfesionDTO profesionDTO) throws Exception;

    List<ProfesionDTO> obtenerTodos();
}
