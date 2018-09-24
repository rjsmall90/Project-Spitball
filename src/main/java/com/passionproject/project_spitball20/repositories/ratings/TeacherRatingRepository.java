package com.passionproject.project_spitball20.repositories.ratings;

import com.passionproject.project_spitball20.model.ratings.TeacherRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRatingRepository extends JpaRepository<TeacherRating, Long> {
}
