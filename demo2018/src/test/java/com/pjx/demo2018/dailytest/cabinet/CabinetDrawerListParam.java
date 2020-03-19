package com.pjx.demo2018.dailytest.cabinet;

import com.juqitech.service.utils.MD5Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.NoSuchAlgorithmException;

/**
 * CabinetDrawerListParam
 *
 * @author zhuhaitao
 * @since 2019-07-23
 */
@Setter
@Getter
@ToString(callSuper = true)
public class CabinetDrawerListParam extends CabinetBaseParam {

    private String cabinetNo;


    @Override
    String calculationSign() {
        StringBuilder signBuilder = new StringBuilder();
        signBuilder.append(apikey).append(cabinetNo).append(nonce).append(apiSecret);

        try {
            String signStr = MD5Utils.string2MD5(signBuilder.toString());
            return signStr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
//            throw new BizException("生成签名失败");
        }

    }

    public CabinetDrawerListParam(String cabinetNo) {
        this.cabinetNo = cabinetNo;
        sign = calculationSign();
    }
}
