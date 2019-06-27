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
import edu.team.entity.Notice;
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
        String result = noticeService.addNotice(title, content, Integer.valueOf((String) session.getAttribute("loginId")));
        if ("SUCCESS".equals(result)) {
            return JacksonUtil.objectToJson("SUCCESS");
        } else {
            return JacksonUtil.objectToJson("FAIL");
        }
    }

    @RequestMapping(value = "getAllNotice", method = RequestMethod.POST)
    public PageInfo<Notice> getAllNotice(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(noticeService.findAllNotice());
        return pageInfo;
    }

    @RequestMapping(value = "getNoticeFromInfo", method = RequestMethod.POST)
    public PageInfo<Notice> getNoticeFromInfo(String title, String content, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        if (("".equals(title) && "".equals(content)) || (null == title && null == content)) {
            return new PageInfo<Notice>(noticeService.findAllNotice());
        } else {
            return new PageInfo<Notice>(noticeService.getNoticeFromInfo(title, content));
        }
    }

    @RequestMapping(value = "deleteNoticeFromId", method = RequestMethod.POST)
    public String deleteNoticeFromId(String ids) {
        String result;
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            result = noticeService.deleteNoticeFromId(Integer.valueOf(id[i]));
            if ("FAIL".equals(result)) {
                return JacksonUtil.objectToJson("FAIL");
            }
        }
        return JacksonUtil.objectToJson("SUCCESS");
    }

    @RequestMapping(value = "getNoticeFromId", method = RequestMethod.POST)
    public Notice getNoticeFromId(String id) {
        return noticeService.findNoticeFromId(Integer.valueOf(id));
    }

    @RequestMapping(value = "updateNoticeFromId", method = RequestMethod.POST)
    public String updateNoticeFromId(String id, String title, String content, HttpSession session) {
        String result = addNotice(title, content, session);
        if (JacksonUtil.objectToJson("SUCCESS").equals(result)) {
            result = deleteNoticeFromId(id);
            if (JacksonUtil.objectToJson("SUCCESS").equals(result))
                return JacksonUtil.objectToJson("SUCCESS");
        }
        return JacksonUtil.objectToJson("FAIL");
    }
}
