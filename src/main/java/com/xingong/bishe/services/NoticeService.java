package com.xingong.bishe.services;

import com.xingong.bishe.dao.NoticeDao;
import com.xingong.bishe.entitys.NoticeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liekkas on 2018/5/3.
 */
@Service
@Transactional
public class NoticeService {
    @Autowired
    NoticeDao noticeDao;

    public List<NoticeEntity> queryNotice(String userid) {
        List<NoticeEntity> noticeList = noticeDao.noticeList(userid);
        return noticeList;
    }

}
