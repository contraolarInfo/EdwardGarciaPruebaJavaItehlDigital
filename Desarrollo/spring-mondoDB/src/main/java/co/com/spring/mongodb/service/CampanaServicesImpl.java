package co.com.spring.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.spring.mongodb.model.Campana;
import co.com.spring.mongodb.repository.CampanaRepository;

@Service
public class CampanaServicesImpl implements CampanaServices {

    @Autowired
    private CampanaRepository repository;

    @Override
    public List<Campana> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public List<Campana> obtenerCampanaPorCurso(String curso) {
        return repository.findByCurso(curso);
    }

    @Override
    public List<Campana> obtenerCampanaPorDescuennto(String descuento) {
        return repository.findByDescuento(descuento);
    }

    @Override
    public Campana crear(Campana campana) {
        System.out.println(campana);
        return repository.save(campana);
    }

    @Override
    public void  save(Campana campana){
        repository.save(campana);
    }

    @Override
    public void delete(Campana campana) {
        repository.delete(campana);
    }

}
