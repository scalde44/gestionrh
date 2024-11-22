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
  fechaIngreso: Date;
  fechaNacimiento?: Date;
  genero: string;
  tipoIdentificacion: string;
  numeroIdentificacion: string;
  telefono: string;
}