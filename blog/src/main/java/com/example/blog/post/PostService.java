package com.example.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.post.dto.PostDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public boolean registerPost(PostDto post){ // 글 작성
        PostEntity postEntity = new PostEntity(post.getTitle(), post.getContent());
        postRepository.save(postEntity);
        return true;
    }

    public Page<PostDto> getPosts(Pageable pageable){ // 글 목록 조회
        Page<PostEntity> posts = postRepository.findAll(pageable);
        return posts.map(PostDto::from);
    }

    public PostDto getPostById(Long id){ // 글 상세 조회
        PostEntity post = postRepository.getById(id);
        return PostDto.from(post);
    }

    @Transactional
    public boolean updatePost(Long id, PostDto post){ // 글 수정
        PostEntity prevPost = postRepository.getById(id);
        prevPost.update(post.getTitle(), post.getContent());
        return true;
    }

    public boolean deletePost(Long id){ // 글 삭제
        postRepository.deleteById(id);
        return true;
    }
}
