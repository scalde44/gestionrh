package co.edu.usbcali.gestionrh.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VacacionDTO implements Serializable {
  private Long id;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private String descripcion;
  private Integer diasHabiles;
  private Boolean estado;
  private Integer idContratoEmpleado;
}
