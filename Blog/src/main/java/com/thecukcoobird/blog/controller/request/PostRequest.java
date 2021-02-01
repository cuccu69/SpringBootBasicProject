package com.thecukcoobird.blog.controller.request;

import com.thecukcoobird.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private String title;
    private String content;
    private String email;

    public Post coverPostRequestToPost(Post post){
        post.setTitle(this.getTitle());
        post.setContent(this.getContent());
        return post;
    }
}
