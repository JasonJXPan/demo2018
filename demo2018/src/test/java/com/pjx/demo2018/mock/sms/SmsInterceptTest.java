package com.pjx.demo2018.mock.sms;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmsInterceptTest {

    @Test
    public void test() {
        SmsInterceptConfigDTO dto = new SmsInterceptConfigDTO();
        dto.setDestination(SMSInterceptDestination.ADAPTER);

        SmsInterceptConfigDetailDTO detail = new SmsInterceptConfigDetailDTO();
        detail.setAction("ac");
//        detail.setTemplate("ac xxx data hh");

        List<SmsInterceptConfigDetailDTO> details = new ArrayList<>();
        details.add(detail);

        dto.setConfigDetails(details);

        List<SmsInterceptConfigDTO> full = new ArrayList<>();
        full.add(dto);

        String s = JSON.toJSONString(full);



        System.out.println(s);
    }
    @Test
    public void test1() {
        String x = "[{\"configDetails\":[{\"action\":\"ac\",\"template\":\"ac xxx data hh\"}],\"destination\":\"ADAPTER\"}]";

        List<SmsInterceptConfigDTO> smsInterceptConfigDTOS = JSON.parseArray(x, SmsInterceptConfigDTO.class);
        System.out.println(smsInterceptConfigDTOS);
    }

    @Test
    public void init() {
        List<SmsInterceptConfigDTO> full = new ArrayList<>();
//        Channel_tianmao,Channel_piaoxingqiu,CHANNEL_PIAOLAOBAN,CHANNEL_SHOWNOW

        SmsInterceptConfigDTO tianmao = new SmsInterceptConfigDTO();
        tianmao.setDestination(SMSInterceptDestination.ADAPTER);
        tianmao.setPayment(PaymentMethodType.CHANNEL_TIANMAO.getName());

        full.add(tianmao);

        SmsInterceptConfigDTO xingqiu = new SmsInterceptConfigDTO();
        xingqiu.setDestination(SMSInterceptDestination.ADAPTER);
        xingqiu.setPayment(PaymentMethodType.CHANNEL_PIAOXINGQIU.getName());

        full.add(xingqiu);

        SmsInterceptConfigDTO piaolaoban = new SmsInterceptConfigDTO();
        piaolaoban.setDestination(SMSInterceptDestination.ADAPTER);
        piaolaoban.setPayment(PaymentMethodType.CHANNEL_PIAOLAOBAN.getName());

        full.add(piaolaoban);

        SmsInterceptConfigDTO shownow = new SmsInterceptConfigDTO();
        shownow.setDestination(SMSInterceptDestination.ADAPTER);
        shownow.setPayment(PaymentMethodType.CHANNEL_SHOWNOW.getName());

        full.add(shownow);


        SmsInterceptConfigDTO taobaoxi = new SmsInterceptConfigDTO();
        taobaoxi.setDestination(SMSInterceptDestination.CUSTOMIZED);
        taobaoxi.setPayment(PaymentMethodType.TAOBAO.getName());

        List<SmsInterceptConfigDetailDTO> details = new ArrayList<>();
        SmsInterceptConfigDetailDTO detail = new SmsInterceptConfigDetailDTO();
        detail.setTemplate("您订购的SHOW_NAME 请ARRIVE_TIME至ADDRESS，联系电话SELLER_PHONE进行取票！取票码：VERIFY_CODE，因现场取票，请等待30分钟~1小时，请合理安排时间！最晚取票时间截止为开场后半小时。");
        detail.setAction("SMS_VENUE_SELLER_TAKE_TICKET");
        detail.setComments("卖家核销");
        detail.setProductChannelId("5dc38dd44983160190da9934");

        SmsInterceptConfigDetailDTO detail1 = new SmsInterceptConfigDetailDTO();
        detail1.setAction("SMS_ORDER_DELIVERY");
        detail1.setTemplate("您购买的[SHOW_NAME ORDER_QTY张]已发货：EXPRESS。请注意查收，遇到问题请联系在线客服。");
        detail1.setComments("快递已发货");
        detail1.setProductChannelId("5dc38dd44983160190da9934");

        SmsInterceptConfigDetailDTO detail2 = new SmsInterceptConfigDetailDTO();
        detail2.setAction("SMS_TICKET_BOX_REMIND");
        detail2.setTemplate("尊敬的客户，您在 淘票票 购买的 TICKET_QTY张<SHOW_NAME SESSION_NAME>烦请提前一小时到达取票柜取票，ADDRESS。取票码将于开演前1-2小时内发出。温馨提醒:建议您收到取票码后尽快到达取票柜取票。");
        detail2.setComments("通知使用取票柜");
        detail2.setProductChannelId("5dc38dd44983160190da9934");

        SmsInterceptConfigDetailDTO detail3 = new SmsInterceptConfigDetailDTO();
        detail3.setAction("SMS_TICKET_BOX_WRITE_OFF");
        detail3.setTemplate("尊敬的客户，您在 淘票票 购买的 TICKET_QTY张<SHOW_NAME SESSION_NAME> 已放置完毕，您可凭码PICKUP_CODE取票柜取票，兑换地址:ADDRESS，请妥善保管，如取票柜不能正常使用，请联系现场工作人员，祝您观演愉快。");
        detail3.setComments("发送取票柜取件码");
        detail3.setProductChannelId("5dc38dd44983160190da9934");

        details.add(detail);
        details.add(detail1);
        details.add(detail2);
        details.add(detail3);

        taobaoxi.setConfigDetails(details);
        full.add(taobaoxi);

        System.out.println(JSON.toJSONString(full));
    }
}
