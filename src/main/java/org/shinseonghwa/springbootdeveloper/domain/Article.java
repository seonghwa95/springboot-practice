package org.shinseonghwa.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // 빌더 패턴
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 기본 생성자
    public Article() {

    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
