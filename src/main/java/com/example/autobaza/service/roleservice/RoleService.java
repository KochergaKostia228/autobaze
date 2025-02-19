package com.example.autobaza.service.roleservice;

import com.example.autobaza.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    int[] saveEventsList(List<Role> role);

    void update(Role role);

    void delete(Role role);

    List<Role> findAll();

    void deleteAll();

    Role findByRoleName(String roleName);
}

