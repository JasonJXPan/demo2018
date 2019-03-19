package com.pjx.demo2018.mapper;

import com.pjx.demo2018.po.PurchPo;
import com.pjx.demo2018.po.UserPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

/**
 *
 * @author juqi
 * @date 18/6/2
 */
@Mapper
//开启 当前namespace的缓存  只有当所有的配置都用注解或者都用xml时才会生效
// List<UserPO> findWithIpLog(@Param("id") Long id, @Param("id1") Long id1); 不会生效，即使是加了支持缓存的注解
@CacheNamespace
public interface UserMapper {


    @Select("select t.orderOID as id, t.overdue_deadline as overdue from tm_purchase_order t where t.orderNumber='8118011181698'")
    PurchPo findPoById();


//    @Select("select t.orderOID as id, t.overdue_deadline as overdue from tm_purchase_order t where t.orderNumber='8118011181698'")
//    List<PurchPo> findPoByIds();

    /**
     * @param id
     * @param id1
     * @return
     */
    @Results(id = "res",value={
            @Result(column = "id", property ="id" ),
            @Result(column = "username", property ="username" ),
            @Result(column = "password", property ="password" ),
            @Result(column = "id", property = "userIPPOS",
                    one = @One(select = "com.pjx.demo2018.mapper.UserIPMapper.findByUserId", fetchType = FetchType.LAZY))
    })
    @Select("select * from t_user t where t.id in (#{id}, #{id1})")
    @Options(useCache = false)
    List<UserPO> findById(@Param("id") Long id, @Param("id1") Long id1);

    /**
     * @param id
     * @param name
     * @return
     */
    @Update("update t_user t set t.username=#{name} where t.id=#{id}")
    boolean updateNameById(@Param("id") Long id, @Param("name") String name);

    /**
     * @param id
     * @param id1
     * @return
     */
    //缓存不生效 因为这是注解和xml混用
    @Options(useCache = true)
    List<UserPO> findWithIpLog(@Param("id") Long id, @Param("id1") Long id1);

    /**
     * 根据用户名查询用户结果集
     *
     * @param username 用户名
     * @return 查询结果
     */
    @Select("<script>SELECT username,id FROM t_user " +
            "WHERE 1=1 " +
            "<if test='username != null'>" +
            " AND username = #{username} " +
            "</if> " +
            "<if test='list != null and list.size >0'>" +
            " <foreach index='index' item='item' open='(' close=')' separator=',' >" +
            "   #{item}" +
            " </foreach>" +
            "</if>"  +
            " order by id desc </script>")
    List<UserPO> findByUsername(@Param("username") String username,
                                @Param("list") List<String> list);


    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 成功 1 失败 0
     */
    int insert(UserPO user);

    /**
     * 根据用户名统计（假设它是一个很复杂的SQL）
     *
     * @param username 用户名
     * @return 统计结果
     */
    @Select("SELECT count(1) FROM t_user WHERE username = #{username}")
    int countByUsername(@Param("username")String username);

    /**
     * mybatis一对一查询
     * 当前类：com.juqitech.service.mapper.PurchaseOrderMapper
     */
//    @Select("select recovery_req_oid as recoveryRequestOID, purchase_oid as purchaseOrderOID " +
//            " from tm_purchase_order_recovery_request where tm_purchase_order_recovery_request.recovery_req_oid=#{id}")
//    @Results(value = {
//            @Result(property="purchaseOrderVO",column="purchaseOrderOID", javaType = PurchaseOrderVO.class,
//                    one = @One(select = "com.juqitech.service.mapper.PurchaseOrderMapper.getPurchaseOrderByID"))
//    })
//    PoRecoveryDetailDTO getRecoveryRequestByID(@Param("id") String id);
//
//    /**
//     * 测试
//     * @param id
//     * @return
//     */
//    @Select("select orderOID as purchaseOrderOID from tm_purchase_order where orderOID =#{id}")
//    PurchaseOrderVO getPurchaseOrderByID(@Param("id") String id);

    /**
     * PoRecoveryDetailDTO 类
     */
//    public class PoRecoveryDetailDTO {
//        private String recoveryRequestOID;
//        private String purchaseOrderOID;
//        private PurchaseOrderVO purchaseOrderVO;
//        //getter and setter
//    }

}
