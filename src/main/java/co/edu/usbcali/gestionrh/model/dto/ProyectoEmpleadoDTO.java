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
public class ProyectoEmpleadoDTO implements Serializable {
  private Long id;
  private String rol;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private Boolean estado;
  private Integer idLider;
  private Integer idProyecto;
  private Integer idEmpleado;
}
