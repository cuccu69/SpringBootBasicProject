package com.thecukcoobird.blog.controller;

import com.thecukcoobird.blog.model.Post;
import com.thecukcoobird.blog.model.User;
import com.thecukcoobird.blog.repository.PostRepository;
import com.thecukcoobird.blog.repository.UserRepository;
import com.thecukcoobird.blog.service.PostServiceImpl;
import com.thecukcoobird.blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    PostServiceImpl postService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("allPosts", postService.getAllPost());

        return Route.HOME_PAGE;
    }
}
