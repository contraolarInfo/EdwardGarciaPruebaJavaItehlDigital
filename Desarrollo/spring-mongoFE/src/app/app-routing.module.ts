import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleCursoComponent } from './curso/detalle-curso.component';
import { EditarCursoComponent } from './curso/editar-curso.component';
import { ListaCursoComponent } from './curso/lista-curso.component';
import { NuevoCursoComponent } from './curso/nuevo-curso.component';

const routes: Routes = [
  {path: '', component: ListaCursoComponent},
  {path: 'detalle/:id', component: DetalleCursoComponent},
  {path: 'nuevo', component: NuevoCursoComponent},
  {path: 'editar/:id', component: EditarCursoComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
