package com.passionproject.project_spitball20.service.ratings;

import com.passionproject.project_spitball20.model.ratings.TeacherRating;
import com.passionproject.project_spitball20.repositories.ratings.TeacherRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherRatingService {


    @Autowired
    TeacherRatingRepository ratingRepository;

    public TeacherRating save(TeacherRating rating) {
        return ratingRepository.saveAndFlush(rating);
    }

    public TeacherRating update(TeacherRating rating) {
        return ratingRepository.save(rating);
    }

    public void delete(TeacherRating rating) {
        ratingRepository.delete(rating);
    }

//    public TeacherRating find(Long id) {
//        return ratingRepository.findById(id).get();
//    }

    public Object getAllRatings() { return ratingRepository.findAll(); }

}
