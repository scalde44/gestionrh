package co.edu.usbcali.gestionrh.service.impl;

import co.edu.usbcali.gestionrh.excepcion.ActivoExcepcion;
import co.edu.usbcali.gestionrh.excepcion.DuplicidadException;
import co.edu.usbcali.gestionrh.excepcion.InactivoExcepcion;
import co.edu.usbcali.gestionrh.excepcion.SinDatosException;
import co.edu.usbcali.gestionrh.mapper.EmpleadoMapper;
import co.edu.usbcali.gestionrh.model.domain.Empleado;
import co.edu.usbcali.gestionrh.model.domain.Profesion;
import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.request.UpdateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;
import co.edu.usbcali.gestionrh.repository.EmpleadoRepository;
import co.edu.usbcali.gestionrh.repository.ProfesionRepository;
import co.edu.usbcali.gestionrh.service.EmpleadoService;
import co.edu.usbcali.gestionrh.utils.validation.EmpleadoMessage;
import co.edu.usbcali.gestionrh.utils.validation.EmpresaMessage;
import co.edu.usbcali.gestionrh.utils.validation.ProfesionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
  private final EmpleadoRepository repository;
  private final ProfesionRepository profesionRepository;

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public EmpleadoResponse crear(CreateEmpleadoRequest createEmpleadoRequest) throws Exception {

    boolean exists = this.repository.existsByNumeroIdentificacionAndEstado(
      createEmpleadoRequest.getNumeroIdentificacion(),
      true
    );
    validarExistenciaEmpleado(exists);

    Empleado empleado = EmpleadoMapper.createEmpleadoRequestToDomain(createEmpleadoRequest);
    Profesion profesion = this.profesionRepository.findById(createEmpleadoRequest.getIdProfesion())
      .orElseThrow(() -> new Exception(ProfesionMessage.NO_EXISTE));

    empleado.setProfesion(profesion);

    return EmpleadoMapper.domainToResponse(this.repository.save(empleado));
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public EmpleadoDTO inactivar(Long id) throws Exception {
    Empleado empleado = findById(id);

    validarEstadoEmpleado(empleado);

    empleado.setEstado(false);
    this.repository.save(empleado);

    return EmpleadoMapper.toDTO(empleado);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public EmpleadoDTO activar(Long id) throws Exception {
    Empleado empleado = findById(id);

    if(empleado.getEstado()) {
      throw new ActivoExcepcion(
              EmpleadoMessage.NOMBRE,
              EmpleadoMessage.ACTIVO);
    }

    empleado.setEstado(true);
    this.repository.save(empleado);

    return EmpleadoMapper.toDTO(empleado);
  }

  @Override
  @Transactional(readOnly = true)
  public EmpleadoResponse buscar(Long id) throws Exception {
    Empleado empleado = findById(id);

    return EmpleadoMapper.domainToResponse(empleado);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public EmpleadoDTO actualizar(Long id, UpdateEmpleadoRequest updateEmpleadoRequest) throws Exception {
    Empleado empleado = findById(id);

    validarEstadoEmpleado(empleado);

    if (empleado.getNumeroIdentificacion() != updateEmpleadoRequest.getNumeroIdentificacion()) {
      boolean exists = this.repository.existsByIdNotAndNumeroIdentificacion(
        empleado.getId(),
        updateEmpleadoRequest.getNumeroIdentificacion()
      );

      validarExistenciaEmpleado(exists);
    }

    if(empleado.getProfesion().getId() != updateEmpleadoRequest.getIdProfesion()) {
      Profesion profesion = profesionRepository.findById(updateEmpleadoRequest.getIdProfesion())
        .orElseThrow( () -> new SinDatosException(ProfesionMessage.NOMBRE,updateEmpleadoRequest.getIdProfesion()));

      empleado.setProfesion(profesion);
    }

    empleado = EmpleadoMapper.updateEmpleadoRequestToDomain(empleado, updateEmpleadoRequest);
    empleado = this.repository.save(empleado);

    return EmpleadoMapper.toDTO(empleado);
  }

  @Override
  @Transactional(readOnly = true)
  public List<EmpleadoResponse> obtenerTodos() {
    List<Empleado> empleados = this.repository.findAll();

    return EmpleadoMapper.toResponseList(empleados);
  }

    private Empleado findById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(() -> new SinDatosException(EmpleadoMessage.NOMBRE,
                id));
    }

  private void validarEstadoEmpleado(Empleado empleado) {
    if(!empleado.getEstado()) {
      throw new InactivoExcepcion(
              EmpleadoMessage.NOMBRE,
              EmpleadoMessage.INACTIVO);
    }
  }

  private void validarExistenciaEmpleado(boolean exists) {
    if(exists) {
      throw new DuplicidadException(
              EmpleadoMessage.NOMBRE,
              EmpleadoMessage.NUMERO_IDENTIFICACION_DUPLICADO);
    }
  }
}
