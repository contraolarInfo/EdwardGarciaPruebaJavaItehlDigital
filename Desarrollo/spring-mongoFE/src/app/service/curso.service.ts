import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../models/curso';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  cursoURL = 'http://localhost:8082/cursos/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(this.cursoURL);
  }

  public detailModalidad(modalidad: string): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(this.cursoURL + `modalidad/${modalidad}`);
  } 

  public save(curso: Curso): Observable<any> {
    return this.httpClient.post<any>(this.cursoURL, curso);
  }

  public delete(nombre: string): Observable<any> {
    return this.httpClient.delete<any>(this.cursoURL + `borrar/${nombre}`);
  }


}
