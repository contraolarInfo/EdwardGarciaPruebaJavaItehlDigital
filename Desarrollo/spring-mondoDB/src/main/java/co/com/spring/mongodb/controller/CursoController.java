package co.com.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.com.spring.mongodb.model.Campana;
import co.com.spring.mongodb.model.Curso;
import co.com.spring.mongodb.model.Mensaje;
import co.com.spring.mongodb.service.CampanaServices;
import co.com.spring.mongodb.service.CursoServices;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    CursoServices cursoServices;

    @Autowired
    CampanaServices campanaServices;

    @GetMapping
    public List<Curso> obterTodos(){
        return cursoServices.obtenerTodos();
    }

    @GetMapping(value ="/modalidad")
    public List<Curso> obterCursoPorModalidad(
            @RequestParam("modalidad") String modalidad){
        return cursoServices.obterCursoPorModalidad(modalidad);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Curso curso){
        System.out.println(curso);
        //Si el curso existe actualiza sus datos con lo nuevo
        Curso temp = cursoServices.obterCursoPorNombre(curso.getNombre());
        //Se valida la modalidad
        String modalidad = "Privado, Online, OnDemand";
        if (modalidad.indexOf(curso.getModalidad()) < 0){
            System.out.println("Modalidad "+curso.getModalidad()+ " no es valida");
            return new ResponseEntity(new Mensaje("Modalidad no valida"), HttpStatus.BAD_REQUEST);
        }
        if (temp == null){
            cursoServices.crear(curso);
            return new ResponseEntity(new Mensaje("Curso creado"), HttpStatus.CREATED);
        }
        temp.setCosto(curso.getCosto());
        temp.setDescripcion(curso.getDescripcion());
        temp.setDirigidoa(curso.getDirigidoa());
        temp.setHoras(curso.getHoras());
        temp.setModalidad(curso.getModalidad());
        cursoServices.save(temp);
        return new ResponseEntity(new Mensaje("Curso actualizado"), HttpStatus.OK);        
    }

    @PostMapping("/borrar/{nombre}")
    public ResponseEntity<?> borrar(@RequestBody String nombre){
        Curso temp = cursoServices.obterCursoPorNombre(nombre);
        //Primero se eliminan las campanas asociadas con el curso
        List<Campana> ctemp = campanaServices.obtenerCampanaPorCurso(nombre);
        for (int i=0;i<ctemp.size();i++){
            campanaServices.delete(ctemp.get(i));
        }
        cursoServices.delete(temp);
        return new ResponseEntity(new Mensaje("Curso borrado"), HttpStatus.OK);
    }
}