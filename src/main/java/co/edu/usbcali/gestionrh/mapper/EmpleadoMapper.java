package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.Empleado;
import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;

@Component
public class EmpleadoMapper {
  public static EmpleadoDTO toDTO(Empleado empleado) {
    return EmpleadoDTO.builder()
            .id(empleado.getId())
            .nombres(empleado.getNombres())
            .apellidos(empleado.getApellidos())
            .correo(empleado.getCorreo())
            .direccion(empleado.getDireccion())
            .estado(empleado.getEstado())
            .fechaIngreso(empleado.getFechaIngreso())
            .fechaNacimiento(empleado.getFechaNacimiento())
            .genero(empleado.getGenero())
            .tipoIdentificacion(empleado.getTipoIdentificacion())
            .numeroIdentificacion(empleado.getNumeroIdentificacion())
            .telefono(empleado.getTelefono())
            .build();
  }

  public static Empleado toDomain(EmpleadoDTO empleadoDTO) {
    return Empleado.builder()
            .id(empleadoDTO.getId())
            .nombres(empleadoDTO.getNombres())
            .apellidos(empleadoDTO.getApellidos())
            .correo(empleadoDTO.getCorreo())
            .direccion(empleadoDTO.getDireccion())
            .estado(empleadoDTO.getEstado())
            .fechaIngreso(empleadoDTO.getFechaIngreso())
            .fechaNacimiento(empleadoDTO.getFechaNacimiento())
            .genero(empleadoDTO.getGenero())
            .tipoIdentificacion(empleadoDTO.getTipoIdentificacion())
            .numeroIdentificacion(empleadoDTO.getNumeroIdentificacion())
            .telefono(empleadoDTO.getTelefono())
            .build();
  }

  public static List<EmpleadoDTO> toDTOList (List<Empleado> empleados) {
    return empleados.stream().map(EmpleadoMapper::toDTO).toList();
  }

  public static List<Empleado> toDomainList (List<EmpleadoDTO> empleadoDTOs) {
    return empleadoDTOs.stream().map(EmpleadoMapper::toDomain).toList();
  }
}