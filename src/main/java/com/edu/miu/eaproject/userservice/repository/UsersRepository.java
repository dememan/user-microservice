package com.edu.miu.eaproject.userservice.repository;

import com.edu.miu.eaproject.userservice.domain.Roles;
import com.edu.miu.eaproject.userservice.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long>, UsersCustomRepository {

}
