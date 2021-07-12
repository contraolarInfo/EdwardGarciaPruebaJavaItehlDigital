import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaCursoComponent } from './curso/lista-curso.component';
import { DetalleCursoComponent } from './curso/detalle-curso.component';
import { NuevoCursoComponent } from './curso/nuevo-curso.component';
import { EditarCursoComponent } from './curso/editar-curso.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

// external
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    ListaCursoComponent,
    DetalleCursoComponent,
    NuevoCursoComponent,
    EditarCursoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
