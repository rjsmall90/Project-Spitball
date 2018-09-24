package com.passionproject.project_spitball20.repositories;

        import com.passionproject.project_spitball20.model.School;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

    School findByName(String name);
}
