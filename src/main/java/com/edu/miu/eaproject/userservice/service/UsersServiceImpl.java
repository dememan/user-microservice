package com.edu.miu.eaproject.userservice.service;

import com.edu.miu.eaproject.userservice.domain.Users;
import com.edu.miu.eaproject.userservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public boolean existsById(Long userId) {
        return usersRepository.existsById(userId);
    }

    @Override
    public Users getById(Long userId) {
        if (existsById(userId))
            return usersRepository.getById(userId);

        return null;
    }

    @Override
    public Users create(Users user) {
        user.setId(null);
        return usersRepository.save(user);
    }

    @Override
    public Users update(Users user) {

        return usersRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public Users getByUserName(String username) {
        return usersRepository.findUsersByUserName(username);
    }
}

