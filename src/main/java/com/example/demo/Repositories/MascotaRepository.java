package com.example.demo.Repositories;

import com.example.demo.Models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
