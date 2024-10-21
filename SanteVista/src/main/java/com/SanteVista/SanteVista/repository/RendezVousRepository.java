package com.SanteVista.SanteVista.repository;

import com.SanteVista.SanteVista.domain.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    List<RendezVous> findAllByUserId(String userId);
}
