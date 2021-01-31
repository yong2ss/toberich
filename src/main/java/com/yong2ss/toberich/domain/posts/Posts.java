package com.yong2ss.toberich.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가
@Getter
@Entity //테이블과 링크될 클래스
public class Posts {

    //Entity 클리스 (실제 DB테이블과 매칭될 클래스)
    //실제 쿼리보다는, 이 Entity 클래스를 수정해서 작업
    
    @Id //PK필드
    @GeneratedValue //pk 생성규칙 -> 기본은 Auto로 자동증가하는 정수값
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
