package co.edu.usbcali.gestionrh.model.dto.request;

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
public class CreateEmpleadoRequest {
  private Long idProfesion;
  private String nombres;
  private String apellidos;
  private String correo;
  private String direccion;
  private LocalDate fechaIngreso;
  private LocalDate fechaNacimiento;
  private String genero;
  private String tipoIdentificacion;
  private String numeroIdentificacion;
  private String telefono;
}
