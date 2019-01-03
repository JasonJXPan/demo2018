package com.pjx.demo2018.po;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by juqi on 18/6/13.
 */
public class Mytest {
    @NotEmpty
    private String name;
    private String address;

    private List<PurchPo> purchPos;

    public Mytest(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PurchPo> getPurchPos() {
        return purchPos;
    }

    public void setPurchPos(List<PurchPo> purchPos) {
        this.purchPos = purchPos;
    }

    @Override
    public String toString() {
        return "Mytest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", purchPos=" + purchPos +
                '}';
    }
}
