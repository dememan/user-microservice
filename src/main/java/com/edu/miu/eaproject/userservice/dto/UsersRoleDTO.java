package com.edu.miu.eaproject.userservice.dto;

import com.edu.miu.eaproject.userservice.domain.Roles;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class UsersRoleDTO {
    private String userName;
    private List<Roles> roles=new ArrayList<>();

    public UsersRoleDTO() {
    }

    public UsersRoleDTO(String userName, List<Roles> roles) {
        this.userName = userName;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

}
