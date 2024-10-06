package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.Regime;
import com.SanteVista.SanteVista.repository.RegimeRepository;
import com.SanteVista.SanteVista.service.IRegimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegimeImp implements IRegimeService {
    private final RegimeRepository regimeRepository;
    @Override
    public List<Regime> findAll() {
        return regimeRepository.findAll();
    }

    @Override
    public Optional<Regime> findById(Long id) {
        return regimeRepository.findById(id);
    }

    @Override
    public Regime save(Regime regime) {
        return regimeRepository.save(regime);
    }

    @Override
    public Regime update(Regime regime) {
        return regimeRepository.save(regime);
    }

    @Override
    public void deleteById(Long id) {
regimeRepository.deleteById(id);
    }
    @Override
    public List<Regime> getRegimesByUserIdAndStatus(String userId, boolean status) {
        System.out.println("status"+status);
        return regimeRepository.findByUserIdAndStatus(userId,status);

    }
    @Override
    public Regime toggleStatus(Long id) {
        Optional<Regime> optionalRegime = regimeRepository.findById(id);
        if (optionalRegime.isPresent()) {
            Regime regime = optionalRegime.get();
            regime.setStatus(false);
            return regimeRepository.save(regime);
        }
        throw new ResourceNotFoundException("Regime not found with id " + id);
    }
}
