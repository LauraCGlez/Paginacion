package com.bbdd.demo.repository;

import com.bbdd.demo.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {

    void actualizarAlumnoPorID(String nombre, String apellido, int edad, String dni, int idAlumno);

    void eliminarAlumnoPorID(int idAlumno);
}
