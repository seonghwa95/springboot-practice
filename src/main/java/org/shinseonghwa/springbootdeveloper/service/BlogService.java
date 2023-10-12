package org.shinseonghwa.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.shinseonghwa.springbootdeveloper.domain.Article;
import org.shinseonghwa.springbootdeveloper.dto.AddArticleRequest;
import org.shinseonghwa.springbootdeveloper.dto.UpdateArticleRequest;
import org.shinseonghwa.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity());
    }

    // 블로그 글 목록 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 블로그 글 조회 메서드
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // 블로그 글 삭제 메서드
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정 메서드
    @Transactional  // 트랜잭션 -> 엔티티의 필드값의 제대로된 수정을 보장함
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}