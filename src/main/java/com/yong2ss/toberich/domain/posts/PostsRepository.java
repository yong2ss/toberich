package com.yong2ss.toberich.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository <Posts, Long> {
    //Dao라고 생각하면 되는 DB layer 접근자이다.
    //JPA에선 Repository라고 불리고, JpaRepository<Entity클래스, PK타입>를 상속하면
    //기본적인 CRUD 메소드가 자동 생성
    //별도로 @Repository를 추가 할 필요 없다.
}
