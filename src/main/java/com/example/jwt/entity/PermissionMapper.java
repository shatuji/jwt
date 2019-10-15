package com.example.jwt.entity;


import java.util.ArrayList;
import java.util.List;

public class PermissionMapper implements PermissionDao {
    private static final List<Permission> list = new ArrayList<>();

    @Override
    public List<Permission> findAll() {
        Permission permission = new  Permission();

        permission.setId("1");
        permission.setDescription("home");
        permission.setName("ROLE_HOME");
        permission.setUrl("/index");

        Permission permission1 = new Permission();
        permission1.setId("2");
        permission1.setDescription("echo");
        permission1.setName("ROLE_USER");
        permission1.setUrl("/admin");

        Permission permission2 = new Permission();
        permission2.setId("3");
        permission2.setDescription("access");
        permission2.setName("ROLE_ACCESS");
        permission2.setUrl("/access");

        Permission permission3 = new Permission();
        permission3.setId("4");
        permission3.setDescription("homestrst");
        permission3.setName("ROLE_HOME");
        permission3.setUrl("/home");
        list.add(permission);
        list.add(permission1);
        list.add(permission2);
        list.add(permission3);
        return list;
    }

    //@Override
    public List<Permission> findAll2() {
        //Permission permission = new  Permission();
        List<Permission> ls = new ArrayList<>();


        Permission permission1 = new Permission();
        permission1.setId("2");
        permission1.setDescription("echo");
        permission1.setName("ROLE_ADMIN");
        permission1.setUrl("/admin");

        Permission permission2 = new Permission();
        permission2.setId("3");
        permission2.setDescription("access");
        permission2.setName("ROLE_ACCESS");
        permission2.setUrl("/access");


       // list.add(permission);
        ls.add(permission1);
        ls.add(permission2);
        //list.add(permission3);
        return ls;
    }

    @Override
    public List<Permission> findByUserId(String userId) {
        //there is nothing to write
        return this.findAll2();
    }
}
