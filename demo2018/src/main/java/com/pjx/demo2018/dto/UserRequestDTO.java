package com.pjx.demo2018.dto;

import com.pjx.demo2018.enums.Gender;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/2/2
 */
public class UserRequestDTO {
    private String id;
    private Gender gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}