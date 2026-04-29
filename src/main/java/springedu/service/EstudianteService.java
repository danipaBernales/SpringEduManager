package com.springedu.service;

import com.springedu.model.Estudiante;
import com.springedu.repository.EstudianteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(
            EstudianteRepository repository) {

        this.repository = repository;
    }

    public List<Estudiante> listar() {

        return repository.findAll();
    }

    public void guardar(
            Estudiante estudiante) {

        repository.save(estudiante);
    }
}
