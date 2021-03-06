package com.passionproject.project_spitball20.repositories;

import com.passionproject.project_spitball20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findByUsername(String username);

   User findByEmail(String email);

   //User findByName(String fullName);

}
