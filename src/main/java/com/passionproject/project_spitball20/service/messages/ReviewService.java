package com.passionproject.project_spitball20.service.messages;


import com.passionproject.project_spitball20.model.messages.Review;
import com.passionproject.project_spitball20.repositories.messages.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService {


    @Autowired
    ReviewRepository reviewRepository;


    public Review save(Review review) {
        review.setCreated(new Date());
        return reviewRepository.save(review);
    }

    public Review update(Review review) {
        Review update = reviewRepository.findById(review.getId()).get();
        update.setUpdated(new Date());
        update.setReview(review.getReview());
        return reviewRepository.save(update);

    }

    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }
}
