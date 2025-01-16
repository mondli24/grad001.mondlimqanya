package com.enviro.assessment.grad001.mondlimqanya.service;

import com.enviro.assessment.grad001.mondlimqanya.model.DisposalGuideline;
import com.enviro.assessment.grad001.mondlimqanya.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    // Save a DisposalGuideline
    public DisposalGuideline saveDisposalGuideline(DisposalGuideline disposalGuideline) {
        return disposalGuidelineRepository.save(disposalGuideline);
    }

    // Retrieve All DisposalGuidelines
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return disposalGuidelineRepository.findAll();
    }

    // Retrieve a Single DisposalGuideline by ID
    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    // Update a DisposalGuideline
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline updatedGuideline) {
        return disposalGuidelineRepository.findById(id)
                .map(existingGuideline -> {
                    existingGuideline.setMaterial(updatedGuideline.getMaterial());
                    existingGuideline.setGuideline(updatedGuideline.getGuideline());
                    existingGuideline.setCategory(updatedGuideline.getCategory());
                    return disposalGuidelineRepository.save(existingGuideline);
                })
                .orElseThrow(() -> new RuntimeException("DisposalGuideline not found"));
    }

    // Delete a DisposalGuideline
    public void deleteDisposalGuideline(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
