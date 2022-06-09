package com.rest.apiTest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor //인자 없는 생성자를 자동으로 생성합니다
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long msrl;

    @Column(nullable = false, unique = true, length = 30)
    private String uid;

    @Column(nullable = false, length = 100)
    private String name;

    @Builder
    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;


    }
}
