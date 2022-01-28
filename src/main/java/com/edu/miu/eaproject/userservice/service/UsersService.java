package com.edu.miu.eaproject.userservice.service;

import com.edu.miu.eaproject.userservice.domain.Users;
import com.edu.miu.eaproject.userservice.dto.UsersRoleDTO;

import java.util.List;

public interface UsersService {
    public List<Users> getAll();

    boolean existsById(Long userId);

    public Users getById(Long userId);
    public Users create(Users user);
    public Users update(Users user);
    public void deleteById(Long userId);


    UsersRoleDTO getUserRoles(Long userId);

    Users getByUserName(String username);
}
