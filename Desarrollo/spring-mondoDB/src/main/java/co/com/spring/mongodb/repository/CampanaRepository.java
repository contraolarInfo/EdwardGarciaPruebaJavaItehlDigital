package co.com.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.spring.mongodb.model.Campana;

public interface CampanaRepository extends MongoRepository<Campana, String> {
    List<Campana> findByCurso(String curso);
    List<Campana> findByDescuento(String descuento);
}
