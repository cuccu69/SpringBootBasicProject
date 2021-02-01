package com.thecukcoobird.blog.controller;

import com.thecukcoobird.blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("allPosts", postService.getAllPost());

        return Route.HOME_PAGE;
    }
}
