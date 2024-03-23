package com.example.nonmembers.board.post.db;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name="post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;

    @Column(columnDefinition = "TEXT") // 엔티티 클래스의 특정 필드를 데이터베이스 테이블의 열(Column)과 매핑할 때 사용
    private String content;
    private LocalDateTime postedSt;

}
