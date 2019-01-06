package com.pjx.demo2018.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author juqi
 * @date 18/5/26
 */
//避免开启mybatis懒加载导致controller返回 无法序列化
@JsonIgnoreProperties(value = {"handler"})
public class UserPO implements Serializable {
    private static final long serialVersionUID = -8482864799163759525L;
    private Long id;
    private String username;
    private String password;

    private List<UserIPPO> userIPPOS;

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

    public List<UserIPPO> getUserIPPOS() {
        return userIPPOS;
    }

    public void setUserIPPOS(List<UserIPPO> userIPPOS) {
        this.userIPPOS = userIPPOS;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userIPPOS=" + userIPPOS +
                '}';
    }
}
