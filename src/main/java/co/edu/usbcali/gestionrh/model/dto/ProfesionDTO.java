package co.edu.usbcali.gestionrh.model.dto;

import co.edu.usbcali.gestionrh.utils.validation.ProfesionMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProfesionDTO implements Serializable {
    private Long id;
    @NotEmpty(message = ProfesionMessage.NOMBRE_REQUERIDO)
    @Size(max = ProfesionMessage.CANTIDAD_MAXIMA_NOMBRE, message = ProfesionMessage.NOMBRE_SUPERA_MAXIMO_CARACTERES)
    private String nombre;
}
