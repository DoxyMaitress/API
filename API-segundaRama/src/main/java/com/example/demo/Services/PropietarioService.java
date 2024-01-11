package com.example.demo.Services;

import com.example.demo.Models.Propietario;

import java.util.List;

public interface PropietarioService {
    List<Propietario> getAllPropietarios();

    Propietario getPropietarioById(Long id);

    Propietario createPropietario(Propietario propietario);

    Propietario updatePropietario(Long id, Propietario propietario);

    void deletePropietario(Long id);
}

