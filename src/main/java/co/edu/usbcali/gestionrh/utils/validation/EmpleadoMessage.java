package co.edu.usbcali.gestionrh.utils.validation;

public class EmpleadoMessage extends Exception {
  public static final String NO_EXISTE = "El empleado no existe";
  public static final String EXISTE = "El empleado ya existe";
  public static final String INACTIVO = "El empleado se encuentra inactivo";
  public static final String ACTIVO = "El empleado se encuentra activo";
  public static final String NUMERO_IDENTIFICACION_DUPLICADO = "El número de identificacion ya lo tiene registrado otro empleado";
}
