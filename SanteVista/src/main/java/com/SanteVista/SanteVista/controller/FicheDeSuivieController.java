package com.SanteVista.SanteVista.controller;

import com.SanteVista.SanteVista.domain.FicheDeSuivie;
import com.SanteVista.SanteVista.service.IFicheDeSuivieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/SanteVista/ficheDeSuivie")
@RequiredArgsConstructor
@Slf4j
public class FicheDeSuivieController {

    private final IFicheDeSuivieService ficheDeSuivieService;

    @GetMapping
    public ResponseEntity<List<FicheDeSuivie>> getAllFiches() {
        List<FicheDeSuivie> fiches = ficheDeSuivieService.findAll();
        return new ResponseEntity<>(fiches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheDeSuivie> getFicheById(@PathVariable Long id) {
        return ficheDeSuivieService.findById(id)
                .map(fiche -> new ResponseEntity<>(fiche, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<FicheDeSuivie> createFiche(@RequestBody FicheDeSuivie ficheDeSuivie) {
        FicheDeSuivie savedFiche = ficheDeSuivieService.save(ficheDeSuivie);
        return new ResponseEntity<>(savedFiche, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheDeSuivie> updateFiche(@PathVariable Long id, @RequestBody FicheDeSuivie ficheDeSuivie) {
        if (!ficheDeSuivieService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ficheDeSuivie.setId(id);
        FicheDeSuivie updatedFiche = ficheDeSuivieService.update(ficheDeSuivie);
        return new ResponseEntity<>(updatedFiche, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiche(@PathVariable Long id) {
        if (!ficheDeSuivieService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ficheDeSuivieService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
