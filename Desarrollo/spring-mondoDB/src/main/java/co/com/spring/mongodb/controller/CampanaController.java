package co.com.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.spring.mongodb.model.Campana;
import co.com.spring.mongodb.model.Curso;
import co.com.spring.mongodb.model.Descuento;
import co.com.spring.mongodb.model.Mensaje;
import co.com.spring.mongodb.service.CampanaServices;
import co.com.spring.mongodb.service.CursoServices;
import co.com.spring.mongodb.service.DescuentoServices;
import co.com.spring.mongodb.service.DescuentoServicesImpl;

@RestController
@RequestMapping(value = "/campana")
public class CampanaController {

    @Autowired
    CampanaServices campanaServices;

    @Autowired
    CursoServices cursoServices;

    @Autowired
    DescuentoServices descuentoServices;

    @GetMapping
    public List<Campana> obterTodos(){
        return campanaServices.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Campana campana){
        System.out.println(campana);
        //Validar que el curso exista y tomar su modalidad
        Curso ctemp = cursoServices.obterCursoPorNombre(campana.getCurso());
        if (ctemp ==null){
            return new ResponseEntity(new Mensaje("Curso no existe"), HttpStatus.BAD_REQUEST);
        }
        //Validar que el descuento existe y tomar su modalidad
        Descuento dtemp = descuentoServices.obterDescuentoPorNombre(campana.getDescuento());
        if (dtemp ==null){
            return new ResponseEntity(new Mensaje("Descuento no existe"), HttpStatus.BAD_REQUEST);
        }
        //Se crea la campana si y solo si tiene la misma modalidad
        if (! ctemp.getModalidad().equalsIgnoreCase(dtemp.getModalidad())){
            return new ResponseEntity(new Mensaje("La modalidad del curso y el descuento no son iguales"), HttpStatus.BAD_REQUEST);
        }
        //Se crea la camapaña si y solo si no existe una campaña para este para de valores (curso, descuento).
        List<Campana> camtemp = campanaServices.obtenerCampanaPorCurso(campana.getCurso());
        for (int i=0; i<camtemp.size();i++){
            if (camtemp.get(i).getDescuento().contentEquals(campana.getDescuento())){
                return new ResponseEntity(new Mensaje("Esta campana ya existe"), HttpStatus.BAD_REQUEST);
            }
        }
        campanaServices.crear(campana);
        return new ResponseEntity(new Mensaje("Campana creada"), HttpStatus.CREATED);
    }
}