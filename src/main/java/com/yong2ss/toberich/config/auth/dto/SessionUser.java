package com.yong2ss.toberich.config.auth.dto;

import com.yong2ss.toberich.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//그냥 User class를 사용하면 직렬화가 구현되지 않아 오류가 발생한다.
//User 클래스는 Entity이기 때문에 다른 엔티티와 관계가 형성되고 자식 엔티티를 포함할 수도 있다.
//이 경우 직렬화 대상에 다른 엔티티도 포함되어 성능 이슈, 부수효과가 발생하여
// 렬화 기능을 가진 세션 DTO를 별도로 둔다.

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name       = user.getName();
        this.email      = user.getEmail();
        this.picture    = user.getPicture();
    }
}
