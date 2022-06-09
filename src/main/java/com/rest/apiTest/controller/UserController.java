package com.rest.apiTest.controller;


import com.rest.apiTest.entity.User;
import com.rest.apiTest.entity.UserDto;
import com.rest.apiTest.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    @GetMapping(value = "/user")
    public List<User> findAllUser(){

        return userJpaRepo.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/user")
    public User save(@RequestBody UserDto userdto){
        System.out.println(userdto.getUid());
        System.out.println(userdto.getName());
        User userBuild = User.builder()
                .uid(userdto.getUid())
                .name(userdto.getName())
                .build();
        return userJpaRepo.save(userBuild);
    }


}
