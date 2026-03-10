# 게시글 API
게시글 조회, 생성, 수정, 삭제할 수 있는 API를 구현한다.
## 기술 스택
```Spring Boot```, ```JPA```, ```H2 Database```, ```Swagger```
## API 목록
1. [POST] 게시글 작성 (/post)
2. [GET] 게시글 조회
   - 목록 전체 조회 (/post)
   - 게시글 상세 조회 (/post/{id})
4. [PUT] 게시글 수정 (/post/{id})
5. [DELETE] 게시글 삭제 (/post/{id})
## 프로젝트 구조
```
post
 ├ PostController
 ├ PostService
 ├ PostRepository
 ├ PostEntity
 └ dto
  ├ PostDto
  └ PostResponse
```
