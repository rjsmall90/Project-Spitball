package com.passionproject.project_spitball20.controller;


import com.passionproject.project_spitball20.model.Teacher;
import com.passionproject.project_spitball20.model.User;
import com.passionproject.project_spitball20.service.TeacherService;
import com.passionproject.project_spitball20.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("teacher_profile")
@CrossOrigin(origins = "http://localhost:8100")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Teacher> registerUser(@RequestBody Teacher newTeacher) {
        Teacher teacher = new Teacher();
        HttpStatus status = HttpStatus.CONFLICT;
        if(teacherService.findEmail(newTeacher.getEmail()).equals(null)){
            teacher = teacherService.save(newTeacher);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(teacher, new HttpHeaders(), status);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Teacher> deleteRating(@RequestBody Teacher teacher) {
        teacherService.delete(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Teacher> updateRating(@RequestBody Teacher teacher) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        teacher = this.teacherService.update(teacher);

        return new ResponseEntity<>(teacher, new HttpHeaders(), httpStatus);
    }

}
