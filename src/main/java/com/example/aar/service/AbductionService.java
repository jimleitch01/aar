package com.example.aar.service;

import com.example.aar.model.Abduction;
import com.example.aar.repository.AbductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AbductionService {

    @Autowired
    private AbductionRepository abductionRepository;

    public void saveAbduction(String name, String time, String place, String details, MultipartFile photograph, MultipartFile alienCraftImage) throws IOException {
        Abduction abduction = new Abduction();
        abduction.setName(name);
        abduction.setTime(LocalDateTime.parse(time));
        abduction.setPlace(place);
        abduction.setDetails(details);
        abduction.setPhotograph(photograph.getBytes());
        abduction.setAlienCraftImage(alienCraftImage.getBytes());

        abductionRepository.save(abduction);
    }

    public List<Abduction> getAllAbductions() {
        return abductionRepository.findAll();
    }

    public Abduction getAbductionById(Long id) {
        return abductionRepository.findById(id).orElse(null);
    }
}
