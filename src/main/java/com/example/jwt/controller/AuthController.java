package com.example.jwt.controller;

import com.example.jwt.dao.UserInfoMapper;
import com.example.jwt.entity.Role;
import com.example.jwt.entity.RoleName;
import com.example.jwt.entity.User;
import com.example.jwt.payload.ApiResponse;
import com.example.jwt.payload.JwtAuthenticationResponse;
import com.example.jwt.payload.LoginRequest;
import com.example.jwt.payload.SignUpRequest;
import com.example.jwt.service.RoleInfoService;
import com.example.jwt.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/***
 @author echo
 @create 2019年09月20日 10:58

 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserInfoMapper userInfoMapper;

//    @Autowired
//    RoleRepository roleRepository;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired

    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
/**
 * {
 *
 * "email" : "124541@foxmail.com",
 * "password" : "password"
 * }
 * AuthenticationManagerBuilder and AuthenticationManager
 * AuthenticationManagerBuilder is used to create an AuthenticationManager instance which is the main Spring Security interface for authenticating a user.
 * You can use AuthenticationManagerBuilder to build in-memory authentication, LDAP authentication, JDBC authentication, or add your custom authentication provider.
 * In our example, we’ve provided our customUserDetailsService and a passwordEncoder to build the AuthenticationManager.
 * We’ll use the configured AuthenticationManager to authenticate a user in the login API.
 */
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        URI location = null;
        try {
            // Creating user's account
            User user = new User();
            user.setAccount(signUpRequest.getEmail());
            user.setUserName(signUpRequest.getUsername());
            user.setTel(signUpRequest.getPassword());
            user.setPasswd(passwordEncoder.encode(signUpRequest.getPassword()));
            user.setStatus(0);

             Role userRole = roleInfoService.fetchRoleInfoById(2);

             user.setRoleId(userRole.getId());

            userInfoMapper.insertEntity(user);

            location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/api/users/{username}")
                    .buildAndExpand(user.getUserName()).toUri();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
