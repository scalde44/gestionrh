package co.edu.usbcali.gestionrh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.usbcali.gestionrh.mapper.EmpleadoMapper;
import co.edu.usbcali.gestionrh.model.domain.Empleado;
import co.edu.usbcali.gestionrh.model.domain.Profesion;
import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.repository.EmpleadoRepository;
import co.edu.usbcali.gestionrh.repository.ProfesionRepository;
import co.edu.usbcali.gestionrh.service.EmpleadoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
  private final EmpleadoRepository repository;
  private final ProfesionRepository profesionRepository;

  @Transactional
  @Override
  public EmpleadoDTO crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception {
    if (createEmpleadoRequest == null) {
      throw new Exception("El objeto Empleado ha llegado null");
    }

    if (createEmpleadoRequest.getTelefono().length() > 15) {
      throw new Exception("El telefono no puede exceder los 15 caracteres");
    }

    if (createEmpleadoRequest.getNombres().length() > 50) {
      throw new Exception("El nombre no puede exceder los 50 caracteres");
    }

    if (createEmpleadoRequest.getApellidos().length() > 50) {
      throw new Exception("El apellido no puede exceder los 50 caracteres");
    }

    if (createEmpleadoRequest.getCorreo().length() > 150) {
      throw new Exception("El correo no puede exceder los 150 caracteres");
    }

    if (createEmpleadoRequest.getDireccion().length() > 150) {
      throw new Exception("La dirección no puede exceder los 150 caracteres");
    }

    Empleado empleado = EmpleadoMapper.createEmpleadoRequestToDomain(createEmpleadoRequest);
    Optional<Profesion> profesion = this.profesionRepository.findById(createEmpleadoRequest.getIdProfesion());
          
    if (profesion.isEmpty()) {
      throw new Exception("Profesión no definida");
    }

    empleado.setProfesion(profesion.get());

    return EmpleadoMapper.toDTO(this.repository.save(empleado));
  }

  @Override
  public void eliminar(Long id) {
    Empleado empleado = this.repository.findById(id).orElseThrow();

    empleado.inactivar();
    this.repository.save(empleado);
  }

  @Override
  public EmpleadoDTO buscar(Long id) {
    return this.repository.findById(id).map(EmpleadoMapper::toDTO).orElseThrow();
  }

  @Override
  public void actualizar(EmpleadoDTO empleadoDTO) {

  }

  @Override
  public List<EmpleadoDTO> obtenerTodos() {
    throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
  }

}
