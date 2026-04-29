package com.springedu.repository;

import com.springedu.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository
extends JpaRepository<Curso, Long> {
}
