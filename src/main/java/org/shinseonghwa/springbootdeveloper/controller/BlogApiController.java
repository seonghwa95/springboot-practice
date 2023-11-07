package org.shinseonghwa.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.Article;
import org.shinseonghwa.springbootdeveloper.dto.AddArticleRequest;
import org.shinseonghwa.springbootdeveloper.dto.ArticleResponse;
import org.shinseonghwa.springbootdeveloper.dto.UpdateArticleRequest;
import org.shinseonghwa.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController     // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RequiredArgsConstructor
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST이면서 전달받은 URL과 동일하면 매핑
    // RequestBody로 요청 본문 값과 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        Article savedArticle = blogService.save(request, principal.getName());

        // 요청한 자원이 성공적으로 생성되었을 때, 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }

//    응답 코드 메모
//    200 OK => 요청이 성공적으로 수행됨
//    201 Created => 요청이 성공적으로 수행되고, 새로운 리소스가 생성됨
//    400 Bad Request => 요청 값이 잘못되어 요청에 실패했음
//    403 Forbidden => 권한이 없어 요청에 실패했음
//    404 Not Foound => 요청 값으로 찾은 리소스가 없어 요청에 실패했음
//    500 Internal Server Error => 서버 상에 문제가 있어 요청에 실패했음
}
