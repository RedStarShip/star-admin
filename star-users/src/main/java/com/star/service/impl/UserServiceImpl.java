package com.star.service.impl;

import com.star.dao.UserDao;
import com.star.entity.User;
import com.star.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS) //SUPPORTS 支持事务： 外层存在事务融入当前事务  外层不存在事务 不会开启新的事务
    public List<User> findAllByKeywords(int offset, int limit, String id, String name, String phone) {
        int start = (offset - 1) * limit;
        return userDao.findAllByKeywords(start, limit, id, name, phone);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findTotalCountsByKeywords(String id, String name, String phone) {
        return this.userDao.findTotalCountsByKeywords(id, name, phone);
    }
}
