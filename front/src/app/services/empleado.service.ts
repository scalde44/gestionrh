import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Empleado } from "../models/empleado";
import { environment } from "src/environments/environment";


@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private httpClient:HttpClient) {}

  todos() : Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${environment.api}/empleado/todos`)
  }
  
  inactivar(id: number) : Observable<Empleado> {
    return this.httpClient.put<Empleado>(`${environment.api}/empleado/inactivar/${id}`, {})
  }

  activar(id: number) : Observable<Empleado> {
    return this.httpClient.put<Empleado>(`${environment.api}/empleado/activar/${id}`, {})
  }

  agregar(empleado: Empleado) : Observable<Empleado> {
    return this.httpClient.post<Empleado>(`${environment.api}/empleado/agregar`, empleado)
  }

}