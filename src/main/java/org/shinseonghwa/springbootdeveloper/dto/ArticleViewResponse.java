package org.shinseonghwa.springbootdeveloper.dto;

import lombok.Getter;
import org.shinseonghwa.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime created_at;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.created_at = article.getCreatedAt();
    }
}
