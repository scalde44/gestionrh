package co.edu.usbcali.gestionrh.utils.validation;

public class EmpresaMessage {
    public static final String NOMBRE_REQUERIDO = "El nombre de la empresa es requerido";
    public static final String ABREVIATURA_REQUERIDO = "La abreviatura de la empresa es requerido";
    public static final String NIT_REQUERIDO = "El nit de la empresa es requerido";
    public static final int CANTIDAD_MAXIMA_NOMBRE = 150;
    public static final String NOMBRE_SUPERA_MAXIMO_CARACTERES = "La longitud del nombre no debe superar los 150 caracteres";
    public static final int CANTIDAD_MAXIMA_ABREVIATURA = 50;
    public static final String ABREVIATURA_SUPERA_MAXIMO_CARACTERES = "La longitud de abreviatura no debe superar los 50 caracteres";
    public static final int CANTIDAD_MAXIMA_NIT = 20;
    public static final String NIT_SUPERA_MAXIMO_CARACTERES = "La longitud del nit no debe superar los 20 caracteres";
    public static final String NO_EXISTE = "La empresa no existe";
    public static final String YA_EXISTE = "La empresa con nit %s ya existe";
}
