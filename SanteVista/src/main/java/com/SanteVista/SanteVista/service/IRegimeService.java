package com.SanteVista.SanteVista.service;

import com.SanteVista.SanteVista.domain.Regime;

import java.util.List;
import java.util.Optional;

public interface IRegimeService {
    List<Regime> findAll();
    Optional<Regime> findById(Long id);
    Regime save(Regime regime);
    Regime update(Regime regime);
    void deleteById(Long id);



    List<Regime> getRegimesByUserIdAndStatus(String userId, boolean status);

    Regime toggleStatus(Long id);
}
