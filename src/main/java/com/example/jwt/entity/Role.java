package com.example.jwt.entity;

import java.io.Serializable;

/***
 @author echo
 @create 2019年09月20日 9:56

 */
public class Role implements Serializable {
    private static final long serialVersionUID = 11452355823L;
    private Integer id;

    private String rolename;

    public Role() {

    }

    public Role(String name) {
        this.rolename = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
