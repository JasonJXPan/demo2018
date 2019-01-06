package com.pjx.demo2018.service;

import com.pjx.demo2018.po.UserPO;

import java.util.List;

/**
 *
 * @author juqi
 * @date 18/6/3
 */
public interface UserService {
    /**
     * 新建或者更新user
     *
     * @param user
     * @return
     */
    UserPO saveOrUpdate(UserPO user);

    /**
     * 查询
     *
     * @param id key值
     * @return 返回结果
     */
    UserPO get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);


    /**
     * @param id
     * @return
     */
    List<UserPO> findById(Long id, Long id1);

    /**
     * @param id
     * @param id1
     * @return
     */
    List<UserPO> findWithIpLog(Long id, Long id1);

    List<UserPO> findByUsername(String username,
                                List<String> list);
}
