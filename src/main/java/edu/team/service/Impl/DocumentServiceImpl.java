package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import edu.team.dao.DocumentDao;
import edu.team.entity.Document;
import edu.team.service.DocumentService;

/**
 * @author dailiwen
 * @date 2019/06/25
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentDao documentDao;

    @Override
    public List<Document> findAllDocument() {
        return documentDao.findAllDocument();
    }

    @Override
    public List<Document> findDocumentFromTitle(String title) {
        return null;
    }

    @Override
    public String deleteDocumentFromId(Integer id) {
        return null;
    }

    @Override
    public String addDocument(String title, String fileName, String remake, Timestamp createData, Integer userId) {
        try {
            documentDao.addDocument(title, fileName, remake, createData, userId);
            return "SUCCESS";
        } catch (Exception e) {
            //System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public String updateDocument(String title, String createData, String userId, String remake, String id) {
        return null;
    }
}
