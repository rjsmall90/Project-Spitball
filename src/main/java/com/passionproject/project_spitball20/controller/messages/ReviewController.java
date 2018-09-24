package com.passionproject.project_spitball20.controller.messages;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passionproject.project_spitball20.model.messages.Review;
import com.passionproject.project_spitball20.service.messages.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<Review> postReview(@RequestBody Review newReview) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        Review content = this.reviewService.save(newReview);

        return new ResponseEntity<>(content, new HttpHeaders(), httpStatus);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        review = this.reviewService.update(review);

        return new ResponseEntity<>(review, new HttpHeaders(), httpStatus);
    }

    @RequestMapping(value = "/get_reviews", method = RequestMethod.GET)
    public ResponseEntity<?> getAllReviews() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpStatus httpStatus = HttpStatus.CREATED;
        HttpHeaders header = new HttpHeaders();

        String messageJSON = objectMapper.writeValueAsString(this.reviewService.getAllReviews());
        header.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(messageJSON, header, httpStatus);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@RequestBody Review review) {
        reviewService.delete(review);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
