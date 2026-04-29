package com.springedu.controller.rest;

import com.springedu.model.Curso;
import com.springedu.repository.CursoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

    private final CursoRepository repository;

    public CursoRestController(
            CursoRepository repository) {

        this.repository = repository;
    }

    // LISTAR

    @GetMapping
    public List<Curso> listar() {

        return repository.findAll();
    }

    // BUSCAR POR ID

    @GetMapping("/{id}")
    public Curso buscar(
            @PathVariable Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    // CREAR

    @PostMapping
    public Curso guardar(
            @RequestBody
            Curso curso) {

        return repository.save(curso);
    }

    // ACTUALIZAR

    @PutMapping("/{id}")
    public Curso actualizar(
            @PathVariable Long id,
            @RequestBody
            Curso datos) {

        Curso curso =
            repository.findById(id)
            .orElse(null);

        if (curso != null) {

            curso.setNombre(
                datos.getNombre()
            );

            curso.setProfesor(
                datos.getProfesor()
            );

            return repository.save(
                curso
            );
        }

        return null;
    }

    // ELIMINAR

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        repository.deleteById(id);
    }
}
