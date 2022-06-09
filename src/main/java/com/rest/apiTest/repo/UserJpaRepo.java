package com.rest.apiTest.repo;

import com.rest.apiTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo  extends JpaRepository<User, Long> {
}
