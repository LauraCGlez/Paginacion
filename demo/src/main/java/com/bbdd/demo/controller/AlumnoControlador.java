package com.bbdd.demo.controller;

import com.bbdd.demo.model.Alumno;
import com.bbdd.demo.repository.AlumnoRepositorio;
import com.bbdd.demo.service.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping("/")
    public String mostrarAlumnos(Model model,
                                        @PageableDefault(size = 5)
                                        Pageable pageable){

        Page<Alumno> alumnoPage = this.alumnoServicio.mostrarAlumnos(pageable);

        model.addAttribute("alumnos", alumnoPage);

        return "index";
    }

    @GetMapping("/crearAlumno")
    public String crearAlumno(Model model){
        Alumno nuevoAlumno = new Alumno();
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        return "nuevo-alumno";
    }


    @PostMapping("/agregar-alumno")
    public String agregarAlumno(@ModelAttribute Alumno nuevoAlumno) {
        alumnoRepositorio.save(nuevoAlumno);
        return "redirect:/";
    }
}


