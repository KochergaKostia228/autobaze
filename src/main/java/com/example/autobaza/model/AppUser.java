package com.example.autobaza.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "encryted_password")
    private String encrytedPassword;

    @Column(name = "enabled")
    private boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return enabled == appUser.enabled
                && Objects.equals(userId, appUser.userId)
                && Objects.equals(email, appUser.email)
                && Objects.equals(encrytedPassword, appUser.encrytedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, encrytedPassword, enabled);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId=" + userId +
                ", userName='" + email + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


