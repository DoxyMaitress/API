package com.example.demo.Repositories;


import com.example.demo.Models.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
        // Puedes agregar consultas personalizadas si es necesario
    }


