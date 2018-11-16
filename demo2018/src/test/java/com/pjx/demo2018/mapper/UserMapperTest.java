package com.pjx.demo2018.mapper;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjx.demo2018.po.UserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juqi on 18/6/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddAndSelect() throws Exception {
        final int row1 = userMapper.insert(new UserPO("u1", "p1"));
        logger.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insert(new UserPO("u2", "p2"));
        logger.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insert(new UserPO("u1", "p3"));
        logger.info("[添加结果] - [{}]", row3);
        final List<UserPO> u1 = userMapper.findByUsername("u1", new ArrayList<>());
        logger.info("[根据用户名查询] - [{}]", u1);
    }

    @Test
    public void testPageHelper() {
//        final UserPO user1 = new UserPO("u1", "p1");
//        final UserPO user2 = new UserPO("u1", "p2");
//        final UserPO user3 = new UserPO("u3", "p3");
//        userMapper.insertSelective(user1);
//        logger.info("[user1回写主键] - [{}]", user1.getId());
//        userMapper.insertSelective(user2);
//        logger.info("[user2回写主键] - [{}]", user2.getId());
//        userMapper.insertSelective(user3);
//        logger.info("[user3回写主键] - [{}]", user3.getId());
//        final int count = userMapper.countByUsername("u1");
//        logger.info("[调用自己写的SQL] - [{}]", count);
//
//        // TODO 模拟分页
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        userMapper.insertSelective(new UserPO("u1", "p1"));
//        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
//        final PageInfo<UserPO> pageInfo = PageHelper.offsetPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.findByUsername("user1"));
//        logger.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

//        PageHelper.offsetPage(2, 10).setOrderBy("id desc").doSelectPage(new ISelect() {
//            @Override
//            public void doSelect() {
//                userMapper.findByUsername("user1");
//            }
//        });
        PageHelper.offsetPage(2, 10, true);
        final PageInfo<UserPO> userPageInfo = new PageInfo<>(this.userMapper.findByUsername("user1", new ArrayList<>()));
        logger.info("[普通写法] - [{}]", userPageInfo);
        for (UserPO item : userPageInfo.getList()) {
            logger.info(item.getId()+":"+item.getUsername());
        }
        logger.info(userPageInfo.getTotal()+"");

    }
}
