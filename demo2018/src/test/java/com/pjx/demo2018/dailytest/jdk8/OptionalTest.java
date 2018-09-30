package com.pjx.demo2018.dailytest.jdk8;

import com.pjx.demo2018.dailytest.domain.UserClientInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by juqi on 18/9/29.
 */
public class OptionalTest {
    @Test
    public void test1(){
        /**
         * java.lang.NullPointerException
         */
//        Optional optional = Optional.of(null);
    }

    @Test
    public void test2(){
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.isPresent());
//        ifPresent() - do something when Optional is set
        optional.ifPresent(x -> System.out.println(x));
//        filter() - reject (filter out) certain Optional values.filter() - reject (filter out) certain Optional values.
        optional.filter(x -> x==null).ifPresent(x -> System.out.println(x));
        System.out.println(optional.filter(x -> x==null).isPresent());
//        map() - transform value if present
        optional.map(String::trim).filter(x -> x.length()<1).ifPresent(x -> System.out.println(x));
//        orElse()/orElseGet() - turning empty Optional<T> to default T
        System.out.println(optional.map(String::length).isPresent());
    }
    @Test
    public void test3(){
        Optional<String> optional = Optional.ofNullable("a");
//        ifPresent() - do something when Optional is set
        optional.ifPresent(x -> System.out.println(x));
//        filter() - reject (filter out) certain Optional values.filter() - reject (filter out) certain Optional values.
        optional.filter(x -> x.equals("a")).ifPresent(x-> System.out.println(x));
        System.out.println(optional);
        System.out.println(optional.isPresent());
        optional.filter(x -> x.equals("b")).ifPresent(x-> System.out.println(x));
        System.out.println(optional);
        System.out.println(optional.filter(x -> x.equals("b")).isPresent());
//        optional.filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.equals("b");
//            }
//        });
        //        map() - transform value if present todo

        //        orElse()/orElseGet() - turning empty Optional<T> to default T
        System.out.println(optional.map(String::length).get());
        System.out.println(optional);
        System.out.println(optional.map(StringUtils::length).orElse(-1));
        Optional<String> optionalx = Optional.empty();
        System.out.println(optionalx.map(StringUtils::length).orElse(new Integer(10)));
    }
    @Test
    public void test4(){
        List<UserClientInfo> userClientInfos = new ArrayList<>();
        UserClientInfo userClientInfo1 = new UserClientInfo();
        userClientInfo1.setUserOID("123");
        UserClientInfo userClientInfo2 = new UserClientInfo();
        userClientInfo2.setUserOID("234");
        userClientInfos.add(userClientInfo1);
        userClientInfos.add(userClientInfo2);
        Optional<List<UserClientInfo>> userClientInfosOption = Optional.of(userClientInfos);

        System.out.println("userClientInfosOption:"+userClientInfosOption);
        System.out.println("userClientInfosOption.isPresent():"+userClientInfosOption.isPresent());
        Optional<Boolean> aBoolean = userClientInfosOption.map(CollectionUtils::isNotEmpty);
        System.out.println("aBoolean:"+aBoolean);
//        Optional<Optional<List<UserClientInfo>>> userClientInfos2 = userClientInfosOption.map(x -> {
//            Stream<UserClientInfo> result = x.stream().filter(item -> item.getUserOID().equals("123"));
//            for ()
//            return Optional.ofNullable(userClientInfoStream);
//        });
//        System.out.println("userClientInfosOption::"+userClientInfosOption);
//        System.out.println("userClientInfos2::"+userClientInfos2);
//        Optional<List<UserClientInfo>> userClientInfos1 = userClientInfosOption.filter(x -> (x.stream().forEach(item -> item.getUserOID().equals("123"))));
//        System.out.println(userClientInfos1);
    }


}
