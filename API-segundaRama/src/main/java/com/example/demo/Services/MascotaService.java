package com.example.demo.Services;


import com.example.demo.Models.Mascota;

import java.util.List;

public interface MascotaService {
    List<Mascota> getAllMascotas();

    Mascota getMascotaById(Long id);

    Mascota createMascota(Mascota mascota);

    Mascota updateMascota(Long id, Mascota mascota);

    void deleteMascota(Long id);
}
