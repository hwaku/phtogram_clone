package com.cos.photogramstart.domain.user;

// JPA - Java Persistence API (자바로 데이터를 영구적으로 저장[DB] 할 수 있는 API 제공)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 테이블 생성
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다
    private Long id;

    private String username;
    private String password;

    private String name;
    private String website;
    private String bio; // 자기소개
    private String email;
    private String gender;

    private String profileImageUrl; // 사진
    private String role; // 권한

    private LocalDateTime createDate;

    @PrePersist // DB에 INSERT되기 직전에 실행 (값을 자동생성)
    public void CreateDate(){
        this.createDate=LocalDateTime.now();
    }
}
