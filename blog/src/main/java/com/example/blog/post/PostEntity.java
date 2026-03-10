package com.example.blog.post;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="POST")
public class PostEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Schema(description="게시글 번호")
    private Long id;

    @Column(length=50, nullable=false)
    @Schema(description="게시글 제목")
    private String title;

    @Lob
    @Column(nullable=false)
    @Schema(description="게시글 내용")
    private String content;

    @Column(nullable=false, updatable=false)
    @Schema(description="게시글 생성 시간")
    private LocalDateTime createdAt;
    
    @Column(nullable=false)
    @Schema(description="게시글 수정 시간")
    private LocalDateTime updatedAt;
    
    public PostEntity(String title, String content){
        this.title = title;
        this.content = content;
    }
    
    @PrePersist
    public void onCreate() { // 생성 시
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt; 
    } 
    @PreUpdate
    public void onUpdate() { // 수정 시
        this.updatedAt = LocalDateTime.now(); 
    }

    public void update(String title, String content){ // 게시글 수정
        this.title = title;
        this.content = content;
    }
}


