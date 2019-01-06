package com.pjx.demo2018.mapper;

import com.pjx.demo2018.po.UserIPPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/1/6
 */
@Mapper
@CacheNamespace
public interface UserIPMapper {

    @Results({
            @Result(column = "id", property = "userIpid"),
            @Result(column = "ip", property = "ip"),
            @Result(column = "user_id", property = "userId"),
    })
    @Select("select * from t_user_ip_log where user_id=#{userId}")
    List<UserIPPO> findByUserId(@Param("userId")String userId);
}
