package com.yong2ss.toberich.domain.draw;

import com.yong2ss.toberich.dto.draw.CustomDrawDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DrawRepository extends JpaRepository<Draw, Long> {
    long countAllByDrawdate(String date);
}
