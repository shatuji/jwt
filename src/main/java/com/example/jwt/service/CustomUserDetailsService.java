package com.example.jwt.service;

import com.example.jwt.dao.UserInfoMapper;
import com.example.jwt.entity.User;
import com.example.jwt.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 @author echo
 @create 2019年09月20日 10:04

 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userInfoMapper.findJdUserByAccount(s);
        return UserPrincipal.create(user);
    }
    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {

        User user = userInfoMapper.findEntityById(id.intValue());

        return UserPrincipal.create(user);
    }
}
