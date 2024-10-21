package com.SanteVista.SanteVista.controller;

import com.SanteVista.SanteVista.domain.Analyse;
import com.SanteVista.SanteVista.domain.RendezVous;
import com.SanteVista.SanteVista.service.IRendezVousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/SanteVista/rendezVous")
@RequiredArgsConstructor
@Slf4j
public class RendezVousController {
    private final IRendezVousService rendezVousService;

    @GetMapping
    public ResponseEntity<List<RendezVous>> getAllRendezVous() {
        List<RendezVous> rendezVous = rendezVousService.findAll();
        return new ResponseEntity<>(rendezVous, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.findById(id)
                .map(rendezVous -> new ResponseEntity<>(rendezVous, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/allAppointments/{userId}")
    public ResponseEntity<List<RendezVous>> getAllRendezVousByUserId(@PathVariable String userId) {
        List<RendezVous> rendezVous = rendezVousService.findAllByUserId(userId);
        return new ResponseEntity<>(rendezVous, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RendezVous> createRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous savedRendezVous = rendezVousService.save(rendezVous);
        return new ResponseEntity<>(savedRendezVous, HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<RendezVous> AcceptedRendezVous(@PathVariable Long id) {
        RendezVous savedRendezVous = rendezVousService.update(id);
        return new ResponseEntity<>(savedRendezVous, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVous rendezVous) {
        if (!rendezVousService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rendezVous.setId(id);
        RendezVous updatedRendezVous = rendezVousService.update(rendezVous);
        return new ResponseEntity<>(updatedRendezVous, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        if (!rendezVousService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rendezVousService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
