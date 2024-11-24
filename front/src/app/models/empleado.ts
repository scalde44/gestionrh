import { Profesion } from "./profesion";

export interface Empleado {
  id: number;
  idProfesion?: number;
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
  numero_identificaicon: string;
  telefono: string;
}
