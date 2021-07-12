package co.com.spring.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document
@ToString
public class Campana {

    private String curso;
    private String descuento;

    
    public Campana() {
    }

    
    public Campana(String curso, String descuento) {
        this.curso = curso;
        this.descuento = descuento;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getDescuento() {
        return descuento;
    }
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    
    
}
