package co.com.spring.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document
@ToString
public class Descuento {
    @Id
    private String codigo;
    private String nombre;
    private String modalidad;
    private String pais;    
    private String descuento;
    private Date fechafinal;
    
    public Descuento() {
    }

    public Descuento(String codigo, String nombre, String modalidad, String pais, String descuento, String curso,
            Date fechafinal) {
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.pais = pais;
        this.descuento = descuento;
        this.fechafinal = fechafinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }


}
