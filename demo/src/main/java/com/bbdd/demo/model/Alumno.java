package com.bbdd.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "dni", length = 9)
    private String dni;

}
