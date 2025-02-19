package com.example.autobaza.service.userdetailsservice;

import com.example.autobaza.DAO.user.UserRepository;
import com.example.autobaza.DAO.userrole.UserRoleRepository;
import com.example.autobaza.model.AppUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.userRepository.findUserAccount(username)
            .orElseThrow(RuntimeException::new);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }


        List<String> roleNames = this.userRoleRepository.getRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            grantList = roleNames.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        return new User(appUser.getUsername(), appUser.getEncrytedPassword(), grantList);
    }

}
