package com.example.demo.Repositories;

import com.example.demo.Models.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

// RazaRepository.java
public interface RazaRepository extends JpaRepository<Raza, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
