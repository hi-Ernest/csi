package edu.team.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.team.entity.Document;
import edu.team.service.DocumentService;
import edu.team.util.EntityIDFactory;
import edu.team.util.JacksonUtil;

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
            String result = documentService.addDocument(docTitle, fileName, docDetail, timestamp, Integer.valueOf((String) session.getAttribute("loginId")));
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

    @RequestMapping(value = "getAllDocument", method = RequestMethod.POST)
    public PageInfo<Document> getAllDocument(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        PageInfo<Document> pageInfo = new PageInfo<Document>(documentService.findAllDocument());
        return pageInfo;
    }

    @RequestMapping(value = "getDocumentFromTitle", method = RequestMethod.POST)
    public PageInfo<Document> getDocumentFromTitle(String title, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        if ("".equals(title) || null == title) {
            return new PageInfo<Document>(documentService.findAllDocument());
        } else {
            return new PageInfo<Document>(documentService.findDocumentFromTitle(title));
        }
    }

    @RequestMapping(value = "deleteDocumentFromId", method = RequestMethod.POST)
    public String deleteDocumentFromId(String ids) {
        String result;
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            result = documentService.deleteDocumentFromId(Integer.valueOf(id[i]));
            if ("FAIL".equals(result)) {
                return JacksonUtil.objectToJson("FAIL");
            }
        }
        return JacksonUtil.objectToJson("SUCCESS");
    }

    @GetMapping("download")
    public String downloadFile(HttpServletResponse response, String id) {
        Document document = documentService.findDocumentFromId(Integer.valueOf(id));
        String filePath = "D://CsiFile//";
        String fileName = document.getFileName();
        if (fileName != null) {
            //设置文件路径
            File file = new File(filePath + fileName);
            if (file.exists()) {
                //去掉固定长度前缀
                fileName = fileName.substring(18, fileName.length());
                try {
                    response.reset();// 清空输出流
                    fileName = URLEncoder.encode(fileName, "UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-disposition", "attachment; filename=" + fileName);// 设定输出文件头
                    response.setContentType("application/octet-stream");// 定义输出类型
                    //输入流：本地文件路径
                    DataInputStream in = new DataInputStream(
                            new FileInputStream(file));
                    //输出流
                    OutputStream out = response.getOutputStream();
                    //输出文件
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    out.close();
                    in.close();
                    return JacksonUtil.objectToJson("SUCCESS");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.reset();
                    try {
                        OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
                        String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
                        writer.write(data);
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return JacksonUtil.objectToJson("FAIL");
    }
}
