package com.hyeon.book.springboot.domain.posts;
import com.hyeon.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dom4j.swing.XMLTableColumnDefinition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// lombok annotation
// Class와 멀리 해놓는 이유 : 나중에 새 언어(코틀린 등) 전환으로 롬복이 필요 없을 경우 쉽게 삭제 가능.
@Getter
@NoArgsConstructor
// JPA annotation
@Entity                 //DB Table과 링크될 클래스, 기본적으로 카멜케이스(Class) -> 언더스코어 네이밍(Table)으로 매칭
public class Posts extends BaseTimeEntity {    // ex> SalesManager.java -> sales_manager table

    @Id // PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;                                    // GenerationType.IDENTITY 옵션을 추가해야만 AUTO_INCREMENT가 됨.

    @Column(length = 500, nullable = false) // VARCHAR(255) -> length = 500 으로 변경할 경우 @Column 꼭 명시.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입을 변경할 경우 @Column 꼭 명시.
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
