package com.pjx.demo2018.dailytest.enums;

/**
 * Created by juqi on 19/8/27.
 */
public enum  CodeStatus {
    VALID("VALID", "有效"),
    INVALID("INVALID", "无效");
    private String name;
    private String displayName;

    CodeStatus(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
