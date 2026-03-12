package com.example.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.post.PostService;
import com.example.blog.post.dto.PostDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@Controller
public class PageController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String moveToPosts(@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<PostDto> posts = postService.getPosts(pageable);
        model.addAttribute("posts", posts);
        return "/post/list";
    }

    @GetMapping("/post/add")
    public String moveToAddPost() {
        return "/post/add";
    }

    @GetMapping("/post/{id}")
    public String moveToPostDetail(@PathVariable("id") Long id, Model model) {
        PostDto post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "/post/detail";
    }

    @PostMapping("/post/add")
    public String addPost(@RequestBody PostDto postDto, Model model) {
        postService.registerPost(postDto);
        return "redirect:/post";
    }

    @GetMapping("/post/delete/{id}")
    public String getMethodName(@PathVariable("id") Long id, Model model) {
        postService.deletePost(id);
        return "redirect:/post";
    }
    
}
