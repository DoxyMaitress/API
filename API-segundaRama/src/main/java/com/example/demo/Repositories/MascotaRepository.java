package com.example.demo.Repositories;

import com.example.demo.Models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Consulta personalizada para buscar mascotas por nombre
    @Query("SELECT m FROM Mascota m WHERE m.nombre = ?1")
    List<Mascota> findByNombre(String nombre);
}
