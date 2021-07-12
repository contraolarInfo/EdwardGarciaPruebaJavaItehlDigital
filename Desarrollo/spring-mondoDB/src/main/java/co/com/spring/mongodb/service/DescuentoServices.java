package co.com.spring.mongodb.service;

import java.util.List;

import co.com.spring.mongodb.model.Descuento;

public interface DescuentoServices {
    public List<Descuento> obtenerTodos();
    public Descuento obterDescuentoPorNombre(String nombre);
    public Descuento crear(Descuento descuento);
    public void save(Descuento descuento);
}
