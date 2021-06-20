package com.yong2ss.toberich.domain.draw;

import com.yong2ss.toberich.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Draw extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String drawDate;

    @Column(nullable = false)
    private int seq;

    @Column(nullable = false)
    private int draw1;

    @Column(nullable = false)
    private int draw2;

    @Column(nullable = false)
    private int draw3;

    @Column(nullable = false)
    private int draw4;

    @Column(nullable = false)
    private int draw5;

    @Column(nullable = false)
    private int draw6;

    @Builder
    public Draw(String drawDate, int seq, int draw1, int draw2, int draw3, int draw4, int draw5, int draw6) {
        this.drawDate = drawDate;
        this.seq = seq;
        this.draw1 = draw1;
        this.draw2 = draw2;
        this.draw3 = draw3;
        this.draw4 = draw4;
        this.draw5 = draw5;
        this.draw6 = draw6;
    }
}
