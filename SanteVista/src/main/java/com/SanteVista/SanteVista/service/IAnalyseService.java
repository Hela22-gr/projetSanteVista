package com.SanteVista.SanteVista.service;

import com.SanteVista.SanteVista.domain.ActivitePhysique;
import com.SanteVista.SanteVista.domain.Analyse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IAnalyseService {
    List<Analyse> findAll();
    List<Analyse> findAllByUserId(String userId);

    Optional<Analyse> findById(Long id);

    Analyse save(Analyse analyse, MultipartFile file) throws IOException;

    Analyse update(Analyse activitePhysique);

    void deleteById(Long id);
}
