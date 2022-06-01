package com.star.dao;

import com.star.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 小辣鸡
 */
//@Mapper
public interface UserDao {
    /**
     * 根据分页查询
     */
    List<User> findAllByKeywords(@Param("offset") int offset, @Param("limit") int limit, @Param("id") String id, @Param("name") String name, @Param("phone") String phone);

    /**
     * 根据条件查询总条数
     */
    Long findTotalCountsByKeywords(@Param("id") String id, @Param("name") String name, @Param("phone") String phone);


}
