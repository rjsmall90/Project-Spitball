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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@RestController
@RequestMapping("user_profile")
@CrossOrigin(origins = "http://localhost:8100")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   //public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/find_user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam (name = "user_id", required = true) Long userId) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(userService.find(userId), new HttpHeaders(), httpStatus);
    }

    @RequestMapping(value = "/register_user", method = RequestMethod.POST)
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        HttpStatus status = HttpStatus.CONFLICT;
        if (userService.findEmail(newUser.getEmail()) == null) {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            newUser = userService.save(newUser);
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(newUser, new HttpHeaders(), status);
    }

    @RequestMapping(value = "/delete_profile", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteMessage(@RequestBody User user) {
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
