package com.pjx.demo2018.expire;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 2019/12/3
 */
public class ExpireTest {

    @Test
    public void test() {
        String channel="platform";
        String x = "[{\"channel\":\"platform\",\"minute\":15},{\"channel\":\"jingdong\",\"minute\":15},{\"channel\":\"maoyan\",\"minute\":15},{\"channel\":\"xiecheng\",\"minute\":15},{\"channel\":\"jingdong_os\",\"minute\":30},{\"channel\":\"yixiaobao\",\"minute\":15},{\"channel\":\"yiqifa\",\"minute\":15},{\"channel\":\"linkstars\",\"minute\":15},{\"channel\":\"guomei\",\"minute\":15},{\"channel\":\"orderagent\",\"minute\":10},{\"channel\":\"qiangpiao\",\"minute\":10},{\"channel\":\"DUO_MAI\",\"minute\":10}]";

        List<ChannelOrderExpireMinDTO> channelOrderExpireMinDTOS
                = JSON.parseArray(x, ChannelOrderExpireMinDTO.class);

        if (CollectionUtils.isEmpty(channelOrderExpireMinDTOS)) {
            return;
        }
        Optional<ChannelOrderExpireMinDTO> dto =
                channelOrderExpireMinDTOS.stream().filter(item -> StringUtils.equals(channel, item.getChannel())).findFirst();
        if (!dto.isPresent()) {
            return ;
        }

        System.out.println(dto.get());

    }

    public void test(BigDecimal totalAmount, BigDecimal a) {
//        (A*qtyA + B*qtyB + C*qtyC) +(x+y) = totalAmount
//        (A*qtyA)/(A*qtyA + B*qtyB + C*qtyC) * totalAmount

//        100 * 1 100*2 100*1  -30  370
//        370/4 = 90



    }

    //100w  1000w 50w 1 5
    public void getNext(BigDecimal totalAmount,
                   Long totalCandidatesCount, Long atleastBingoCount,
                   BigDecimal minAmount, BigDecimal maxAmount,
                   Long currentCandidateNumber, BigDecimal leftAmount){





    }

    public void getAmount(BigDecimal unitPriceA, BigDecimal unitPriceB, BigDecimal unitPriceC,
                          int qtyA, int qtyB, int qtyC, BigDecimal totalAmount) {
        BigDecimal bigDecimalA = totalAmount.divide(new BigDecimal(qtyA + qtyB + qtyC)).multiply(new BigDecimal(qtyA)).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal bigDecimalB = totalAmount.divide(new BigDecimal(qtyA + qtyB + qtyC)).multiply(new BigDecimal(qtyA)).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal bigDecimalC = totalAmount.subtract(bigDecimalA.add(bigDecimalB)).setScale(2, BigDecimal.ROUND_CEILING);

    }

}
