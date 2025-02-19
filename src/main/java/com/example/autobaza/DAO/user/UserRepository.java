package com.example.autobaza.DAO.user;

import com.example.autobaza.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("from AppUser a where a.username = ?1")
    Optional<AppUser> findUserAccount(String username);

    boolean existsByUsername(String username);
}

