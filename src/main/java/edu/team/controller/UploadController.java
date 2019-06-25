package edu.team.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import edu.team.util.EntityIDFactory;

/**
 * @author dailiwen
 * @date 2019/06/25
 */
@RestController
public class UploadController {

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String upload(String docTitle, String docDetail, MultipartFile docFile) {
        if (docFile.isEmpty()) {
            // "上传失败，请选择文件";
            return "FAIL！";
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
            return "SUCCESS";
        } catch (IOException e) {
            System.out.println("上传失败 - " + e);
        }
        return "FAIL！";
    }
}
