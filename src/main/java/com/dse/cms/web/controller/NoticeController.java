package com.dse.cms.web.controller;

import com.dse.cms.web.service.NoticeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * 集团通知controller
 *
 * @author wangzy
 * @date 2017-12-04
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService ;

    /**
     * 获取集团通知列表
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public List getNoticeList(){
        List list = noticeService.getList();
        return  list ;
    }

}


