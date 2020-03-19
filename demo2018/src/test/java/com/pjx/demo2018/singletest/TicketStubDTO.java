package com.pjx.demo2018.singletest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.juqitech.service.enums.ChannelEnum;
import com.juqitech.service.vo.resource.ResourceVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 取票凭证DTO类
 *
 * @author libingqing
 * @since 2019/1/11
 */
@Getter
@Setter
public class TicketStubDTO extends BaseDTO {

    /**
     * 订单编号
     */
    private String orderNumber;


    /**
     * 卖家编号
     */
    private String sellerOId;

    /**
     * 票源
     */
    private ChannelEnum channel;

    /**
     * 取票凭证短信
     */
    private String stubMessage;

    /**
     *  取票码列表
     */
    private List<CheckCodeItem> checkCodeItemList;
    /**
     *  取票二维码资源
     **/
    private List<ResourceVo> resources;
    /**
     * 取票地点
     */
    private String pickTicketAddress;

    /**
     * 取票联系人电话
     */
    private String pickTicketPhone;

    /**
     * 取票码信息
     */
    @Getter
    @Setter
    public static class CheckCodeItem {
        /**
         * 取票码
         */
        private String checkCode;

        /**
         * 二维码链接
         */
        private String QRCodeURL;

        /**
         * 码的状态
         *
         */
        private String codeStatus;

        /**
         * 码的状态描述
         */
        private String codeStatusDesc;

    }

    /**
     * 获取附加凭证的JSON字符串
     *
     * @return
     */
    public String getAdditionalStubJSON() {
        SimplePropertyPreFilter propertyPreFilter = new SimplePropertyPreFilter(TicketStubDTO.class,
                "resources","checkCodeItemList","pickTicketAddress","pickTicketPhone");
        return JSON.toJSONString(this, propertyPreFilter);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
