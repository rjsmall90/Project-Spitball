package com.passionproject.project_spitball20.model.ratings;

import com.passionproject.project_spitball20.model.messages.Review;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
public class TeacherRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn
    Long teacherId;

    Integer rating;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
