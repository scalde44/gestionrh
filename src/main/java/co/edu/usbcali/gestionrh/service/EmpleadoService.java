package co.edu.usbcali.gestionrh.service;

import java.util.List;

import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;

public interface EmpleadoService {
    EmpleadoDTO crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception;

    void eliminar(Long id);

    EmpleadoDTO buscar(Long id);

    void actualizar(EmpleadoDTO empleadoDTO);

    List<EmpleadoDTO> obtenerTodos();
  
}
