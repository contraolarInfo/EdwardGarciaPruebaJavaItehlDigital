import { Component, OnInit } from '@angular/core';
import { Curso } from '../models/curso';
import { CursoService } from '../service/curso.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-lista-curso',
  templateUrl: './lista-curso.component.html',
  styleUrls: ['./lista-curso.component.css']
})
export class ListaCursoComponent implements OnInit {

  cursos: Curso[] = [];
  
  constructor(
    private cursoService: CursoService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.cargarCursos();
  }

  cargarCursos(): void {
    this.cursoService.lista().subscribe(
      data => {
        this.cursos = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(nombre: string) {
    this.cursoService.delete(nombre).subscribe(
      data => {
        this.toastr.success('Curso Eliminado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.cargarCursos();
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
      }
    );
  }

}
