package co.edu.usbcali.gestionrh.model.dto;

import co.edu.usbcali.gestionrh.utils.validation.EmpresaMessage;
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
public class EmpresaDto implements Serializable {
    private Long id;
    @NotEmpty(message = EmpresaMessage.NOMBRE_REQUERIDO)
    @Size(max = EmpresaMessage.CANTIDAD_MAXIMA_NOMBRE, message = EmpresaMessage.NOMBRE_SUPERA_MAXIMO_CARACTERES)
    private String nombre;
    @NotEmpty(message = EmpresaMessage.NIT_REQUERIDO)
    @Size(max = EmpresaMessage.CANTIDAD_MAXIMA_NIT, message = EmpresaMessage.NIT_SUPERA_MAXIMO_CARACTERES)
    private String nit;
    @NotEmpty(message = EmpresaMessage.ABREVIATURA_REQUERIDO)
    @Size(max = EmpresaMessage.CANTIDAD_MAXIMA_ABREVIATURA, message = EmpresaMessage.ABREVIATURA_SUPERA_MAXIMO_CARACTERES)
    private String abreviatura;
    private Boolean estado;
}
