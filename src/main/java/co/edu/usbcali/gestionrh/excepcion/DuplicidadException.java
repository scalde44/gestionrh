package co.edu.usbcali.gestionrh.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;

public class DuplicidadException extends ErrorResponseException {
    private static final String TITULO = "%s ya existe";

    public DuplicidadException(String titulo, String mensaje) {
        super(HttpStatus.BAD_REQUEST);
        setTitle(String.format(TITULO, titulo));
        setDetail(mensaje);
    }
}