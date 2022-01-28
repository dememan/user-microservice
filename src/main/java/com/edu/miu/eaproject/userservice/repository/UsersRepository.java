package com.edu.miu.eaproject.userservice.repository;

import com.edu.miu.eaproject.userservice.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> , UsersCustomRepository {

}
