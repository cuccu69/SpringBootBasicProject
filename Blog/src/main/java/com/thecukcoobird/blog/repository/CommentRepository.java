package com.thecukcoobird.blog.repository;

import com.thecukcoobird.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
