package com.example.littlebackend.security;

import com.example.littlebackend.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

//public class MyUserDetails implements UserDetails {
//    private User user;
//    private String userName;
//    private String password;
//    private String emailAddress;
//
//    public MyUserDetails(User user) {
//    }
//
//    public MyUserDetails(User user, String userName, String password, String emailAddress) {
//        this.user = user;
//        this.userName = userName;
//        this.password = password;
//        this.emailAddress = emailAddress;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return new HashSet<GrantedAuthority>();
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
