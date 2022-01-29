package com.edu.miu.eaproject.userservice.repository;

import com.edu.miu.eaproject.userservice.domain.Users;
import org.springframework.data.jpa.repository.Query;

public interface UsersCustomRepository {

    @Query("select u from Users u where u.userName=:userName")
    public Users findUsersByUserName(String userName);
}
