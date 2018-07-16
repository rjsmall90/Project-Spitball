package com.passionproject.project_spitball20.controller;

import com.passionproject.project_spitball20.model.User;
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
@RequestMapping("user_profile")
public class UserController {

    @Autowired
    UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        User user = new User();
        HttpStatus status = HttpStatus.CONFLICT;
        if(userService.findEmail(newUser.getEmail()).equals(null)) { //&& userService.findName(newUser.getDisplayName()).equals(null)) {
            user = userService.save(newUser);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(user, new HttpHeaders(), status);

    }
}
