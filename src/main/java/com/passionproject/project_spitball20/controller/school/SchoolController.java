package com.passionproject.project_spitball20.controller.school;

import com.passionproject.project_spitball20.model.School;
import com.passionproject.project_spitball20.model.Teacher;
import com.passionproject.project_spitball20.repositories.SchoolRepository;
import com.passionproject.project_spitball20.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schools")
@CrossOrigin(origins = "http://localhost:8100")
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepo;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<School> postReview(@RequestBody School newSchool) {
        School school = new School();
        HttpStatus status = HttpStatus.CONFLICT;
        if(schoolRepo.findByName(school.getName()) == null) {
            school = schoolRepo.saveAndFlush(newSchool);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(school, new HttpHeaders(), status);
    }

    @RequestMapping(value = "/getAll_Teacher", method = RequestMethod.HEAD)
    public ResponseEntity<?> getAllTeachers(Long id) {
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(teacherService.findAllBySchool(id), new HttpHeaders(), status);
    }

    @RequestMapping(value = "/select_teacher", method = RequestMethod.GET)
    public ResponseEntity<?> findTeachersBySchoolId(Long id) {
        Teacher teacher = new Teacher();
        HttpStatus status = HttpStatus.OK;
        if(id == teacher.getSchoolId()) { teacher = teacherService.find(teacher.getSchoolId()); }
        return new ResponseEntity<>(teacher , new HttpHeaders(), status);
    }


}
