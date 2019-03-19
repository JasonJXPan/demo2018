package com.pjx.demo2018.controller;

import com.juqitech.service.utils.net.StatusCode;
import com.juqitech.service.utils.query.*;
import com.pjx.demo2018.config.FavorProperties;
import com.pjx.demo2018.config.My2Properties;
import com.pjx.demo2018.dto.UserRequestDTO;
import com.pjx.demo2018.mapper.UserMapper;
import com.pjx.demo2018.po.Mytest;
import com.pjx.demo2018.po.PurchPo;
import com.pjx.demo2018.service.UserIpLogService;
import com.pjx.demo2018.vo.MyPost;
import com.pjx.demo2018.vo.MyPostXML;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juqi
 * @date 18/5/17
 */
@RestController
public class DemoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FavorProperties favorProperties;

    @Autowired
    private My2Properties my2Properties;
    @Autowired
    private UserIpLogService userIpLogService;

    @RequestMapping(value = "/health_check", method = RequestMethod.GET)
    public String checkProjectHealth(){
        return "health check done";
    }

    @GetMapping(value = "/favor_properties")
    public String findFavorProperties(){
        return favorProperties.toString();
    }

    @GetMapping(value = "/my2_properties")
    public String findMy2Properties(){
        System.out.println(my2Properties.getRandom_int());
        System.out.println(my2Properties.getRandomInt());
        return my2Properties.toString();
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object createTest(@RequestBody List<Mytest> mytest) {
        System.out.println(mytest.get(0).getName());
        System.out.println(mytest.get(0).getAddress());
//        System.out.println(mytest.get(1).getName());
//        System.out.println(mytest.get(1).getAddress());
        return null;
    }

    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET)
    public String testGet1(@PathVariable("value") String value){
        return value+"value";
    }

    @RequestMapping(value = "/test/health_check/a", method = RequestMethod.GET)
    public String testGet1(){
        return "test1";
    }

    @RequestMapping(value = "/my_post", method = RequestMethod.POST ,produces = MediaType.APPLICATION_XML_VALUE)
    public MyPostXML myPost(){
//        MyPost myPost = new MyPost();
//        myPost.setX("x");
//        myPost.setY("Y");
        MyPostXML myPost = new MyPostXML();
        myPost.setReturn_code("123");
        return myPost;
    }

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public PurchPo find() {
        PurchPo byId = userMapper.findPoById();
        System.out.println(byId.getOverdue());
        System.out.println(byId.getOverdue().getTime());
        System.out.println(byId.getId());
        return byId;
    }

    @RequestMapping(value = "/test-obj", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testObj(@RequestBody Mytest a, @RequestParam(value = "b") String b) {
        System.out.println(a.getName());
    }

    @RequestMapping(value = "/test/user-ip-log/{userId}", method = RequestMethod.GET)
    public void testUserIpLog(@PathVariable(value = "userId") String userId,
                              @RequestParam(value = "abc", defaultValue = "0") BigDecimal a) {
        a.doubleValue();
        String num = "1";
        userIpLogService.findByUserId(userId);
    }

    @RequestMapping(value = "/test/user-ip-log/foreach", method = RequestMethod.GET)
    public void testUserIpLogForeach() {
        List<String> list = new ArrayList<>();
        for (int i=0; i< 10000; i++) {
            list.add(i+"");
        }
        long l = System.currentTimeMillis();
        userIpLogService.findByUserIdsForeach(list);
        System.out.println(System.currentTimeMillis()-l);
    }

    @RequestMapping(value = "/test/user-ip-log/coll", method = RequestMethod.GET)
    public void testUserIpLogColl() {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i=0; i< 10000; i++) {
            stringBuilder.append(i).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(")");

        long l = System.currentTimeMillis();
        userIpLogService.findByUserIds(stringBuilder.toString());
        System.out.println(System.currentTimeMillis()-l);
    }


    @RequestMapping(value = "/test/user-ip-log1", method = RequestMethod.GET)
    public void testUserIpLog1() {
        QueryFilter filter = new QueryFilter();
        String purchaseOID ="purchaseOID";
        String zoneRowSeat ="purczoneRowSeathaseOID";
        String sql ="sql";
        QueryFilterHelper.addSimpleCondition(filter, purchaseOID, "tm_purchase_order.orderOID", CriteriaOperator
                .EQUALS);
        filter.setUpdateCondition("tm_purchase_order.zoneRowSeat", new Criteria(true, CriteriaOperator.EQUALS,
                zoneRowSeat));
        SQLHelper.createSQL(sql, (Pagination)null, filter);
    }

    @RequestMapping(value = "/test/request-dto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testRequestDTO(@RequestBody UserRequestDTO requestDTO) {
        System.out.println(requestDTO);
    }
    class A {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public A(){}
        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("name", name)
                    .toString();
        }
    }

    @RequestMapping(value = "/test/fix_null", method = RequestMethod.POST)
    public void checkPostNull(@RequestBody MyRequest myRequest) {
        System.out.println("hahaha");
        boolean blank = StringUtils.isBlank(myRequest.getId());
        if (StringUtils.isBlank(myRequest.getId())) {
            return ;
        }
        System.out.println(blank);
        System.out.println(myRequest);
    }


}

@Data
class MyRequest {
    private String id;
    private String value;
}
