package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

import edu.team.entity.Document;

/**
 *
 * @author dailiwen
 * @date 2019/06/25
 */
@Mapper
public interface DocumentDao {
     List<Document> findAllDocument();

     List<Document> findDocumentFromTitle(String title);

     void deleteDocumentFromId(Integer id);

     void addDocument(String title, String fileName, String remake, Timestamp createData, Integer userId);

     void updateDocument(String title, String createData, String userId, String remake, String id);
}
