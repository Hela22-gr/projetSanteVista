package com.SanteVista.SanteVista.repository;


import com.SanteVista.SanteVista.domain.Analyse;
import com.SanteVista.SanteVista.domain.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
    List<Analyse> findAllByUserId(String userId);
}
