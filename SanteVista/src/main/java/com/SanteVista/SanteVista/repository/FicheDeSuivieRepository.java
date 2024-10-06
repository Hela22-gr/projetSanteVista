package com.SanteVista.SanteVista.repository;

import com.SanteVista.SanteVista.domain.FicheDeSuivie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheDeSuivieRepository extends JpaRepository<FicheDeSuivie, Long> {
}
