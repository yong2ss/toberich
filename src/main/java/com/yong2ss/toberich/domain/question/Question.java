package com.yong2ss.toberich.domain.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yong2ss.toberich.domain.BaseTimeEntity;
import com.yong2ss.toberich.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String check;

    //User : Question => 1 : (0~N)
    @ManyToOne(fetch = FetchType.LAZY)  //지연 로딩
    @JsonIgnore //json으로 외부에 표시할 때 해당 어노테이션 값은 노출하지 않음
    private User user;
}
