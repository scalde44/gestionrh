package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.ProyectoEmpleado;
import co.edu.usbcali.gestionrh.model.dto.ProyectoEmpleadoDTO;
import co.edu.usbcali.gestionrh.repository.EmpleadoRepository;

@Component
public class ProyectoEmpleadoMapper {
  public static ProyectoEmpleadoDTO toDTO (ProyectoEmpleado proyectoEmpleado) {
    return ProyectoEmpleadoDTO.builder()
      .id(proyectoEmpleado.getId())
      .rol(proyectoEmpleado.getRol())
      .fechaInicio(proyectoEmpleado.getFechaInicio())
      .fechaFin(proyectoEmpleado.getFechaFin())
      .estado(proyectoEmpleado.getEstado())
      .idLider(
        proyectoEmpleado.getLider() == null ? null : proyectoEmpleado.getLider().getId()
      )
      .idProyecto(
        proyectoEmpleado.getProyecto() == null ? null : proyectoEmpleado.getProyecto().getId()
      )
      .idEmpleado(
        proyectoEmpleado.getEmpleado() == null ? null : proyectoEmpleado.getEmpleado().getId()
      )
      .build();
  }

  
  public static ProyectoEmpleado toDomain (ProyectoEmpleadoDTO proyectoEmpleadoDTO) {
    return ProyectoEmpleado.builder()
      .id(proyectoEmpleadoDTO.getId())
      .rol(proyectoEmpleadoDTO.getRol())
      .fechaInicio(proyectoEmpleadoDTO.getFechaInicio())
      .fechaFin(proyectoEmpleadoDTO.getFechaFin())
      .estado(proyectoEmpleadoDTO.getEstado())
      /*.lider(
        proyectoEmpleadoDTO.getIdLider() == null ? null : EmpleadoRepository::findById(proyectoEmpleadoDTO.getId())
      )
      .proyecto(
        proyectoEmpleado.getProyecto() == null ? null : proyectoEmpleado.getProyecto().getId()
      )
      .empleado(
        proyectoEmpleado.getEmpleado() == null ? null : proyectoEmpleado.getEmpleado().getId()
      )*/
      .build();
  }

  public static List<ProyectoEmpleadoDTO> toDTOList(List<ProyectoEmpleado> proyectoEmpleados) {
    return proyectoEmpleados.stream().map(ProyectoEmpleadoMapper::toDTO).toList();
  }

  public static List<ProyectoEmpleado> toDomainList(List<ProyectoEmpleadoDTO> proyectoEmpleadoDTOs) {
    return proyectoEmpleadoDTOs.stream().map(ProyectoEmpleadoMapper::toDomain).toList();
  }
}
