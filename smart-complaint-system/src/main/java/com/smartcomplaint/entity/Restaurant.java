package com.smartcomplaint.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double averageRating;

    private Integer totalReviews;

    private Boolean problematic;

    private String status;

    private Double lastRating;

    private String description;

    public Restaurant() {}

    // GETTERS

    public Long getId() { return id; }

    public String getName() { return name; }

    public Double getAverageRating() { return averageRating; }

    public Integer getTotalReviews() { return totalReviews; }

    public Boolean getProblematic() { return problematic; }

    public String getStatus() { return status; }

    public Double getLastRating() { return lastRating; }

    // 👇 FALTAVA ESSE
    public String getDescription() { return description; }

    // SETTERS

    public void setName(String name) { this.name = name; }

    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }

    public void setTotalReviews(Integer totalReviews) { this.totalReviews = totalReviews; }

    public void setProblematic(Boolean problematic) { this.problematic = problematic; }

    public void setStatus(String status) { this.status = status; }

    public void setLastRating(Double lastRating) { this.lastRating = lastRating; }

    // 👇 FALTAVA ESSE
    public void setDescription(String description) { this.description = description; }
}