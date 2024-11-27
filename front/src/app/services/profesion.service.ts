import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Profesion } from "./profesion";


@Injectable({
  providedIn: 'root'
})
export class ProfesionService {

  constructor(private httpClient:HttpClient) {}

  todas() : Observable<Profesion[]> {
    return this.httpClient.get<Profesion[]>(`${environment.api}/profesiones`)
  }
}