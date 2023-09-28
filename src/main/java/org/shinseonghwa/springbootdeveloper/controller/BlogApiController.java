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
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        // 요청한 자원이 성공적으로 생성되었을 때, 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
    
//    응답 코드 메모
//    200 OK => 요청이 성공적으로 수행됨
//    201 Created => 요청이 성공적으로 수행되고, 새로운 리소스가 생성됨
//    400 Bad Request => 요청 값이 잘못되어 요청에 실패했음
//    403 Forbidden => 권한이 없어 요청에 실패했음
//    404 Not Foound => 요청 값으로 찾은 리소스가 없어 요청에 실패했음
//    500 Internal Server Error => 서버 상에 문제가 있어 요청에 실패했음
}
