package com.yong2ss.toberich.domain.question;

import com.yong2ss.toberich.domain.draw.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
