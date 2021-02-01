package com.thecukcoobird.blog.service;

import com.thecukcoobird.blog.model.Comment;
import com.thecukcoobird.blog.model.Post;
import com.thecukcoobird.blog.repository.CommentRepository;
import com.thecukcoobird.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService{
    @Autowired
    CommentRepository commentRepo;
    @Autowired
    PostRepository postRepo;

    public void saveComment(Comment comment){
        commentRepo.save(comment);
    }

    public List<Comment> findCommentOfPost(int postId){
        Post post = postRepo.findById(postId).get();
        return post.getListComment();
    }
}
