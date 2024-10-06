package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.Categorie;
import com.SanteVista.SanteVista.repository.AnalyseRepository;
import com.SanteVista.SanteVista.repository.CategorieRepository;
import com.SanteVista.SanteVista.service.ICategorieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategorieImp implements ICategorieService {
    private final CategorieRepository categorieRepository;
    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> findById(Long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie update(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteById(Long id) {
categorieRepository.deleteById(id);
    }
}
