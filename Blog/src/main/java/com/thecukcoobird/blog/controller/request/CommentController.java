package com.thecukcoobird.blog.controller.request;

import com.thecukcoobird.blog.model.Comment;
import com.thecukcoobird.blog.model.DTO.CommentDTO;
import com.thecukcoobird.blog.model.Post;
import com.thecukcoobird.blog.service.CommentServiceImpl;
import com.thecukcoobird.blog.service.PostServiceImpl;
import com.thecukcoobird.blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    PostServiceImpl postService;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/comment/save")
    public String saveCommnent(@ModelAttribute CommentDTO commentDTO, Model model) {
        Post postWorking = postService.findPostById(commentDTO.getPostId()).get();

        if (postWorking != null) {
            Comment comment = new Comment();
            comment.setContent(commentDTO.getContent());
            comment.setPost(postWorking);

            postWorking.getListComment().add(comment);
            commentService.saveComment(comment);
            return "redirect:/post/" + commentDTO.getPostId();
        }
        return "not_eixt";
    }
}
