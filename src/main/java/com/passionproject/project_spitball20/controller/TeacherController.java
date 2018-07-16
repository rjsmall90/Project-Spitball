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

@CrossOrigin
@RestController
@RequestMapping("teacher_profile")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Teacher> registerUser(@RequestBody Teacher newTeacher) {
        Teacher teacher = new Teacher();
        HttpStatus status = HttpStatus.CONFLICT;
        if(teacherService.findEmail(newTeacher.getEmail()).equals(null)){ //&& teacherService.findName(newTeacher.getFullName()).equals(null)) {
            teacher = teacherService.save(newTeacher);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(teacher, new HttpHeaders(), status);

    }

}
