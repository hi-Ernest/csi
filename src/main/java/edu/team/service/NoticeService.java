package edu.team.service;

import java.util.List;

import edu.team.entity.Notice;

/**
 *
 * @author dailiwen
 * @date 2019/06/25
 */
public interface NoticeService {
    List<Notice> findAllNotice();

    List<Notice> getNoticeFromInfo(String title, String content);

    Notice findNoticeFromId(Integer id);

    String deleteNoticeFromId(Integer id);

    String addNotice(String title, String content, Integer userId);

    String updateNotice(String title, String createData, String userId, String remake, String id);
}
