package co.edu.usbcali.gestionrh.model.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

  @NotNull(message = "La profesión es requerida")
  @JsonProperty("id_profesion")
  private Long idProfesion;

  @NotNull(message = "El nombre es requerido")
  @NotEmpty(message = "El nombre no puede estar vacio")
  @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
  private String nombres;
  
  @NotNull(message = "El apellido es requerido")
  @NotEmpty(message = "El apellido no puede estar vacio")
  @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
  private String apellidos;
  
  @NotNull(message = "El correo es requerido")
  @NotEmpty(message = "El correo no puede estar vacio")
  @Size(max = 150, message = "El correo no puede superar los 150 caracteres")
  @Email(regexp = ".+[@].+[\\.].+", message = "El correo no es valido")
  private String correo;

  @NotNull(message = "La dirección es requerida")
  @NotEmpty(message = "La dirección no puede estar vacia")
  @Size(max = 150, message = "La dirección no puede superar los 150 caracteres")
  private String direccion;
  
  @NotNull(message = "La fecha de ingreso es requerida")
  @JsonProperty("fecha_ingreso")
  private LocalDate fechaIngreso;
  
  @NotNull(message = "La fecha de nacimiento es requerida")
  @JsonProperty("fecha_nacimiento")
  private LocalDate fechaNacimiento;
  
  @NotNull(message = "El género es requerido")
  @Size(max = 1, message = "El género debe se de un caracter")
  private String genero;
  
  @NotNull(message = "El tipo de identificación es requerido")
  @Size(max = 50, message = "El tipo de identificación no puede superar los 50 caracteres")
  @JsonProperty("tipo_identificacion")
  private String tipoIdentificacion;
  
  @NotNull(message = "La identificación es requerida")
  @Size(max = 50, message = "La identificación no puede superar los 50 caracteres")
  @JsonProperty("numero_identificacion")
  private String numeroIdentificacion;

  @NotNull(message = "El teléfono es requerido")
  @Size(max = 15, message = "El teléfono no puede superar los 15 caracteres")
  private String telefono;
}
