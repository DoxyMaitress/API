package com.example.demo.Services;

import com.example.demo.Models.Raza;

import java.util.List;

// RazaService.java
public interface RazaService {
    List<Raza> getAllRazas();
    Raza getRazaById(Long id);
    Raza createRaza(Raza raza);
    Raza updateRaza(Long id, Raza raza);
    void deleteRaza(Long id);
}
