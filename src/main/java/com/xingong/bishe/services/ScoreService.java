package com.xingong.bishe.services;

import com.xingong.bishe.dao.ScoreDao;
import com.xingong.bishe.entitys.DefenceManageEntity;
import com.xingong.bishe.entitys.ScoreManageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhang on 2018/5/10.
 */
@Service
@Transactional
public class ScoreService {

    @Autowired
    ScoreDao scoreDao;

    public ScoreManageEntity query(String studentid){
        return scoreDao.queryByStuid(studentid);
    }

    //分页查询老师所带的学生
    public Page<ScoreManageEntity> findAllByPage(String teacherid, Pageable pageable){
        if (teacherid.equals("")){
            return scoreDao.findAll(pageable);
        }else {
            return scoreDao.queryScorePage(teacherid,pageable);
        }
    }

    public void commitScore(ScoreManageEntity param){
        ScoreManageEntity scoreManageEntity = scoreDao.queryByStuid(param.getStudentid());
        scoreManageEntity.setDefencescore(param.getDefencescore());
        scoreManageEntity.setPaperscore(param.getPaperscore());
        scoreManageEntity.setTotalscore(param.getTotalscore());
        scoreManageEntity.setIsrecommend(param.getIsrecommend());
        scoreDao.save(scoreManageEntity);
    }
    public void recommend(String studentid ,int recommend){
        ScoreManageEntity scoreManageEntity = scoreDao.queryByStuid(studentid);
        scoreManageEntity.setIsrecommend(recommend);
        scoreDao.save(scoreManageEntity);
    }

    public Page<ScoreManageEntity> findGoodByPage(int state, Pageable pageable){
        return scoreDao.queryGoodPage(state,pageable);
    }

}
