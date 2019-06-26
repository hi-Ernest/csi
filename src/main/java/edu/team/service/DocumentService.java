package edu.team.service;

import java.sql.Timestamp;
import java.util.List;

import edu.team.entity.Document;

/**
 * @author dailiwen
 * @date 2019/06/25
 */

public interface DocumentService {
    List<Document> findAllDocument();

    List<Document> findDocumentFromTitle(String title);

    Document findDocumentFromId(Integer id);

    String deleteDocumentFromId(Integer id);

    String addDocument(String title, String fileName, String remake, Timestamp createData, Integer userId);

    String updateDocument(String title, String createData, String userId, String remake, String id);
}
