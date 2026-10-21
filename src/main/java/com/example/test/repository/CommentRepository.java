package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test.model.entity.Comments;


public interface CommentRepository extends JpaRepository<Comments, Long> {
}
