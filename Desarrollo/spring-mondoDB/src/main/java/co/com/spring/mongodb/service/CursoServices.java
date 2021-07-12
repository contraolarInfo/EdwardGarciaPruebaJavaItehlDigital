package co.com.spring.mongodb.service;

import java.util.List;

import co.com.spring.mongodb.model.Curso;

public interface CursoServices {

    public List<Curso> obtenerTodos();
    public Curso obterPorCodigo(String codigo);
    public Curso crear(Curso curso);
    public Curso obterCursoPorNombre(String nombre);
    public List<Curso> obterCursoPorModalidad(String modalidad);
    public void save(Curso curso);
    public void delete(Curso curso);
}
