package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.Contrato;
import co.edu.usbcali.gestionrh.model.dto.ContratoDTO;

@Component
public class ContratoMapper {
  public static ContratoDTO toDTO(Contrato contrato) {
    return ContratoDTO.builder()
        .id(contrato.getId())
        .tipoContrato(contrato.getTipoContrato())
        .build();
  }

  public static Contrato toDomain(ContratoDTO contratoDTO) {
    return Contrato.builder()
        .id(contratoDTO.getId())
        .tipoContrato(contratoDTO.getTipoContrato())
        .build();
  }

  public static List<ContratoDTO> toDTOList(List<Contrato> contratos) {
    return contratos.stream().map(ContratoMapper::toDTO).toList();
  }
  
  public static List<Contrato> toDomainList(List<ContratoDTO> contratoDTOs) {
    return contratoDTOs.stream().map(ContratoMapper::toDomain).toList();
  }
}
