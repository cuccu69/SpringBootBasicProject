package com.thecukcoobird.blog.service;

import com.thecukcoobird.blog.model.Post;
import com.thecukcoobird.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    PostRepository postRepo;

    public List<Post> getAllPost(){
        return postRepo.findAll();
    }
    public void savePost(Post post){
        postRepo.save(post);
    }
    public Optional<Post> findPostById(int id){
        return postRepo.findById(id);
    }
    public void deletePost(int postId){
        Post post = postRepo.findById(postId).get();
        postRepo.delete(post);
    }
}
