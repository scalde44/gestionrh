package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.ContratoEmpleado;
import co.edu.usbcali.gestionrh.model.dto.ContratoEmpleadoDTO;

@Component
public class ContratoEmpleadoMapper {
  public static ContratoEmpleadoDTO toDTO (ContratoEmpleado contratoEmpleado) {
    return ContratoEmpleadoDTO.builder()
      .id(contratoEmpleado.getId())
      .salario(contratoEmpleado.getSalario())
      .estado(contratoEmpleado.getEstado())
      .fechaInicio(contratoEmpleado.getFechaInicio())
      .fechaFin(contratoEmpleado.getFechaFin())
      .idEmpresa(
        contratoEmpleado.getEmpresa() == null ? null : contratoEmpleado.getEmpresa().getId()
      )
      .idEmpleado(
        contratoEmpleado.getEmpleado() == null ? null : contratoEmpleado.getEmpleado().getId()
      )
      .idContrato(
        contratoEmpleado.getContrato() == null ? null : contratoEmpleado.getContrato().getId()
      )
      .idCargo(
        contratoEmpleado.getCargo() == null ? null : contratoEmpleado.getCargo().getId()
      )
      .build();
  }

  public static ContratoEmpleado toDomain (ContratoEmpleadoDTO contratoEmpleadoDTO) {
    return ContratoEmpleado.builder()
      .id(contratoEmpleadoDTO.getId())
      .salario(contratoEmpleadoDTO.getSalario())
      .estado(contratoEmpleadoDTO.getEstado())
      .fechaInicio(contratoEmpleadoDTO.getFechaInicio())
      .fechaFin(contratoEmpleadoDTO.getFechaFin())
      /*.idEmpresa(
        contratoEmpleadoDTO.getEmpresa() == null ? null : contratoEmpleadoDTO.getEmpresa().getId()
      )
      .idEmpleado(
        contratoEmpleadoDTO.getEmpleado() == null ? null : contratoEmpleadoDTO.getEmpleado().getId()
      )
      .idContrato(
        contratoEmpleadoDTO.getContrato() == null ? null : contratoEmpleadoDTO.getContrato().getId()
      )
      .idCargo(
        contratoEmpleadoDTO.getCargo() == null ? null : contratoEmpleadoDTO.getCargo().getId()
      )*/
      .build();
  }

  public static List<ContratoEmpleadoDTO> toDTOList (List<ContratoEmpleado> contratoEmpleados) {
    return contratoEmpleados.stream().map(ContratoEmpleadoMapper::toDTO).toList(); 
  }

  public static List<ContratoEmpleado> toDomainList (List<ContratoEmpleadoDTO> contratoEmpleadoDTOs) {
    return contratoEmpleadoDTOs.stream().map(ContratoEmpleadoMapper::toDomain).toList(); 
  }
}
