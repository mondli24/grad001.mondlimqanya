package com.enviro.assessment.grad001.mondlimqanya.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip description cannot be blank")
    private String tip;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory category;

    // Constructors
    public RecyclingTip() {
    }

    public RecyclingTip(Long id, String tip, WasteCategory category) {
        this.id = id;
        this.tip = tip;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getCategory() {
        return category;
    }

    public void setCategory(WasteCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", category=" + category +
                '}';
    }
}

