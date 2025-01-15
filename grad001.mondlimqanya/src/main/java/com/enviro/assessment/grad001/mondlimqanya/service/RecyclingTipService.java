package com.enviro.assessment.grad001.mondlimqanya.service;

import com.enviro.assessment.grad001.mondlimqanya.model.RecyclingTip;
import com.enviro.assessment.grad001.mondlimqanya.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    // Create or Save a RecyclingTip
    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    // Retrieve All RecyclingTips
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    // Retrieve a Single RecyclingTip by ID
    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id);
    }

    // Update a RecyclingTip
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        return recyclingTipRepository.findById(id)
                .map(existingTip -> {
                    existingTip.setTip(updatedTip.getTip());
                    existingTip.setCategory(updatedTip.getCategory());
                    return recyclingTipRepository.save(existingTip);
                })
                .orElseThrow(() -> new RuntimeException("RecyclingTip not found"));
    }

    // Delete a RecyclingTip
    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}

