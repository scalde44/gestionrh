package co.edu.usbcali.gestionrh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.usbcali.gestionrh.mapper.EmpleadoMapper;
import co.edu.usbcali.gestionrh.model.domain.Empleado;
import co.edu.usbcali.gestionrh.model.domain.Profesion;
import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;
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
  public EmpleadoResponse crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception {

    Boolean exists = this.repository.existsByNumeroIdentificacionAndEstado(
      createEmpleadoRequest.getNumeroIdentificacion(),
      true
    );
    if(exists) {
      throw new Exception("El empleado ya existe");
    }

    Empleado empleado = EmpleadoMapper.createEmpleadoRequestToDomain(createEmpleadoRequest);
    Optional<Profesion> profesion = this.profesionRepository.findById(createEmpleadoRequest.getIdProfesion());
          
    if (profesion.isEmpty()) {
      throw new Exception("La profesión no existe");
    }

    empleado.setProfesion(profesion.get());

    return EmpleadoMapper.domainToResponse(this.repository.save(empleado));
  }

  @Override
  public void eliminar(Long id) {
    Empleado empleado = this.repository.findById(id).orElseThrow();

    empleado.inactivar();
    this.repository.save(empleado);
  }

  @Override
  public EmpleadoResponse buscar(Long id) throws Exception {
    Optional<Empleado> empOptional = this.repository.findById(id);

    if(empOptional.isEmpty()) {
      throw new Exception("El empleado no existe");
    }

    return  EmpleadoMapper.domainToResponse(empOptional.get());
  }

  @Override
  public void actualizar(EmpleadoDTO empleadoDTO) {

  }

  @Override
  public List<EmpleadoDTO> obtenerTodos() {
    throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
  }
}
