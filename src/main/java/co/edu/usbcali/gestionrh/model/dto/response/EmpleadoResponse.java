package co.edu.usbcali.gestionrh.model.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.usbcali.gestionrh.model.dto.ProfesionDTO;
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
public class EmpleadoResponse {
  private Long id;
  private ProfesionDTO profesion;
  private Boolean estado;
  private String nombres;
  private String apellidos;
  private String correo;
  private String direccion;
  private String genero;
  private String telefono;

  @JsonProperty("fecha_ingreso")
  private LocalDate fechaIngreso;

  @JsonProperty("fecha_nacimiento")
  private LocalDate fechaNacimiento;
  
  @JsonProperty("tipo_identificacion")
  private String tipoIdentificacion;

  @JsonProperty("numero_identificaicon")
  private String numeroIdentificacion;
}
