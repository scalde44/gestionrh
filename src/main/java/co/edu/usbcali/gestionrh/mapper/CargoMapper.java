package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.Cargo;
import co.edu.usbcali.gestionrh.model.dto.CargoDTO;

@Component
public class CargoMapper {
  public static CargoDTO toCargoDTO (Cargo cargo) {
    return CargoDTO.builder()
            .id(cargo.getId())
            .nombre(cargo.getNombre())
            .build();
  }

  public static Cargo toCargo(CargoDTO cargoDTO) {
    return Cargo.builder()
            .id(cargoDTO.getId())
            .nombre(cargoDTO.getNombre())
            .build();
  }

  public static List<CargoDTO> toDTOList(List<Cargo> cargos) {
    return cargos.stream().map(CargoMapper::toCargoDTO).toList();
  }

  public static List<Cargo> toCargoList(List<CargoDTO> cargoDTOs) {
    return cargoDTOs.stream().map(CargoMapper::toCargo).toList();
  }
}
