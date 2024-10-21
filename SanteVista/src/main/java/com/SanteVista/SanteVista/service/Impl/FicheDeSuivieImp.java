package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.FicheDeSuivie;
import com.SanteVista.SanteVista.repository.FicheDeSuivieRepository;
import com.SanteVista.SanteVista.service.IFicheDeSuivieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class FicheDeSuivieImp implements IFicheDeSuivieService {
    private final FicheDeSuivieRepository ficheDeSuivieRepository;

    @Override
    public List<FicheDeSuivie> findAll() {
        log.info("Getting all fiche de suivie");
        return ficheDeSuivieRepository.findAll();
    }
    @Override
    public Optional<FicheDeSuivie> findById(Long id) {
        return ficheDeSuivieRepository.findById(id);
    }
    @Override
    public FicheDeSuivie save(FicheDeSuivie ficheDeSuivie) {
        return ficheDeSuivieRepository.save(ficheDeSuivie);
    }

    @Override
    public FicheDeSuivie update(FicheDeSuivie ficheDeSuivie) {
        return ficheDeSuivieRepository.save(ficheDeSuivie);
    }

    @Override
    public void deleteById(Long id) {
        ficheDeSuivieRepository.deleteById(id);
    }
}
