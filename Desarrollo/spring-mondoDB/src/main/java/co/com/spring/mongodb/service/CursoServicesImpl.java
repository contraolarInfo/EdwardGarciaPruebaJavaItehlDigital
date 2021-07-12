package co.com.spring.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.spring.mongodb.model.Curso;
import co.com.spring.mongodb.repository.CursoRepository;

@Service
public class CursoServicesImpl implements CursoServices {

    @Autowired
    private CursoRepository repository;

    @Override
    public List<Curso> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Curso obterPorCodigo(String codigo) {
        return repository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Curso no existe."));
    }

    @Override
    public Curso crear(Curso curso) {
        System.out.println(curso);
        return repository.save(curso);
    }

    @Override
    public Curso obterCursoPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Curso> obterCursoPorModalidad(String modalidad) {
        return repository.findByModalidad(modalidad);
    }

    @Override
    public void save(Curso curso){
        repository.save(curso);
    }

    @Override
    public void delete(Curso curso) {
        repository.delete(curso);
    }

}
