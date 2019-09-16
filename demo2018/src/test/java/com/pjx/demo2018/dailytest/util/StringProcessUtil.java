package com.pjx.demo2018.dailytest.util;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.juqitech.service.enums.CouponStatus;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by juqi on 18/7/30.
 */
public class StringProcessUtil {
    public static String getBreviaryValue(String content, int limitLengthFromStart, String placeHolder){
        if (StringUtils.isBlank(content) || StringUtils.length(content) <= limitLengthFromStart) {
            return content;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(content.substring(0, limitLengthFromStart));
        stringBuilder.append(placeHolder);
        return stringBuilder.toString();
    }

    @Test
    public void test1() {
        String x = "[CouponVO{couponOID='5cb7fa5463161b1f83e341f6', couponTemplateOID='5cb7f8ad63161b1f83e34067', promotionCode='YRJBR1', " +
                "clientOID='5cb7fa2f63161b73d3f5229f', discount\n" +
                "=30.0, limitation=50.0, couponType='Reduction', couponStatus='Used', startTime=Thu Apr 18 00:00:00 CST 2019, expireTime=Sat Apr 20 00:00:00 CST 2019, channel='n\n" +
                "ull', title='20190418现+主[音乐]', ruleType='null', ruleData='null', couponRuleComment='null', createTime=null, unAvailableReasons=null}]";

        CouponVO vo = new CouponVO();
        vo.setCouponOID("5cb7fa5463161b1f83e341f6");
        vo.setCouponStatus("Used");
        List<CouponVO> list = new ArrayList<>();
        list.add(vo);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String s = mapper.writeValueAsString(list);
            String parse = JSON.toJSONString(list);
            System.out.println(s);
            System.out.println(parse);
            List<CouponVO> list1 = JSON.parseArray(s, CouponVO.class);
            List<CouponVO> coupons  = mapper.readValue(s, List.class);
            System.out.println(coupons);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class CouponVO implements Serializable {
    private static final long serialVersionUID = -1130257786993408950L;

    private String couponOID;

    private String couponTemplateOID;

    private String promotionCode;

    private String clientOID;

    private Double discount;

    private Double limitation;

    private String couponType;

    @JsonSerialize(using = CouponStatusJsonSerializer.class)
    private String couponStatus;

    @JsonFormat(pattern = "yyyy.MM.dd",  timezone = "GMT+8", locale="zh")
    private Date startTime;

    @JsonFormat(pattern = "yyyy.MM.dd",  timezone = "GMT+8", locale="zh")
    private Date startTimeDot;

    @JsonFormat(pattern = "yyyy.MM.dd",  timezone = "GMT+8", locale="zh")
    private Date expireTime;

    @JsonFormat(pattern = "yyyy.MM.dd",  timezone = "GMT+8", locale="zh")
    private Date expireTimeDot;

    private String channel;

    private String title;

    private String ruleType;

    private String ruleData;

    private String couponRuleComment;

    private Float discountValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",  timezone = "GMT+8", locale="zh")
    private Date createTime;

    public Float getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
    }
    private Boolean usable;

    private String showOID;

    @ApiModelProperty("不可用原因")
    private List<String> unAvailableReasons;

    public String getCouponOID() {
        return couponOID;
    }

    public void setCouponOID(String couponOID) {
        this.couponOID = couponOID;
    }

    public String getCouponTemplateOID() {
        return couponTemplateOID;
    }

    public void setCouponTemplateOID(String couponTemplateOID) {
        this.couponTemplateOID = couponTemplateOID;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getClientOID() {
        return clientOID;
    }

    public void setClientOID(String clientOID) {
        this.clientOID = clientOID;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getLimitation() {
        return limitation;
    }

    public void setLimitation(Double limitation) {
        this.limitation = limitation;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleData() {
        return ruleData;
    }

    public void setRuleData(String ruleData) {
        this.ruleData = ruleData;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCouponRuleComment() {
        return couponRuleComment;
    }

    public void setCouponRuleComment(String couponRuleComment) {
        this.couponRuleComment = couponRuleComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    public String getShowOID() {
        return showOID;
    }

    public void setShowOID(String showOID) {
        this.showOID = showOID;
    }

    public Date getStartTimeDot() {
        return startTimeDot == null? startTime : startTimeDot;
    }

    public void setStartTimeDot(Date startTimeDot) {
        this.startTimeDot = startTimeDot;
    }

    public Date getExpireTimeDot() {
        return expireTimeDot == null? expireTime : expireTimeDot;
    }

    public void setExpireTimeDot(Date expireTimeDot) {
        this.expireTimeDot = expireTimeDot;
    }

    public List<String> getUnAvailableReasons() {
        return unAvailableReasons;
    }

    public void setUnAvailableReasons(List<String> unAvailableReasons) {
        this.unAvailableReasons = unAvailableReasons;
    }

    @Override
    public String toString() {
        return "CouponVO{" +
                "couponOID='" + couponOID + '\'' +
                ", couponTemplateOID='" + couponTemplateOID + '\'' +
                ", promotionCode='" + promotionCode + '\'' +
                ", clientOID='" + clientOID + '\'' +
                ", discount=" + discount +
                ", limitation=" + limitation +
                ", couponType='" + couponType + '\'' +
                ", couponStatus='" + couponStatus + '\'' +
                ", startTime=" + startTime +
                ", expireTime=" + expireTime +
                ", channel='" + channel + '\'' +
                ", title='" + title + '\'' +
                ", ruleType='" + ruleType + '\'' +
                ", ruleData='" + ruleData + '\'' +
                ", couponRuleComment='" + couponRuleComment + '\'' +
                ", createTime=" + createTime +
                ", unAvailableReasons=" + unAvailableReasons +
                '}';
    }
}
class CouponStatusJsonSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        CouponStatus status = CouponStatus.getCouponStatus(value);
        EnumVo enumVo = new EnumVo();
        enumVo.setCode(status!=null?status.getCode():0);
        enumVo.setName(value);
        enumVo.setDisplayName(status!=null?status.getDisplayName():"");
        jgen.writeObject(enumVo);
    }
}
class EnumVo implements Serializable {
    private static final long serialVersionUID = 2374503685785083437L;
    private int code;
    private String displayName;
    private String name;

    public EnumVo() {
    }

    public EnumVo(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
