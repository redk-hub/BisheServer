package com.xingong.bishe.services;

import com.xingong.bishe.dao.UserDao;
import com.xingong.bishe.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户逻辑类
 */

@Service
@Transactional
public class UserService {

    //自动注入
    @Autowired
    UserDao userDao;

    /**
     * 根据用户id查询用户信息
     * @param userid
     * @return
     */
    public UserEntity getUserById(String userid){
        return userDao.getUserById(userid);
    }

    /**
     * 用户注册
     * @param userEntity
     */
    public void register(UserEntity userEntity){
        userDao.save(userEntity);
    }

    public void update(UserEntity userEntity){
        userDao.saveAndFlush(userEntity);
    }
}
