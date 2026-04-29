package com.springedu.repository;

import com.springedu.model.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository
extends JpaRepository<Estudiante, Long> {
}
