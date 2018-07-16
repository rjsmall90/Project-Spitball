package com.passionproject.project_spitball20.repositories;

import com.passionproject.project_spitball20.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

     Teacher findByEmail(String email);

    Teacher findByName(String fullName);
}
