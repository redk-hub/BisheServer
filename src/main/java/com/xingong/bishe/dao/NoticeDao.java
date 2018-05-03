package com.xingong.bishe.dao;

import com.xingong.bishe.entitys.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liekkas on 2018/5/3.
 */
public interface NoticeDao extends JpaRepository<NoticeEntity,String> {
    @Query("select t from NoticeEntity t where t.userid=?1")
    public List<NoticeEntity> noticeList(String userid);
        }
