package com.example.demo.Services;

import com.example.demo.Models.Raza;
import com.example.demo.Repositories.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// RazaServiceImpl.java
@Service
public class RazaServiceImpl implements RazaService {

    @Autowired
    private RazaRepository razaRepository;

    @Override
    public List<Raza> getAllRazas() {
        return razaRepository.findAll();
    }

    @Override
    public Raza getRazaById(Long id) {
        return razaRepository.findById(id).orElse(null);
    }

    @Override
    public Raza createRaza(Raza raza) {
        return razaRepository.save(raza);
    }

    @Override
    public Raza updateRaza(Long id, Raza raza) {
        if (razaRepository.existsById(id)) {
            raza.setIdRaza(id);
            return razaRepository.save(raza);
        }
        return null;
    }

    @Override
    public void deleteRaza(Long id) {
        razaRepository.deleteById(id);
    }
}
