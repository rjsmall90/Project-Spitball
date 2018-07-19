package com.passionproject.project_spitball20.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passionproject.project_spitball20.model.Rating;
import com.passionproject.project_spitball20.model.messages.Review;
import com.passionproject.project_spitball20.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratings")
@CrossOrigin(origins = "http://localhost:8100")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    public ResponseEntity<Rating> newRating(@RequestBody Rating newRating) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        Rating rate = this.ratingService.save(newRating);

        return new ResponseEntity<>(rate, new HttpHeaders(), httpStatus);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Rating> deleteRating(@RequestBody Rating rating) {
        ratingService.delete(rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        rating = this.ratingService.update(rating);

        return new ResponseEntity<>(rating, new HttpHeaders(), httpStatus);
    }

    @RequestMapping(value = "/get_all_ratings", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRatings() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpStatus httpStatus = HttpStatus.CREATED;
        HttpHeaders header = new HttpHeaders();

        String messageJSON = objectMapper.writeValueAsString(this.ratingService.getAllRatings());
        header.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(messageJSON, header, httpStatus);
    }

}
