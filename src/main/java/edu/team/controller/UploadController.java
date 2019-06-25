package edu.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.team.entity.Document;
import edu.team.service.DocumentService;
import edu.team.util.EntityIDFactory;
import edu.team.util.MessageFactory;

/**
 * @author dailiwen
 * @date 2019/06/25
 */
@RestController
public class UploadController {

    @Autowired
    DocumentService documentService;

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String upload(String docTitle, String docDetail, MultipartFile docFile, HttpSession session) {
        if (docFile.isEmpty()) {
            // "上传失败，请选择文件";
            return "FAIL";
        }

        String fileName = docFile.getOriginalFilename();  // 文件名
        String filePath = "D://CsiFile//"; // 上传后的路径
        fileName = EntityIDFactory.createId() + "-" + fileName; // 新文件名
        File localFile = new File(filePath + fileName);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        try {
            docFile.transferTo(localFile);
            //System.out.println("上传成功");
            Timestamp timestamp = new Timestamp(new Date().getTime());
            String result = documentService.addDocument(docTitle, docFile.getOriginalFilename(), docDetail, timestamp, 1);
            if ("SUCCESS".equals(result)) {
                return "SUCCESS";
            } else {
                return "FAIL";
            }
        } catch (IOException e) {
            System.out.println("上传失败 - " + e);
        }
        return "FAIL";
    }

    @RequestMapping(value = "getAllDocument", method = RequestMethod.GET)
    public List<Document> getAllDocument() {
        return documentService.findAllDocument();
    }
}
