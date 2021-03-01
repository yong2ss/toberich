package com.yong2ss.toberich.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {
    Optional<MemberInfo> findById(String userid);
}
