package com.enviro.assessment.grad001.mondlimqanya.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Material cannot be blank")
    private String material;

    @NotBlank(message = "Guideline cannot be blank")
    private String guideline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;


    // Constructors
    public DisposalGuideline() {
    }

    public DisposalGuideline(Long id, String material, String guideline, WasteCategory category) {
        this.id = id;
        this.material = material;
        this.guideline = guideline;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "DisposalGuideline{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", guideline='" + guideline + '\'' +
                ", category=" + category +
                '}';
    }
}

