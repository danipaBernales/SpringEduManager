package com.springedu.controller;

import com.springedu.model.Curso;
import com.springedu.service.CursoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(
            CursoService service) {

        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
            "lista",
            service.listar()
        );

        return "cursos";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {

        model.addAttribute(
            "curso",
            new Curso()
        );

        return "nuevo-curso";
    }

    @PostMapping
    public String guardar(Curso curso) {

        service.guardar(curso);

        return "redirect:/cursos";
    }
}
