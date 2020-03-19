package com.pjx.demo2018.dailytest.cabinet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * CabinetBaseParam
 *
 * @author zhuhaitao
 * @since 2019-07-23
 */
@Setter
@Getter
@ToString(callSuper = true)
public abstract class CabinetBaseParam {
    protected String apikey = "bdaa0655a14e4f3fa55e6aac5cde5e7a";
    protected String apiSecret = "e40ffca390934028b440fa0025682ab8";
    protected String sign;
    protected String nonce = GenerateUUID.generate(32);

    /**
     * 计算签名一定要按照入参的顺序
     * @return
     */
    abstract String calculationSign();

}
