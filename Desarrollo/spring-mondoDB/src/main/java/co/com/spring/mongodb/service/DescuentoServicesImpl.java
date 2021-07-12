package co.com.spring.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.spring.mongodb.model.Descuento;
import co.com.spring.mongodb.repository.DescuentoRepository;

@Service
public class DescuentoServicesImpl implements DescuentoServices{

    @Autowired
    private DescuentoRepository repository;

    @Override
    public List<Descuento> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Descuento crear(Descuento descuento) {
        System.out.println(descuento);
        return repository.save(descuento);
    }

    @Override
    public Descuento obterDescuentoPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public void  save(Descuento descuento){
        repository.save(descuento);
    }
    
}
