package com.passionproject.project_spitball20.repositories;

import com.passionproject.project_spitball20.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByEmail(String email);

    List<Teacher> findAllBySchoolId(Long id);

    //Teacher findByName(String fullName);
}
