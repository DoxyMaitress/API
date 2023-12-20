package com.example.demo.Services;
import com.example.demo.Models.VisitaVeterinaria;
import com.example.demo.Repositories.VisitaVeterinariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaVeterinariaServiceImpl implements VisitaVeterinariaService {

    @Autowired
    private VisitaVeterinariaRepository visitaVeterinariaRepository;

    @Override
    public List<VisitaVeterinaria> getAllVisitasVeterinarias() {
        return visitaVeterinariaRepository.findAll();
    }

    @Override
    public VisitaVeterinaria getVisitaVeterinariaById(Long id) {
        return visitaVeterinariaRepository.findById(id).orElse(null);
    }

    @Override
    public VisitaVeterinaria createVisitaVeterinaria(VisitaVeterinaria visitaVeterinaria) {
        return visitaVeterinariaRepository.save(visitaVeterinaria);
    }

    @Override
    public VisitaVeterinaria updateVisitaVeterinaria(Long id, VisitaVeterinaria visitaVeterinaria) {
        if (visitaVeterinariaRepository.existsById(id)) {
            visitaVeterinaria.setIdVisita(id);
            return visitaVeterinariaRepository.save(visitaVeterinaria);
        }
        return null;
    }

    @Override
    public void deleteVisitaVeterinaria(Long id) {
        visitaVeterinariaRepository.deleteById(id);
    }
}
