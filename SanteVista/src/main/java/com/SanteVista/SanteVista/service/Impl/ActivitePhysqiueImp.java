package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.ActivitePhysique;
import com.SanteVista.SanteVista.repository.ActivitePhysiqueRepository;
import com.SanteVista.SanteVista.service.IAvtivitePhysiqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivitePhysqiueImp implements IAvtivitePhysiqueService {
    private final ActivitePhysiqueRepository activitePhysiqueRepository;
    @Override
    public List<ActivitePhysique> findAll() {

        return activitePhysiqueRepository.findAll();
    }
    @Override
    public Optional<ActivitePhysique> findById(Long id) {
        return activitePhysiqueRepository.findById(id);
    }

    @Override
    public ActivitePhysique save(ActivitePhysique activitePhysique) {
        return activitePhysiqueRepository.save(activitePhysique);
    }

    @Override
    public ActivitePhysique update(ActivitePhysique activitePhysique) {
        return activitePhysiqueRepository.save(activitePhysique);
    }

    @Override
    public void deleteById(Long id) {
        activitePhysiqueRepository.deleteById(id);
    }
    @Override
    public List<ActivitePhysique> getActivitesByUserId(String userId) {
        return activitePhysiqueRepository.findByUserId(userId);
    }
}
