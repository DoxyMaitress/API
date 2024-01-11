package com.example.demo.controllers;

import com.example.demo.Models.Propietario;
import com.example.demo.Services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    private List<Propietario> otrosPropietarios = new ArrayList<>();  // Inicializar la lista

    // Métodos CRUD básicos para los propietarios

    @GetMapping("/todosPropietario/propietarios")
    public ResponseEntity<List<Propietario>> getAllPropietarios() {
        List<Propietario> propietarios = propietarioService.getAllPropietarios();
        return new ResponseEntity<>(propietarios, HttpStatus.OK);
    }

    @GetMapping("propietarioId/{id}")
    public ResponseEntity<Propietario> getPropietarioById(@PathVariable Long id) {
        Propietario propietario = propietarioService.getPropietarioById(id);
        return propietario != null ?
                new ResponseEntity<>(propietario, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crearPropietario/propietarios")
    public ResponseEntity<Propietario> createPropietario(@RequestBody Propietario propietario) {
        Propietario nuevoPropietario = propietarioService.createPropietario(propietario);
        return new ResponseEntity<>(nuevoPropietario, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarPropietario/{id}")
    public ResponseEntity<Propietario> updatePropietario(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario actualizadoPropietario = propietarioService.updatePropietario(id, propietario);
        return actualizadoPropietario != null ?
                new ResponseEntity<>(actualizadoPropietario, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminarPropietario/{id}")
    public ResponseEntity<Void> deletePropietario(@PathVariable Long id) {
        propietarioService.deletePropietario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Métodos ficticios para el conjunto "otro"

    @GetMapping("/todosPropietarioOtro/otro")
    public ResponseEntity<List<Propietario>> getAllPropietariosOtro() {
        return new ResponseEntity<>(otrosPropietarios, HttpStatus.OK);
    }

    @GetMapping("/obtenerPropietarioOtro/otro/{id}")
    public ResponseEntity<Propietario> getPropietarioOtroById(@PathVariable Long id) {
        Propietario otroPropietario = obtenerPropietarioDesdeOtro(id);
        return otroPropietario != null ?
                new ResponseEntity<>(otroPropietario, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crearPropietarioOtro/otro")
    public ResponseEntity<Propietario> createPropietarioOtro(@RequestBody Propietario propietario) {
        Propietario nuevoPropietarioOtro = crearPropietarioEnOtro(propietario);
        return new ResponseEntity<>(nuevoPropietarioOtro, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarPropietarioOtro/otro/{id}")
    public ResponseEntity<Propietario> updatePropietarioOtro(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario actualizadoPropietarioOtro = actualizarPropietarioOtro(id, propietario);
        return actualizadoPropietarioOtro != null ?
                new ResponseEntity<>(actualizadoPropietarioOtro, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//holax
    @DeleteMapping("/eliminarPropietarioOtro/otro/{id}")
    public ResponseEntity<Void> deletePropietarioOtro(@PathVariable Long id) {
        boolean eliminado = eliminarPropietarioOtro(id);
        return eliminado ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Métodos ficticios para el conjunto "otro"
    private Propietario obtenerPropietarioDesdeOtro(Long id) {
        return otrosPropietarios.stream()
                .filter(propietario -> propietario.getIdPropietario().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Propietario crearPropietarioEnOtro(Propietario propietario) {
        propietario.setIdPropietario(null); // Asignar null para que la base de datos genere el ID automáticamente
        otrosPropietarios.add(propietario);
        return propietario;
    }

    private Propietario actualizarPropietarioOtro(Long id, Propietario propietario) {
        for (int i = 0; i < otrosPropietarios.size(); i++) {
            Propietario existente = otrosPropietarios.get(i);
            if (existente.getIdPropietario().equals(id)) {
                propietario.setIdPropietario(id);
                otrosPropietarios.set(i, propietario);
                return propietario;
            }
        }
        return null;
    }

    private boolean eliminarPropietarioOtro(Long id) {
        return otrosPropietarios.removeIf(propietario -> propietario.getIdPropietario().equals(id));
    }
}
