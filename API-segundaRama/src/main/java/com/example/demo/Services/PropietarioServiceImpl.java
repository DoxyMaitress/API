package com.example.demo.Services;

import com.example.demo.Models.Propietario;
import com.example.demo.Repositories.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// PropietarioServiceImpl.java
@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> getAllPropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario getPropietarioById(Long id) {
        return propietarioRepository.findById(id).orElse(null);
    }

    @Override
    public Propietario createPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario updatePropietario(Long id, Propietario propietario) {
        if (propietarioRepository.existsById(id)) {
            propietario.setIdPropietario(id);
            return propietarioRepository.save(propietario);
        }
        return null;
    }

    @Override
    public void deletePropietario(Long id) {
        propietarioRepository.deleteById(id);
    }
}
