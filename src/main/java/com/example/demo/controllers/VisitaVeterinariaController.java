package com.example.demo.controllers;

import com.example.demo.Models.VisitaVeterinaria;
import com.example.demo.Services.VisitaVeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitasveterinarias")
public class VisitaVeterinariaController {

    @Autowired
    private VisitaVeterinariaService visitaVeterinariaService;

    private List<VisitaVeterinaria> otrasVisitasVeterinarias;  // Lista para otro conjunto de datos

    @GetMapping
    public ResponseEntity<List<VisitaVeterinaria>> getAllVisitasVeterinarias() {
        List<VisitaVeterinaria> visitasVeterinarias = visitaVeterinariaService.getAllVisitasVeterinarias();
        return new ResponseEntity<>(visitasVeterinarias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitaVeterinaria> getVisitaVeterinariaById(@PathVariable Long id) {
        VisitaVeterinaria visitaVeterinaria = visitaVeterinariaService.getVisitaVeterinariaById(id);
        return visitaVeterinaria != null ?
                new ResponseEntity<>(visitaVeterinaria, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<VisitaVeterinaria> createVisitaVeterinaria(@RequestBody VisitaVeterinaria visitaVeterinaria) {
        VisitaVeterinaria nuevaVisitaVeterinaria = visitaVeterinariaService.createVisitaVeterinaria(visitaVeterinaria);
        return new ResponseEntity<>(nuevaVisitaVeterinaria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitaVeterinaria> updateVisitaVeterinaria(@PathVariable Long id, @RequestBody VisitaVeterinaria visitaVeterinaria) {
        VisitaVeterinaria actualizadaVisitaVeterinaria = visitaVeterinariaService.updateVisitaVeterinaria(id, visitaVeterinaria);
        return actualizadaVisitaVeterinaria != null ?
                new ResponseEntity<>(actualizadaVisitaVeterinaria, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitaVeterinaria(@PathVariable Long id) {
        visitaVeterinariaService.deleteVisitaVeterinaria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/otro")
    public ResponseEntity<List<VisitaVeterinaria>> getAllVisitasVeterinariasOtro() {
        return new ResponseEntity<>(otrasVisitasVeterinarias, HttpStatus.OK);
    }

    @GetMapping("/otro/{id}")
    public ResponseEntity<VisitaVeterinaria> getVisitaVeterinariaOtroById(@PathVariable Long id) {
        VisitaVeterinaria otraVisitaVeterinaria = obtenerVisitaVeterinariaDesdeOtro(id);
        return otraVisitaVeterinaria != null ?
                new ResponseEntity<>(otraVisitaVeterinaria, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/otro")
    public ResponseEntity<VisitaVeterinaria> createVisitaVeterinariaOtro(@RequestBody VisitaVeterinaria visitaVeterinaria) {
        VisitaVeterinaria nuevaVisitaVeterinariaOtro = crearVisitaVeterinariaEnOtro(visitaVeterinaria);
        return new ResponseEntity<>(nuevaVisitaVeterinariaOtro, HttpStatus.CREATED);
    }

    @PutMapping("/otro/{id}")
    public ResponseEntity<VisitaVeterinaria> updateVisitaVeterinariaOtro(@PathVariable Long id, @RequestBody VisitaVeterinaria visitaVeterinaria) {
        VisitaVeterinaria actualizadaVisitaVeterinariaOtro = actualizarVisitaVeterinariaOtro(id, visitaVeterinaria);
        return actualizadaVisitaVeterinariaOtro != null ?
                new ResponseEntity<>(actualizadaVisitaVeterinariaOtro, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/otro/{id}")
    public ResponseEntity<Void> deleteVisitaVeterinariaOtro(@PathVariable Long id) {
        boolean eliminada = eliminarVisitaVeterinariaOtro(id);
        return eliminada ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Métodos ficticios para el conjunto "otro"
    private VisitaVeterinaria obtenerVisitaVeterinariaDesdeOtro(Long id) {
        return otrasVisitasVeterinarias.stream()
                .filter(visita -> visita.getIdVisita().equals(id))
                .findFirst()
                .orElse(null);
    }


    private VisitaVeterinaria crearVisitaVeterinariaEnOtro(VisitaVeterinaria visitaVeterinaria) {
        visitaVeterinaria.setIdVisita(null); // Asignar null para que la base de datos genere el ID automáticamente
        otrasVisitasVeterinarias.add(visitaVeterinaria);
        return visitaVeterinaria;
    }



    private VisitaVeterinaria actualizarVisitaVeterinariaOtro(Long id, VisitaVeterinaria visitaVeterinaria) {
        for (int i = 0; i < otrasVisitasVeterinarias.size(); i++) {
            VisitaVeterinaria existente = otrasVisitasVeterinarias.get(i);
            if (existente.getIdVisita().equals(id)) {
                visitaVeterinaria.setIdVisita(id);
                otrasVisitasVeterinarias.set(i, visitaVeterinaria);
                return visitaVeterinaria;
            }
        }
        return null;
    }

    private boolean eliminarVisitaVeterinariaOtro(Long id) {
        return otrasVisitasVeterinarias.removeIf(visita -> visita.getIdVisita().equals(id));
    }
}