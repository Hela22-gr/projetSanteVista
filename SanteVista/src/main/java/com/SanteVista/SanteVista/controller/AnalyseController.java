package com.SanteVista.SanteVista.controller;

import com.SanteVista.SanteVista.domain.Analyse;
import com.SanteVista.SanteVista.service.IAnalyseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/SanteVista/analyse")
@RequiredArgsConstructor
@Slf4j
public class AnalyseController {
    private final IAnalyseService analyseService;

    @GetMapping
    public ResponseEntity<List<Analyse>> getAllAnalyses() {
        List<Analyse> analyses = analyseService.findAll();
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Analyse>> getAnalyseByUserId(@PathVariable String userId) {
        List<Analyse> analyses = analyseService.findAllByUserId(userId);
        return new ResponseEntity<>(analyses, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Analyse> getAnalyseById(@PathVariable Long id) {
        Optional<Analyse> analyse = analyseService.findById(id);
        if (analyse.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si l'analyse n'est pas trouvée, retourne un 404
        }
        return ResponseEntity.ok(analyse.get());
    }

    @DeleteMapping("/deleteMultiple")
    public ResponseEntity<Void> deleteMultipleAnalyses(@RequestBody Map<String, List<Long>> request) {
        List<Long> ids = request.get("ids");
        if (ids != null && !ids.isEmpty()) {
            ids.forEach(analyseService::deleteById); // Supprimer chaque analyse
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<Analyse> createAnalyse(
            @RequestPart("analyse") Analyse analyse,
            @RequestParam("file") MultipartFile file) throws IOException {
        Analyse savedAnalyse = analyseService.save(analyse, file);
        System.out.println("Nom du fichier original : " + file.getOriginalFilename());
        System.out.println("Analyse sauvegardée avec le fichier : " + savedAnalyse.getName());

        return new ResponseEntity<>(savedAnalyse, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Analyse> updateAnalyse(@PathVariable Long id, @RequestBody Analyse analyse) {
        if (!analyseService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        analyse.setId(id);
        Analyse updatedAnalyse = analyseService.update(analyse);
        return new ResponseEntity<>(updatedAnalyse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalyse(@PathVariable Long id) {
        if (!analyseService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        analyseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
