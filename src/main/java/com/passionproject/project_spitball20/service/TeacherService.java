package com.passionproject.project_spitball20.service;

import com.passionproject.project_spitball20.model.Teacher;
import com.passionproject.project_spitball20.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher find(Long id) {
        return teacherRepository.findById(id).get();
    }

//    public Teacher findName(String fullName) {
//        return teacherRepository.findByName(fullName);
//    }

    public Teacher findEmail(String email) {
        return teacherRepository.findByEmail(email);
    }


}
