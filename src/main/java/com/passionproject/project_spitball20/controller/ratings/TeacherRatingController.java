package com.passionproject.project_spitball20.controller.ratings;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.passionproject.project_spitball20.model.ratings.TeacherRating;
import com.passionproject.project_spitball20.service.ratings.TeacherRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ratings")
@CrossOrigin(origins = "http://localhost:8100")
public class TeacherRatingController {

    @Autowired
    TeacherRatingService ratingService;

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    public ResponseEntity<TeacherRating> newRating(@RequestBody TeacherRating newRating) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        TeacherRating rate = this.ratingService.save(newRating);

        return new ResponseEntity<>(rate, new HttpHeaders(), httpStatus);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<TeacherRating> deleteRating(@RequestBody TeacherRating rating) {
        ratingService.delete(rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<TeacherRating> updateRating(@RequestBody TeacherRating rating) {
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
