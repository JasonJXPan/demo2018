package com.pjx.demo2018.service;

import com.pjx.demo2018.po.UserPO;

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

}
