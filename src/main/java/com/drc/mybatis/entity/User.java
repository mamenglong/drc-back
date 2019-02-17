package com.drc.mybatis.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String uniquecode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUniquecode() {
        return uniquecode;
    }

    public void setUniquecode(String uniquecode) {
        this.uniquecode = uniquecode == null ? null : uniquecode.trim();
    }

    /**
     * 两个对象相等hascode一定相等
     * @return
     */
    public int hashCode() {
        return this.username.hashCode();
    }

    /**
     * equals相等的两个对象hascode一定相等，equals不相等不一定hascode不相等
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return super.equals(obj);
        } else {
            User user = (User) obj;
            return this.username.equals(user.username) && this.password.equals(user.password) && this.uniquecode.equals(user.uniquecode);
        }
    }
}