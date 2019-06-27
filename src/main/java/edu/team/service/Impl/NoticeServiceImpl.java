package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import edu.team.dao.NoticeDao;
import edu.team.entity.Document;
import edu.team.service.NoticeService;

/**
 * @author dailiwen
 * @date 2019/06/26
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDao noticeDao;

    @Override
    public List<Document> findAllNotice() {
        return null;
    }

    @Override
    public List<Document> findNoticeFromTitle(String title) {
        return null;
    }

    @Override
    public Document findNoticeFromId(Integer id) {
        return null;
    }

    @Override
    public String deleteNoticeFromId(Integer id) {
        return null;
    }

    @Override
    public String addNotice(String title, String content, Integer userId) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            noticeDao.addNotice(title, content, timestamp, userId);
            return "SUCCESS";
        } catch (Exception e) {
            return "FAIL";
        }
    }


    @Override
    public String updateNotice(String title, String createData, String userId, String remake, String id) {
        return null;
    }
}
