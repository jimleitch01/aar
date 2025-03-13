package com.example.aar.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Abduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime time;
    private String place;
    private String details;

    @Lob
    private byte[] photograph;

    @Lob
    private byte[] alienCraftImage;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public byte[] getPhotograph() {
        return photograph;
    }

    public void setPhotograph(byte[] photograph) {
        this.photograph = photograph;
    }

    public byte[] getAlienCraftImage() {
        return alienCraftImage;
    }

    public void setAlienCraftImage(byte[] alienCraftImage) {
        this.alienCraftImage = alienCraftImage;
    }
}
