package com.example.demo.Repositories;

import com.example.demo.Models.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RazaRepository extends JpaRepository<Raza, Long> {
    // Buscar razas por nombre
    List<Raza> findByNombre(String nombre);
}
