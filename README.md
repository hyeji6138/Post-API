# 게시글 API
게시글 조회, 생성, 수정, 삭제할 수 있는 API를 구현한다.
## 기술 스택
```Spring Boot```, ```JPA```, ```H2 Database```, ```Swagger```, ```thymeleaf```
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
## 화면 UI
thymeleaf를 사용해서 게시글 페이지 UI를 구현하고 API 동작을 확인한다.
### 게시글 목록 페이지
<img width="1918" height="906" alt="게시글목록" src="https://github.com/user-attachments/assets/c694444f-652b-40ff-bceb-2f6f9f480b81" />

### 게시글 생성 페이지
<img width="1918" height="902" alt="게시글추가" src="https://github.com/user-attachments/assets/720fd501-d859-4ac5-95cb-a08a64865bf8" />

### 게시글 상세 페이지
<img width="1918" height="905" alt="게시글상세" src="https://github.com/user-attachments/assets/97a4ed02-1179-4e56-a90e-cc7be3df0ebc" />

