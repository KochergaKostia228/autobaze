package com.example.autobaza.service.appuserservice;

import com.example.autobaza.DAO.user.UserRepository;
import com.example.autobaza.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> findAll() { return userRepository.findAll(); }

    @Override
    public void delete(AppUser user) { userRepository.delete(user); }

    @Override
    public int[] saveEventsList(List<AppUser> users) {
        userRepository.saveAll(users);
        return new int[1];
    }

    @Override
    public void save(AppUser user) { userRepository.save(user); }

    @Override
    public void update(AppUser user) { userRepository.save(user); }

    @Override
    public void deleteAll() { userRepository.deleteAll(); }

    @Override
    public Boolean existsByUsername(String username) { return userRepository.existsByUsername(username); }

}
