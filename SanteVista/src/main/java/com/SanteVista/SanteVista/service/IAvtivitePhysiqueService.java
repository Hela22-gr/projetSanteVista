package com.SanteVista.SanteVista.service;

import com.SanteVista.SanteVista.domain.ActivitePhysique;

import java.util.List;
import java.util.Optional;

public interface IAvtivitePhysiqueService {
    List<ActivitePhysique> findAll();
    Optional<ActivitePhysique> findById(Long id);

    ActivitePhysique save(ActivitePhysique activitePhysique);

    ActivitePhysique update(ActivitePhysique activitePhysique);

    void deleteById(Long id);

    List<ActivitePhysique> getActivitesByUserId(String userId);
}
