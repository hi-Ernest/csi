package edu.team.service;

import java.sql.Timestamp;
import java.util.List;

import edu.team.entity.Document;

/**
 *
 * @author dailiwen
 * @date 2019/06/25
 */
public interface NoticeService {
    List<Document> findAllNotice();

    List<Document> findNoticeFromTitle(String title);

    Document findNoticeFromId(Integer id);

    String deleteNoticeFromId(Integer id);

    String addNotice(String title, String content, Integer userId);

    String updateNotice(String title, String createData, String userId, String remake, String id);
}
