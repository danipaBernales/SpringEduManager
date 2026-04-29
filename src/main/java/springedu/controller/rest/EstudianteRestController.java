package com.springedu.controller.rest;

import com.springedu.model.Estudiante;
import com.springedu.repository.EstudianteRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    private final EstudianteRepository repository;

    public EstudianteRestController(
            EstudianteRepository repository) {

        this.repository = repository;
    }

    // LISTAR

    @GetMapping
    public List<Estudiante> listar() {

        return repository.findAll();
    }

    // BUSCAR POR ID

    @GetMapping("/{id}")
    public Estudiante buscar(
            @PathVariable Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    // CREAR

    @PostMapping
    public Estudiante guardar(
            @RequestBody
            Estudiante estudiante) {

        return repository.save(estudiante);
    }

    // ACTUALIZAR

    @PutMapping("/{id}")
    public Estudiante actualizar(
            @PathVariable Long id,
            @RequestBody
            Estudiante datos) {

        Estudiante estudiante =
            repository.findById(id)
            .orElse(null);

        if (estudiante != null) {

            estudiante.setNombre(
                datos.getNombre()
            );

            estudiante.setEmail(
                datos.getEmail()
            );

            return repository.save(
                estudiante
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
