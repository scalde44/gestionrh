package co.edu.usbcali.gestionrh.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContratoEmpleadoDTO implements Serializable {

  private Long id;
  private BigDecimal salario;
  private Boolean estado;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private Long idEmpresa;
  private Long idEmpleado;
  private Long idContrato;
  private Long idCargo;

}
