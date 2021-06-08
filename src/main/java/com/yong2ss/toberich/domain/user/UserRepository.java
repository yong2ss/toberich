package com.yong2ss.toberich.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);   //이미 생성됐는지 처음 가입하는지 확인용
}
