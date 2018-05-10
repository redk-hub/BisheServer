package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserDao
 */
public interface UserDao extends JpaRepository<UserEntity,String>{

    @Query("SELECT t FROM UserEntity t where t.username = ?1")
    public UserEntity getUserInfo(String username);

    @Query("select t from UserEntity  t where t.userid = ?1")
    public UserEntity getUserById(String userid);

    @Transactional
    @Modifying(clearAutomatically = true)//清除jpa的一级缓存,能实时刷新数据
    @Query(value = "update user t set t.password = ?1 where t.username = ?2",nativeQuery = true)
    public void modifyPassword(String password,String username);


    @Query("select t from UserEntity t where t.role = ?1 and t.collegeid = ?2")
    public Page<UserEntity> queryPageByRole(int role,int collegeid, Pageable pageable);
}
