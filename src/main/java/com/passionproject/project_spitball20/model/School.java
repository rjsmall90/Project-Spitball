package com.passionproject.project_spitball20.model;

import com.passionproject.project_spitball20.model.ratings.SchoolRating;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<SchoolRating> ratings;

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

    public List<SchoolRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<SchoolRating> ratings) {
        this.ratings = ratings;
    }
}
