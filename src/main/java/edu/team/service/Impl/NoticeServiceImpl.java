package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import edu.team.dao.NoticeDao;
import edu.team.entity.Notice;
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
    public List<Notice> findAllNotice() {
        List<Notice> notices = noticeDao.findAllNotice();
        for (int i = 0; i < notices.size(); i++) {
            notices.get(i).setUserName(noticeDao.findUserNameFromId(notices.get(i).getUserId()));
        }
        return notices;
    }

    @Override
    public List<Notice> getNoticeFromInfo(String title, String content) {
        List<Notice> notices = noticeDao.findNoticeFromInfo(title, content);
        for (int i = 0; i < notices.size(); i++) {
            notices.get(i).setUserName(noticeDao.findUserNameFromId(notices.get(i).getUserId()));
        }
        return notices;
    }

    @Override
    public Notice findNoticeFromId(Integer id) {
        return noticeDao.findNoticeFromId(id);
    }

    @Override
    public String deleteNoticeFromId(Integer id) {
        try {
            noticeDao.deleteNoticeFromId(id);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
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
