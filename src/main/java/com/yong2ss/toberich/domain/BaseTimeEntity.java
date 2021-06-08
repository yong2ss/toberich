package com.yong2ss.toberich.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
/*
    Date는 불변 객체가 아니라서 멀티스레드 환경에서 문제가 발생가능
    Calendar는 월(month)값 설계가 잘못되어있음
    따라서 LocalDateTime을 사용한다.
*/
@Getter
@MappedSuperclass   //BaseTimeEntity를 상속할 경우 create,last date도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //Auditing 기능 포함
public class BaseTimeEntity {
    @CreatedDate            //Entity가 생성되어 저장될때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate       //조회한 Entity값을 수정할때 시간 자동 저장
    private LocalDateTime modifiedDate;
}
