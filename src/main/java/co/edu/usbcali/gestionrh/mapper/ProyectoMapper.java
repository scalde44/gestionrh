package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.Proyecto;
import co.edu.usbcali.gestionrh.model.dto.ProyectoDTO;

@Component
public class ProyectoMapper {
  public static ProyectoDTO toDTO (Proyecto proyecto) {
    return ProyectoDTO.builder()
      .id(proyecto.getId())
      .estado(proyecto.getEstado())
      .fechaInicio(proyecto.getFechaInicio())
      .fechaFin(proyecto.getFechaFin())
      .nombre(proyecto.getNombre())
      .build();
  }

  public static Proyecto toDomain (ProyectoDTO proyectoDTO) {
    return Proyecto.builder()
    .id(proyectoDTO.getId())
    .estado(proyectoDTO.getEstado())
    .fechaInicio(proyectoDTO.getFechaInicio())
    .fechaFin(proyectoDTO.getFechaFin())
    .nombre(proyectoDTO.getNombre())
    .build();
  }

  public static List<ProyectoDTO> toDTOList(List<Proyecto> proyectos) {
    return proyectos.stream().map(ProyectoMapper::toDTO).toList();
  }
  
  public static List<Proyecto> toDomainList(List<ProyectoDTO> proyectoDTOs) {
    return proyectoDTOs.stream().map(ProyectoMapper::toDomain).toList();
  }
}
