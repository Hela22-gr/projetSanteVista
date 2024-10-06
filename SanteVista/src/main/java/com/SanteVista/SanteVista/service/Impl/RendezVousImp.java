package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.RendezVous;
import com.SanteVista.SanteVista.repository.RendezVousRepository;
import com.SanteVista.SanteVista.service.IRendezVousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RendezVousImp implements IRendezVousService {
    private final RendezVousRepository rendezVousRepository;


    @Override
    public List<RendezVous> findAll() {
        return rendezVousRepository.findAll();
    }

    @Override
    public List<RendezVous> findAllByUserId(String userId) {
        return rendezVousRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<RendezVous> findById(Long id) {
        return rendezVousRepository.findById(id);
    }

    @Override
    public RendezVous save(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous update(Long id) {
        RendezVous rendezVous=rendezVousRepository.findById(id).get();
        rendezVous.setAccepted(true);
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous update(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleteById(Long id) {
rendezVousRepository.deleteById(id);
    }
}
