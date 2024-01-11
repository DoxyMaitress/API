package com.example.demo.controllers;

import com.example.demo.Models.Raza;
import com.example.demo.Services.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/razas")
public class RazaController {

    @Autowired
    private RazaService razaService;

    private List<Raza> otrasRazas = new ArrayList<>();  // Inicializar la lista

    // Métodos CRUD básicos para las razas

    @GetMapping("/todasRazas")
    public ResponseEntity<List<Raza>> getAllRazas() {
        List<Raza> razas = razaService.getAllRazas();
        return new ResponseEntity<>(razas, HttpStatus.OK);
    }

    @GetMapping("/buscaId/{id}")
    public ResponseEntity<Raza> getRazaById(@PathVariable Long id) {
        Raza raza = razaService.getRazaById(id);
        return raza != null ?
                new ResponseEntity<>(raza, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crearRaza")
    public ResponseEntity<Raza> createRaza(@RequestBody Raza raza) {
        Raza nuevaRaza = razaService.createRaza(raza);
        return new ResponseEntity<>(nuevaRaza, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarRaza/{id}")
    public ResponseEntity<Raza> updateRaza(@PathVariable Long id, @RequestBody Raza raza) {
        Raza actualizadaRaza = razaService.updateRaza(id, raza);
        return actualizadaRaza != null ?
                new ResponseEntity<>(actualizadaRaza, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminarRaza/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable Long id) {
        razaService.deleteRaza(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Métodos ficticios para el conjunto "otro"

    @GetMapping("/otro")
    public ResponseEntity<List<Raza>> getAllRazasOtro() {
        return new ResponseEntity<>(otrasRazas, HttpStatus.OK);
    }

    @GetMapping("/obtenerRazaOtro/{id}")
    public ResponseEntity<Raza> getRazaOtroById(@PathVariable Long id) {
        Raza otraRaza = obtenerRazaDesdeOtro(id);
        return otraRaza != null ?
                new ResponseEntity<>(otraRaza, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crearRazaOtro/otro")
    public ResponseEntity<Raza> createRazaOtro(@RequestBody Raza raza) {
        Raza nuevaRazaOtro = crearRazaEnOtro(raza);
        return new ResponseEntity<>(nuevaRazaOtro, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarRazaOtro/otro/{id}")
    public ResponseEntity<Raza> updateRazaOtro(@PathVariable Long id, @RequestBody Raza raza) {
        Raza actualizadaRazaOtro = actualizarRazaOtro(id, raza);
        return actualizadaRazaOtro != null ?
                new ResponseEntity<>(actualizadaRazaOtro, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrarRazaOtro/otro/{id}")
    public ResponseEntity<Void> deleteRazaOtro(@PathVariable Long id) {
        boolean eliminada = eliminarRazaOtro(id);
        return eliminada ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Métodos ficticios para el conjunto "otro"
    private Raza obtenerRazaDesdeOtro(Long id) {
        return otrasRazas.stream()
                .filter(raza -> raza.getIdRaza().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Raza crearRazaEnOtro(Raza raza) {
        raza.setIdRaza(null); // Asignar null para que la base de datos genere el ID automáticamente
        otrasRazas.add(raza);
        return raza;
    }

    private Raza actualizarRazaOtro(Long id, Raza raza) {
        for (int i = 0; i < otrasRazas.size(); i++) {
            Raza existente = otrasRazas.get(i);
            if (existente.getIdRaza().equals(id)) {
                raza.setIdRaza(id);
                otrasRazas.set(i, raza);
                return raza;
            }
        }
        return null;
    }

    private boolean eliminarRazaOtro(Long id) {
        return otrasRazas.removeIf(raza -> raza.getIdRaza().equals(id));
    }
}
