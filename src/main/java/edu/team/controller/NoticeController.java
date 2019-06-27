package edu.team.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.team.entity.Document;
import edu.team.service.DocumentService;
import edu.team.service.NoticeService;
import edu.team.util.EntityIDFactory;
import edu.team.util.JacksonUtil;

/**
 * @author dailiwen
 * @date 2019/06/25
 */
@RestController
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "addNotice", method = RequestMethod.POST)
    public String addNotice(String title, String content, HttpSession session) {
        String result = noticeService.addNotice(title, content, Integer.valueOf((String) session.getAttribute("id")));
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }
}
