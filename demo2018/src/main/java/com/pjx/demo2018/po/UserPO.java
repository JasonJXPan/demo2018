package com.pjx.demo2018.po;

import java.io.Serializable;

/**
 *
 * @author juqi
 * @date 18/5/26
 */
public class UserPO implements Serializable {
    private static final long serialVersionUID = -8482864799163759525L;
    private Long id;
    private String username;
    private String password;

    public UserPO() {
    }

    public UserPO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserPO(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
