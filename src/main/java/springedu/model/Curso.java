package com.springedu.model;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy =
        GenerationType.IDENTITY)

    private Long id;

    private String nombre;

    private String profesor;

    public Curso() {
    }

    public Curso(
            String nombre,
            String profesor) {

        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(
            String nombre) {

        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(
            String profesor) {

        this.profesor = profesor;
    }
}
