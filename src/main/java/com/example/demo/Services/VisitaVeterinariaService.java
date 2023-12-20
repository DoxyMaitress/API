package com.example.demo.Services;

import com.example.demo.Models.VisitaVeterinaria;

import java.util.List;

public interface VisitaVeterinariaService {
    List<VisitaVeterinaria> getAllVisitasVeterinarias();

    VisitaVeterinaria getVisitaVeterinariaById(Long id);

    VisitaVeterinaria createVisitaVeterinaria(VisitaVeterinaria visitaVeterinaria);

    VisitaVeterinaria updateVisitaVeterinaria(Long id, VisitaVeterinaria visitaVeterinaria);

    void deleteVisitaVeterinaria(Long id);
}
