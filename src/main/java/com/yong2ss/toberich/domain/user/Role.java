package com.yong2ss.toberich.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Spring-security에선 Key값 앞에 ROLE_ 접두사가 있어야만 한다.

@RequiredArgsConstructor
@Getter
public enum Role {
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_GUEST", "유저"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}
