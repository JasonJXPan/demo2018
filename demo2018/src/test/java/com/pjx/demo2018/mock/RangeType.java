package com.pjx.demo2018.mock;

import org.apache.commons.lang3.StringUtils;

/**
 * 集合包含关系
 */
public enum RangeType {
    /**
     * 包含
     */
    INCLUDE("INCLUDE"),
    /**
     * 不包含
     */
    EXCLUDE("EXCLUDE");

    private String name;

    RangeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RangeType getByName(String name) {
        for (RangeType item : values()) {
            if (StringUtils.equals(name, item.getName())) {
                return item;
            }
        }
        return null;
    }
}
