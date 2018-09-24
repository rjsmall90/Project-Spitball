package com.passionproject.project_spitball20.repositories.messages;


import com.passionproject.project_spitball20.model.messages.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
