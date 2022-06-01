package com.star.service;

import com.star.entity.Admin;


/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2022-05-31 21:19:40
 */
public interface AdminService {

    //    登录方法
    Admin login(Admin admin);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


}
