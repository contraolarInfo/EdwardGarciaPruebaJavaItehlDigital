package co.com.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.spring.mongodb.model.Descuento;

public interface DescuentoRepository extends MongoRepository<Descuento, String> {
    Descuento findByNombre(String nombre);
}
