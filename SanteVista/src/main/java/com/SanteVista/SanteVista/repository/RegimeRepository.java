package com.SanteVista.SanteVista.repository;

import com.SanteVista.SanteVista.domain.Regime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegimeRepository extends JpaRepository<Regime,Long> {
    List<Regime> findByUserIdAndStatus(String userId,boolean status);
}
