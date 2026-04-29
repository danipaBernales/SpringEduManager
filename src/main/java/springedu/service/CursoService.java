package com.springedu.service;

import com.springedu.model.Curso;
import com.springedu.repository.CursoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(
            CursoRepository repository) {

        this.repository = repository;
    }

    public List<Curso> listar() {

        return repository.findAll();
    }

    public void guardar(
            Curso curso) {

        repository.save(curso);
    }
}
