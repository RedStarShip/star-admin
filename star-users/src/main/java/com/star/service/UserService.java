package com.star.service;

import com.star.entity.User;

import java.util.List;

/**
 * @author 小辣鸡
 */

public interface UserService {
    /**
     * 根据条件分页查询
     */
    List<User> findAllByKeywords(int offset, int limit, String id, String name, String phone);

    /**
     * 根据条件查询总条数
     */
    Long findTotalCountsByKeywords(String id, String name, String phone);

}
