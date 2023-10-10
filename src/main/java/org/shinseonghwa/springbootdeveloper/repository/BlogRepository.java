package org.shinseonghwa.springbootdeveloper.repository;

import org.shinseonghwa.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
