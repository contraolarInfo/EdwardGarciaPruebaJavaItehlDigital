package co.com.spring.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.spring.mongodb.model.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {
    Curso findByNombre(String nombre);
    List<Curso> findByModalidad(String modalidad);
    boolean existsByNombre(String nombre);
    boolean existsByModalidad(String modalidad);
}
