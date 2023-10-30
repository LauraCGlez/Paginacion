package com.bbdd.demo.service;

import com.bbdd.demo.model.Alumno;
import com.bbdd.demo.repository.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServicio {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;


    public Page<Alumno> mostrarAlumnos(Pageable pageable) {
        return  this.alumnoRepositorio.findAll(pageable);
    }

    public void crearAlumno(Alumno nuevoAlumno) {
        this.alumnoRepositorio.save(nuevoAlumno);
    }

    @Transactional
    public void actualizarAlumnoPorID(int idAlumno, Alumno alumnoActualizado) {

        this.alumnoRepositorio.actualizarAlumnoPorID(
                alumnoActualizado.getNombre(),
                alumnoActualizado.getApellido(),
                alumnoActualizado.getEdad(),
                alumnoActualizado.getDni(),
                idAlumno);

    }

    public Alumno buscarAlumnoPorID(int idAlumno) {
        return this.alumnoRepositorio.findById(idAlumno)
                .orElseThrow(() -> new IllegalArgumentException("Id invalido de alumno: " + idAlumno ));
    }

    @Transactional
    public void eliminarAlumnoPorID(int idAlumno) {
        this.alumnoRepositorio.eliminarAlumnoPorID(idAlumno);
    }
}