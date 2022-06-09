package com.rest.apiTest.controller;


import com.rest.apiTest.entity.User;
import com.rest.apiTest.entity.UserDto;
import com.rest.apiTest.repo.UserJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. User"})
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/user")
    public List<User> findAllUser(){

        return userJpaRepo.findAll();
    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
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
