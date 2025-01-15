package com.enviro.assessment.grad001.mondlimqanya.service;

import com.enviro.assessment.grad001.mondlimqanya.model.WasteCategory;
import com.enviro.assessment.grad001.mondlimqanya.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    // Create or Save a WasteCategory
    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    // Retrieve All WasteCategories
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    // Retrieve a Single WasteCategory by ID
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    // Update a WasteCategory
    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory) {
        return wasteCategoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(updatedCategory.getName());
                    existingCategory.setDescription(updatedCategory.getDescription());
                    existingCategory.setIsRecyclable(updatedCategory.getIsRecyclable());
                    return wasteCategoryRepository.save(existingCategory);
                })
                .orElseThrow(() -> new RuntimeException("WasteCategory not found"));
    }

    // Delete a WasteCategory
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
