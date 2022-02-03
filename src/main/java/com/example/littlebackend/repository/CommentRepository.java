package com.example.littlebackend.repository;

import com.example.littlebackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByComment(String comment);
}
