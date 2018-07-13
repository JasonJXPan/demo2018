package com.pjx.demo2018.mapper;

import com.pjx.demo2018.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 * @author juqi
 * @date 18/6/2
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户结果集
     *
     * @param username 用户名
     * @return 查询结果
     */
    @Select("SELECT * FROM t_user WHERE username = #{username} order by id desc")
    List<UserPO> findByUsername(@Param("username") String username);


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
