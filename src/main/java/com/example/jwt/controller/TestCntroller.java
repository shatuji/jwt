package com.example.jwt.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 @author echo
 @create 2019年09月20日 11:55

 */
@RestController
@RequestMapping("/test")
public class TestCntroller {
    //@PostAuthorize("hasAnyRole('ROLE_USER')")
   // @PreAuthorize("hasAnyRole('ROLE_USER')")
    @RequestMapping("/mokey")
    public String mokey()
    {
        System.out.println("test auth about this project and show all message ");
        return "11111";
    }

   // @PostAuthorize("hasAnyRole('ROLE_ADMIN')")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/cat")
    public String cat()
    {
        System.out.println("test auth about this project and show all message ");
        return "11111";
    }

   // @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/snake")
    public String snake()
    {
        System.out.println("test auth about this project and show all message ");
        return "11111";
    }

    // @PostAuthorize("hasAnyRole('ROLE_ADMIN')")
   // @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/elephant")
    public String elephant()
    {
        System.out.println("test auth about this project and show all message ");
        return "11111";
    }

}
