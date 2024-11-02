package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.Profesion;
import co.edu.usbcali.gestionrh.model.dto.ProfesionDTO;

@Component
public class ProfesionMapper {
  public static ProfesionDTO toDTO (Profesion profesion) {
    return ProfesionDTO.builder()
      .id(profesion.getId())
      .nombre(profesion.getNombre())
      .build();
  }

  public static Profesion toDomain (ProfesionDTO profesiondDto) {
    return Profesion.builder()
      .id(profesiondDto.getId())
      .nombre(profesiondDto.getNombre())
      .build();
  }

  public static List<ProfesionDTO> toDTOList (List<Profesion> profesions) {
    return profesions.stream().map(ProfesionMapper::toDTO).toList();
  }

  public static List<Profesion> toDomainList (List<ProfesionDTO> profesionDTOs) {
    return profesionDTOs.stream().map(ProfesionMapper::toDomain).toList();
  }

}
