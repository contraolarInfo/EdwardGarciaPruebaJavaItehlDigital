package co.com.spring.mongodb.service;

import java.util.List;

import co.com.spring.mongodb.model.Campana;

public interface CampanaServices {
    public List<Campana> obtenerTodos();
    public List<Campana> obtenerCampanaPorCurso(String curso);
    public List<Campana> obtenerCampanaPorDescuennto(String descuento);
    public Campana crear(Campana campana);
    public void  save(Campana campana);
    public void delete(Campana campana);
}
