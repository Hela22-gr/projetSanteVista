package com.SanteVista.SanteVista.service;

import com.SanteVista.SanteVista.domain.Analyse;
import com.SanteVista.SanteVista.domain.Categorie;

import java.util.List;
import java.util.Optional;

public interface ICategorieService {
    List<Categorie> findAll();
    Optional<Categorie> findById(Long id);

    Categorie save(Categorie categorie);

    Categorie update(Categorie categorie);

    void deleteById(Long id);
}
