package com.SanteVista.SanteVista.controller;

import com.SanteVista.SanteVista.domain.ActivitePhysique;
import com.SanteVista.SanteVista.service.IAvtivitePhysiqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/SanteVista/activitePhysique")
@RequiredArgsConstructor
@Slf4j
public class ActivitePhysiqueController {
    private final IAvtivitePhysiqueService activitePhysiqueService;

    @GetMapping
    public ResponseEntity<List<ActivitePhysique>> getAllActivites() {
        List<ActivitePhysique> activites = activitePhysiqueService.findAll();
        return new ResponseEntity<>(activites, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivitePhysique> getActiviteById(@PathVariable Long id) {
        return activitePhysiqueService.findById(id)
                .map(activite -> new ResponseEntity<>(activite, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ActivitePhysique> createActivite(@RequestBody ActivitePhysique activitePhysique) {
        ActivitePhysique savedActivite = activitePhysiqueService.save(activitePhysique);
        return new ResponseEntity<>(savedActivite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivitePhysique> updateActivite(@PathVariable Long id, @RequestBody ActivitePhysique activitePhysique) {
        if (!activitePhysiqueService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        activitePhysique.setId(id);
        ActivitePhysique updatedActivite = activitePhysiqueService.update(activitePhysique);
        return new ResponseEntity<>(updatedActivite, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable Long id) {
        if (!activitePhysiqueService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        activitePhysiqueService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivitePhysique>> getActivitesByUserId(@PathVariable String userId) {
        List<ActivitePhysique> activites = activitePhysiqueService.getActivitesByUserId(userId);
        return ResponseEntity.ok(activites);
    }
}
