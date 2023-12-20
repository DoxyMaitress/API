package com.example.demo.controllers;

import com.example.demo.Models.Mascota;
import com.example.demo.Services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    private List<Mascota> otrasMascotas;  // Lista para otro conjunto de datos

    @GetMapping
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return mascota != null ?
                new ResponseEntity<>(mascota, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.createMascota(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota actualizadaMascota = mascotaService.updateMascota(id, mascota);
        return actualizadaMascota != null ?
                new ResponseEntity<>(actualizadaMascota, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/otro")
    public ResponseEntity<List<Mascota>> getAllMascotasOtro() {
        return new ResponseEntity<>(otrasMascotas, HttpStatus.OK);
    }

    @GetMapping("/otro/{id}")
    public ResponseEntity<Mascota> getMascotaOtroById(@PathVariable Long id) {
        Mascota otraMascota = obtenerMascotaDesdeOtro(id);
        return otraMascota != null ?
                new ResponseEntity<>(otraMascota, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/otro")
    public ResponseEntity<Mascota> createMascotaOtro(@RequestBody Mascota mascota) {
        Mascota nuevaMascotaOtro = crearMascotaEnOtro(mascota);
        return new ResponseEntity<>(nuevaMascotaOtro, HttpStatus.CREATED);
    }

    @PutMapping("/otro/{id}")
    public ResponseEntity<Mascota> updateMascotaOtro(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota actualizadaMascotaOtro = actualizarMascotaOtro(id, mascota);
        return actualizadaMascotaOtro != null ?
                new ResponseEntity<>(actualizadaMascotaOtro, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/otro/{id}")
    public ResponseEntity<Void> deleteMascotaOtro(@PathVariable Long id) {
        boolean eliminada = eliminarMascotaOtro(id);
        return eliminada ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Métodos ficticios para el conjunto "otro"
    private Mascota obtenerMascotaDesdeOtro(Long id) {
        return otrasMascotas.stream()
                .filter(mascota -> mascota.getIdMascota().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Mascota crearMascotaEnOtro(Mascota mascota) {
        mascota.setIdMascota(null); // Asignar null para que la base de datos genere el ID automáticamente
        otrasMascotas.add(mascota);
        return mascota;
    }

    private Mascota actualizarMascotaOtro(Long id, Mascota mascota) {
        for (int i = 0; i < otrasMascotas.size(); i++) {
            Mascota existente = otrasMascotas.get(i);
            if (existente.getIdMascota().equals(id)) {
                mascota.setIdMascota(id);
                otrasMascotas.set(i, mascota);
                return mascota;
            }
        }
        return null;
    }

    private boolean eliminarMascotaOtro(Long id) {
        return otrasMascotas.removeIf(mascota -> mascota.getIdMascota().equals(id));
    }
}
