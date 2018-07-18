package com.passionproject.project_spitball20.service;

import com.passionproject.project_spitball20.model.Rating;
import com.passionproject.project_spitball20.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {


    @Autowired
    RatingRepository ratingRepository;

    public Rating save(Rating rating) {
        return ratingRepository.saveAndFlush(rating);
    }

    public Rating update(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void delete(Rating rating) {
        ratingRepository.delete(rating);
    }

    public Rating find(Long id) {
        return ratingRepository.findById(id).get();
    }


}
