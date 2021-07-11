package com.yong2ss.toberich.domain.draw;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yong2ss.toberich.domain.BaseTimeEntity;
import com.yong2ss.toberich.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Draw extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String drawdate;

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

    //User : Draw => 1 : (0~N)
    @ManyToOne(fetch = FetchType.LAZY)  //지연 로딩
    @JsonIgnore //json으로 외부에 표시할 때 해당 어노테이션 값은 노출하지 않음
    private User user;

    @Builder
    public Draw(String drawdate, int seq, int draw1, int draw2, int draw3, int draw4, int draw5, int draw6) {
        this.drawdate = drawdate;
        this.seq = seq;
        this.draw1 = draw1;
        this.draw2 = draw2;
        this.draw3 = draw3;
        this.draw4 = draw4;
        this.draw5 = draw5;
        this.draw6 = draw6;
    }
}
