package com.passionproject.project_spitball20.repositories;

import com.passionproject.project_spitball20.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
