package co.com.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document
@ToString
public class Curso {

    private String nombre;
    private Integer costo;
    private String descripcion;
    private Integer horas;
    private String dirigidoa;
    private String modalidad;

    public Curso(String codigo, String nombre, int costo, String descripcion, int horas, String dirigidoa,
            String modalidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.dirigidoa = dirigidoa;
        this.modalidad = modalidad;
    }
 
    public Curso() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getDirigidoa() {
        return dirigidoa;
    }

    public void setDirigidoa(String dirigidoa) {
        this.dirigidoa = dirigidoa;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

}
