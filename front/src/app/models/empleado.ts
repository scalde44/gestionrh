import { Profesion } from "./profesion";

export interface Empleado {
  id?: number;
  id_profesion?: number;
  profesion?: Profesion;
  nombres: string;
  apellidos: string;
  correo: string;
  direccion: string;
  estado: boolean;
  fecha_ingreso: string;
  fecha_nacimiento?: string;
  genero: string;
  tipo_identificacion: string;
  numero_identificacion: string;
  telefono: string;
}
