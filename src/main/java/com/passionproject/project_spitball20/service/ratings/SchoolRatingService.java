//package com.passionproject.project_spitball20.service;
//
//import com.passionproject.project_spitball20.model.Rating;
//import com.passionproject.project_spitball20.model.ratings.SchoolRating;
//import com.passionproject.project_spitball20.model.Teacher;
//import com.passionproject.project_spitball20.repositories.RatingRepository;
//import com.passionproject.project_spitball20.repositories.SchoolRatingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SchoolRatingService {
//
//
//    @Autowired
//    SchoolRatingRepository schoolRatingRepository;
//
//    public SchoolRating save(SchoolRating rating) {
//        return schoolRatingRepository.saveAndFlush(rating);
//    }
//
//    public SchoolRating update(SchoolRating rating) {
//        return schoolRatingRepository.save(rating);
//    }
//
//    public void delete(SchoolRating rating) {
//        schoolRatingRepository.delete(rating);
//    }
//
//    public SchoolRating find(Long id) {
//        return schoolRatingRepository.findById(id).get();
//    }
//
//    public List<SchoolRating> getAllTeachers(SchoolRating teacherId) { return schoolRatingRepository.findAllById(teacherId.getTeacherId());s }
//
//    public Object getAllRatings() { return schoolRatingRepository.findAll(); }
//
//}
