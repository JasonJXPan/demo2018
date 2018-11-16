package com.pjx.demo2018.dailytest;

/**
 * Created by juqi on 18/10/8.
 */
public class SellerShowCertificationDTO {
    private static final long serialVersionUID = 52174737009164826L;
    /**
     * 演出id
     */
    private String showOID;
    /**
     * 卖家类型
     */
    private String sellerType;
    /**
     * 原卖家id
     */
    private String sellerOID;

    /**
     * 应显示的卖家id，卖家id或者共享源卖家id
     */
    private String facadeSellerOID;

    /**
     * 应显示的卖家昵称，卖家昵称或者共享源卖家昵称
     */
    private String facadeSellerNickName;
    /**
     * 应显示的卖家企业营业执照图片, 卖家企业营业执照图片或者共享源卖家企业营业执照图片
     */
    private String facadeBusinessLicenseFile;


    public String getSellerOID() {
        return sellerOID;
    }

    public void setSellerOID(String sellerOID) {
        this.sellerOID = sellerOID;
    }

    public String getShowOID() {
        return showOID;
    }

    public void setShowOID(String showOID) {
        this.showOID = showOID;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public String getFacadeSellerOID() {
        return facadeSellerOID;
    }

    public void setFacadeSellerOID(String facadeSellerOID) {
        this.facadeSellerOID = facadeSellerOID;
    }

    public String getFacadeSellerNickName() {
        return facadeSellerNickName;
    }

    public void setFacadeSellerNickName(String facadeSellerNickName) {
        this.facadeSellerNickName = facadeSellerNickName;
    }

    public String getFacadeBusinessLicenseFile() {
        return facadeBusinessLicenseFile;
    }

    public void setFacadeBusinessLicenseFile(String facadeBusinessLicenseFile) {
        this.facadeBusinessLicenseFile = facadeBusinessLicenseFile;
    }

    @Override
    public String toString() {
        return "SellerShowCertificationDTO{" +
                "showOID='" + showOID + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", sellerOID='" + sellerOID + '\'' +
                ", facadeSellerOID='" + facadeSellerOID + '\'' +
                ", facadeSellerNickName='" + facadeSellerNickName + '\'' +
                ", facadeBusinessLicenseFile='" + facadeBusinessLicenseFile + '\'' +
                '}';
    }
}
