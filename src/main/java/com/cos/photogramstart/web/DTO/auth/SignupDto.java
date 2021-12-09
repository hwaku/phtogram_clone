package com.cos.photogramstart.web.DTO.auth;

import lombok.Data;

// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한꺼번에 설정해주는 어노테이션
@Data

// Data Transfer Object
// 통신할때 필요한 데이터를 담아두는 오브젝트
public class SignupDto {
    private String username;
    private String password;
    private String email;
    private String name;

}
