package com.passionproject.project_spitball20.repositories.messages;


import com.passionproject.project_spitball20.model.messages.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
