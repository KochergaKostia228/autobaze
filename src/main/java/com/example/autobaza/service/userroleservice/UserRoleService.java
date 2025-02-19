package com.example.autobaza.service.userroleservice;

import com.example.autobaza.model.UserRole;

import java.util.List;

public interface UserRoleService
{
    void save(UserRole userRole);

    int[] saveEventsList(List<UserRole> userRole);

    void update(UserRole userRole);

    void delete(UserRole userRole);

    List<UserRole> findAll();

    void deleteAll();
}
