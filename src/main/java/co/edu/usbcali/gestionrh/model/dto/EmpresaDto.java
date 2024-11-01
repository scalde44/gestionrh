package co.edu.usbcali.gestionrh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpresaDto implements Serializable {
    private Long id;
    private String nombre;
    private String abreviatura;
    private String nit;
    private Boolean estado;
}
