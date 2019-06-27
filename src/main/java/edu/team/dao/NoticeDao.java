package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

import edu.team.entity.Notice;

/**
 *
 * @author dailiwen
 * @date 2019/06/25
 */
@Mapper
public interface NoticeDao {
     List<Notice> findAllNotice();

     List<Notice> findNoticeFromInfo(String title, String content);

     Notice findNoticeFromId(Integer id);

     String findUserNameFromId(Integer id);

     void deleteNoticeFromId(Integer id);

     void addNotice(String title, String content, Timestamp createDate, Integer userId);

     void updateNotice(String title, String createData, String userId, String remake, String id);
}
