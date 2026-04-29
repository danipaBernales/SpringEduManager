package com.springedu.controller;

import com.springedu.model.Estudiante;
import com.springedu.service.EstudianteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(
            EstudianteService service) {

        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
            "lista",
            service.listar()
        );

        return "estudiantes";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {

        model.addAttribute(
            "estudiante",
            new Estudiante()
        );

        return "nuevo-estudiante";
    }

    @PostMapping
    public String guardar(
            Estudiante estudiante) {

        service.guardar(estudiante);

        return "redirect:/estudiantes";
    }
}
