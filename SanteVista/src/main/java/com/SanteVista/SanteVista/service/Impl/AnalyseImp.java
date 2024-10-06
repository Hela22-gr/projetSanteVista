package com.SanteVista.SanteVista.service.Impl;

import com.SanteVista.SanteVista.domain.Analyse;
import com.SanteVista.SanteVista.repository.AnalyseRepository;
import com.SanteVista.SanteVista.service.IAnalyseService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnalyseImp implements IAnalyseService {
    private final AnalyseRepository analyseRepository;
    private final Cloudinary cloudinary;



//    public Map delete(String publicId) throws IOException {
//        return cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
//    }
    @Override
    public Analyse save(Analyse analyse,MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");
            analyse.setImageUrl(imageUrl);

        }
        return analyseRepository.save(analyse);
    }
    @Override
    public List<Analyse> findAll() {
        return analyseRepository.findAll();
    }

    @Override
    public List<Analyse> findAllByUserId(String userId) {
        return analyseRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<Analyse> findById(Long id) {
        return analyseRepository.findById(id);
    }


    @Override
    public Analyse update(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    @Override
    public void deleteById(Long id) {
        analyseRepository.deleteById(id);
    }
}
