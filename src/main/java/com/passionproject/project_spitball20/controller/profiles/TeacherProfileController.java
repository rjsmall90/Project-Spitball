package com.passionproject.project_spitball20.controller.profiles;


import com.passionproject.project_spitball20.model.Teacher;
import com.passionproject.project_spitball20.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("teachers")
@CrossOrigin(origins = "http://localhost:8100")
public class TeacherProfileController {

    @Autowired
    TeacherService teacherService;

    public static final Logger logger = LoggerFactory.getLogger(TeacherProfileController.class);


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher newTeacher) {
        Teacher teacher = new Teacher();
        HttpStatus status = HttpStatus.CONFLICT;
        if(teacherService.findEmail(newTeacher.getEmail()) == (null)){
            teacher = teacherService.save(newTeacher);
            status  = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(teacher, new HttpHeaders(), status);

    }

    @RequestMapping(value = "/find_all", method = RequestMethod.HEAD)
    public ResponseEntity<?> getAllTeachers() {
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(teacherService.findAll(), new HttpHeaders(), status);
    }

    @RequestMapping(value = "/find_teacher", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacher(@RequestBody Teacher teacher) {
        HttpStatus httpStatus = HttpStatus.OK;
        teacher = teacherService.find(teacher.getId());
        return new ResponseEntity<>(teacher, new HttpHeaders(), httpStatus);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Teacher> deleteTeacherProfile(@RequestBody Teacher teacher) {
        teacherService.delete(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Teacher> updateTeacherProfile(@RequestBody Teacher teacher) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        teacher = this.teacherService.update(teacher);

        return new ResponseEntity<>(teacher, new HttpHeaders(), httpStatus);
    }

}
