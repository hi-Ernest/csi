package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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
        List<Document> documents = documentDao.findAllDocument();
        for (int i = 0; i < documents.size(); i++) {
            documents.get(i).setUserName(documentDao.findUserNameFromId(documents.get(i).getUserId()));
        }
        return documents;
    }

    @Override
    public List<Document> findDocumentFromTitle(String title) {
        List<Document> documents = documentDao.findDocumentFromTitle(title);
        for (int i = 0; i < documents.size(); i++) {
            documents.get(i).setUserName(documentDao.findUserNameFromId(documents.get(i).getUserId()));
        }
        return documents;
    }

    @Override
    public Document findDocumentFromId(Integer id) {
        return documentDao.findDocumentFromId(id);
    }

    @Override
    public String deleteDocumentFromId(Integer id) {
        Document document = documentDao.findDocumentFromId(id);
        String filePath = "D://CsiFile//";
        String fileName = document.getFileName();
        File file = new File(filePath + fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return "FAIL";
        } else {
            if (file.isFile()) {
                if (!deleteFile(filePath + fileName)) {
                    return "FAIL";
                }
            }
        }
        try {
            documentDao.deleteDocumentFromId(id);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
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

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}
