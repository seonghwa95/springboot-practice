package org.shinseonghwa.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.Article;
import org.shinseonghwa.springbootdeveloper.dto.AddArticleRequest;
import org.shinseonghwa.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController     // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RequiredArgsConstructor
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST이면서 전달받은 URL과 동일하면 매핑
    // RequestBody로 요청 본문 값과 매핑
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었을 때, 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
