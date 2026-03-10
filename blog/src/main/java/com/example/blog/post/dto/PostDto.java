package com.example.blog.post.dto;

import java.time.LocalDateTime;

import com.example.blog.post.PostEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    @Schema(description="게시글 번호")
    private Long id;
    @Schema(description="게시글 제목")
    private String title;
    @Schema(description="게시글 내용")
    private String content;
    @Schema(description="게시글 생성 시간")
    private LocalDateTime createdAt;
    @Schema(description="게시글 수정 시간")
    private LocalDateTime updatedAt;

    @Builder
    public PostDto(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static PostDto from(PostEntity entity){
        return PostDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt()).build();
    }
}
