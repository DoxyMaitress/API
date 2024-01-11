package com.example.demo.Repositories;

import com.example.demo.Models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    // Consulta para buscar propietarios por nombre
    List<Propietario> findByNombre(String nombre);
}
