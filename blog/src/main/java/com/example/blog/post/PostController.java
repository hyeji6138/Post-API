package com.example.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.post.dto.PostDto;
import com.example.blog.post.dto.PostResponse;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/posts")
@Slf4j
public class PostController {
    @Autowired
    private PostService postService;

    @Operation(summary = "게시글 상세 조회", description = "아이디로 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable("id") Long id) {
        PostResponse response = null;
        try {
           PostDto post = postService.getPostById(id);
            response = new PostResponse("success", post);
        } catch (Exception e) {
            response = new PostResponse<String>("fail", e.getMessage());
        }
        return response;
    }
    
    @Operation(summary = "게시글 목록 조회", description = "페이징을 사용하여 게시글 목록을 조회합니다.")
    @GetMapping
    public PostResponse getPosts(Pageable pageable) {
        PostResponse response = null;
        try {
            Page<PostDto> posts = postService.getPosts(pageable);
            response = new PostResponse("success", posts);
        } catch (Exception e) {
            response = new PostResponse("fail", e.getMessage());
        }
        return response;
    }

    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    @PostMapping
    public PostResponse registerPost(@RequestBody PostDto post) {
        PostResponse response = null;
        try {
            boolean status = postService.registerPost(post);
            response = new PostResponse("success", status);
        } catch (Exception e) {
            response = new PostResponse("fail", e.getMessage());
        }
        return response;
    }

    @Operation(summary = "게시글 수정", description = "기존 게시글을 수정합니다.")
    @PutMapping("/{id}")
    public PostResponse putPost(@PathVariable("id") Long id, @RequestBody PostDto post) {
        PostResponse response = null;
        try {
            boolean status = postService.updatePost(id, post);
            response = new PostResponse("success", status);
        } catch (Exception e) {
            response = new PostResponse("fail", e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public PostResponse deletePost(@PathVariable("id") Long id) {
        PostResponse response = null;
        try {
            boolean status = postService.deletePost(id);
            response = new PostResponse("success", status);
        } catch (Exception e) {
            response = new PostResponse("fail", e.getMessage());
        }
        return response;
    }
    
}
