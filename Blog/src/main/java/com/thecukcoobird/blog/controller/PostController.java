package com.thecukcoobird.blog.controller;

import com.thecukcoobird.blog.controller.request.CommentDTO;
import com.thecukcoobird.blog.model.Post;
import com.thecukcoobird.blog.model.User;
import com.thecukcoobird.blog.model.exception.NotFoundException;
import com.thecukcoobird.blog.controller.request.PostRequest;
import com.thecukcoobird.blog.repository.PostRepository;
import com.thecukcoobird.blog.service.PostServiceImpl;
import com.thecukcoobird.blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/addpost")
    public String addPost(Model model){
        model.addAttribute("postRequest", new PostRequest());

        return Route.ADD_POST;
    }

    @PostMapping("/post/save")
    public String savePost(@ModelAttribute PostRequest postRequest, Model model){
        User user = userService.findUserByEmail(postRequest.getEmail());
        if (user != null){
            Post newPost = new Post();
            postRequest.coverPostRequestToPost(newPost);
            newPost.setAuthor(userService.findUserByEmail(postRequest.getEmail()));

            user.getListPost().add(newPost);
            postService.savePost(newPost);
            return "redirect:/";
        } else {
            throw new NotFoundException("email doesn't exit");
//            return "redirect:/";
        }
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable int id, Model model){
        Optional<Post> post = postService.findPostById(id);

        if (post.isPresent()){
            CommentDTO cmtDTO = new CommentDTO();
            cmtDTO.setPostId(id);
            model.addAttribute("post", post.get());
            model.addAttribute("commentRequest", cmtDTO);
            model.addAttribute("comments", post.get().getListComment());
        }else {
            throw new NotFoundException("Post doesn't exist");
        }

        return Route.POST;
    }

    @GetMapping("post/{id}/delete")
    public String deletePost(@PathVariable(name = "id") int postId){
        postService.deletePost(postId);
        return "redirect:/";
    }

    @GetMapping("/post/{id}/edit")
    public String viewEdit(@PathVariable(name = "id")  int postId, Model model){
        PostRequest postRequest = new PostRequest();
        postRequest.setPostId(postId);

        model.addAttribute("postRequest", postRequest);
        return "edit_post";
    }
    @PostMapping("/post/edit")
    public String editPost(@ModelAttribute PostRequest postRequest, Model model){
        Post post = postService.findPostById(postRequest.getPostId()).get();
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());

        postService.updatePost();

        return "redirect:/post/" + postRequest.getPostId();
    }
}
