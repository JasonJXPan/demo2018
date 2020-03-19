package com.pjx.demo2018.dailytest.cabinet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * CabinetDrawerInfo
 *
 * @author zhuhaitao
 * @since 2019-07-24
 */
@Setter
@Getter
@ToString(callSuper = true)
public class CabinetDrawerInfo {
    private String r;
    private String cabinetStatus;
    private String dtname;
    private String lng;
    private String city;
    private String district;
    private String location;
    private String lat;
    private String cabinetNo;
//    private List<DrawerInfo> drawers;

    private String cabinetId;
    private String cabinetSingleId;
}
