package co.edu.usbcali.gestionrh.service;

import java.util.List;

import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;

public interface EmpleadoService {
    EmpleadoResponse crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception;

    void eliminar(Long id);

    EmpleadoResponse buscar(Long id) throws Exception;

    void actualizar(EmpleadoDTO empleadoDTO);

    List<EmpleadoDTO> obtenerTodos();
  
}
