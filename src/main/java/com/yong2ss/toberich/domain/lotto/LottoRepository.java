package com.yong2ss.toberich.domain.lotto;

import com.yong2ss.toberich.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LottoRepository extends JpaRepository<User, Long> {
    Optional<Lotto> findByRound(int round);   //회차 검색
}
