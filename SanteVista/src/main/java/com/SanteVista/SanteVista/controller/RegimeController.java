package com.SanteVista.SanteVista.controller;

import com.SanteVista.SanteVista.domain.Regime;
import com.SanteVista.SanteVista.domain.RendezVous;
import com.SanteVista.SanteVista.service.IRegimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/SanteVista/regime")
@RequiredArgsConstructor
@Slf4j
public class RegimeController {
    private final IRegimeService regimeService;

    @GetMapping
    public ResponseEntity<List<Regime>> getAllRegime() {
        List<Regime> regime = regimeService.findAll();
        return new ResponseEntity<>(regime, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regime> getRegimeServiceById(@PathVariable Long id) {
        return regimeService.findById(id)
                .map(regime -> new ResponseEntity<>(regime, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Regime> createRegime(@RequestBody Regime regime) {
        Regime savedRegime = regimeService.save(regime);
        return new ResponseEntity<>(savedRegime, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Regime> updateRendezVous(@PathVariable Long id, @RequestBody Regime regime) {
        if (!regimeService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regime.setId(id);
        Regime updatedRegime = regimeService.update(regime);
        return new ResponseEntity<>(updatedRegime, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegime(@PathVariable Long id) {
        if (!regimeService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regimeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/status/{userId}/{status}")
    public List<Regime> getRegimesByUserId(@PathVariable String userId,@PathVariable boolean status) {
        return regimeService.getRegimesByUserIdAndStatus(userId,status);
    }

    @PutMapping("/{id}/toggleStatus")
    public ResponseEntity<Regime> toggleStatus(@PathVariable Long id) {
        Regime updatedRegime = regimeService.toggleStatus(id);
        return ResponseEntity.ok(updatedRegime);
    }

}
