package com.passionproject.project_spitball20.controller.school;

import com.passionproject.project_spitball20.model.School;
import com.passionproject.project_spitball20.model.messages.Comment;
import com.passionproject.project_spitball20.model.messages.Review;
import com.passionproject.project_spitball20.repositories.SchoolRepository;
import com.passionproject.project_spitball20.repositories.messages.CommentRepository;
import com.passionproject.project_spitball20.service.messages.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bulletin_board")
@CrossOrigin(origins = "http://localhost:8100")
public class SchoolWallController {

    @Autowired
    SchoolRepository schoolRepo;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<?> postToBoard(@RequestBody School newSchool) {
        School school = new School();
        HttpStatus status = HttpStatus.CONFLICT;
        if(schoolRepo.findByName(school.getName()) == null) {
            school = schoolRepo.saveAndFlush(newSchool);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(school, new HttpHeaders(), status);
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deletePost(@RequestBody Review review) {
//        reviewService.delete(review);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @RequestMapping(value = "/post_comment", method = RequestMethod.POST)
    public ResponseEntity<?> postReview(@RequestBody Comment newComment) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        Comment comment  = commentService.save(newComment);

        return new ResponseEntity<>(comment, new HttpHeaders(), httpStatus);
    }


    @RequestMapping(value = "/delete_comment", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteComment(@RequestBody Comment comment) {
        commentService.delete(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}