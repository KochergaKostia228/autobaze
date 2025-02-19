package com.example.autobaza.service.appuserservice;


import com.example.autobaza.model.AppUser;

import java.util.List;

public interface AppUserService {

        void save(AppUser user);

        int[] saveEventsList(List<AppUser> user);

        void update(AppUser user);

        void delete(AppUser user);

        List<AppUser> findAll();

        void deleteAll();

        Boolean existsByUsername(String username);
}
