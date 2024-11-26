package co.edu.usbcali.gestionrh.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class SinDatosException extends ErrorResponseException {
    private static final String TITULO = "%s no encontrada";
    private static final String DETALLE = "%s con id: %d no existe";

    public SinDatosException(String titulo, Long id) {
        super(HttpStatus.NOT_FOUND);
        setTitle(String.format(TITULO, titulo));
        setDetail(String.format(DETALLE, titulo, id));
    }
}
