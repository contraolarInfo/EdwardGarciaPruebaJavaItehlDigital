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

import co.com.spring.mongodb.model.Descuento;
import co.com.spring.mongodb.model.Mensaje;
import co.com.spring.mongodb.service.DescuentoServices;

@RestController
@RequestMapping(value = "/descuento")
public class DescuentoController {
    @Autowired
    DescuentoServices descuentoServices;

    @GetMapping
    public List<Descuento> obterTodos(){
        return descuentoServices.obtenerTodos();
    } 

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Descuento descuento){
        System.out.println(descuento);
        //Si el descuento existe actualizan sus datos
        Descuento temp = descuentoServices.obterDescuentoPorNombre(descuento.getNombre());
        //Se valida la modalidad
        String modalidad = "Privado, Online, OnDemand";
        if (modalidad.indexOf(descuento.getModalidad()) < 0){
            System.out.println("Modalidad "+descuento.getModalidad()+ " no es valida");
            return new ResponseEntity(new Mensaje("Modalidad no valida"), HttpStatus.BAD_REQUEST);
        }
        if (temp == null){
            descuentoServices.crear(descuento);
            return new ResponseEntity(new Mensaje("Descuento creado"), HttpStatus.CREATED);
        }
        temp.setDescuento(descuento.getDescuento());
        temp.setFechafinal(descuento.getFechafinal());
        temp.setPais(descuento.getPais());
        descuentoServices.save(temp);
        return new ResponseEntity(new Mensaje("Descuento actualizado (la modalidad no se modifica)"), HttpStatus.OK);        
    }
}
