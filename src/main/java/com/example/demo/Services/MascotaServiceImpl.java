package com.example.demo.Services;


import com.example.demo.Models.Mascota;
import com.example.demo.Repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @Override
    public Mascota createMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public Mascota updateMascota(Long id, Mascota mascota) {
        if (mascotaRepository.existsById(id)) {
            mascota.setIdMascota(id);
            return mascotaRepository.save(mascota);
        }
        return null;
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
