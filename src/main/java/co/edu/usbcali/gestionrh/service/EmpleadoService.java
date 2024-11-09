package co.edu.usbcali.gestionrh.service;

import java.util.List;

import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.request.UpdateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;

public interface EmpleadoService {
    EmpleadoResponse crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception;

    EmpleadoDTO inactivar(Long id) throws Exception;

    EmpleadoDTO activar(Long id) throws Exception;

    EmpleadoResponse buscar(Long id) throws Exception;

    EmpleadoDTO actualizar(Long id, UpdateEmpleadoRequest updateEmpleadoRequest) throws Exception;

    List<EmpleadoResponse> obtenerTodos();
  
}
