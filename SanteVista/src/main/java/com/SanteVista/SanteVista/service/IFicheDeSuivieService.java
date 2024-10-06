package com.SanteVista.SanteVista.service;

import com.SanteVista.SanteVista.domain.FicheDeSuivie;

import java.util.List;
import java.util.Optional;

public interface IFicheDeSuivieService {
    List<FicheDeSuivie> findAll();
    Optional<FicheDeSuivie> findById(Long id);
    FicheDeSuivie save(FicheDeSuivie ficheDeSuivie);
    FicheDeSuivie update(FicheDeSuivie ficheDeSuivie);
    void deleteById(Long id);
}
