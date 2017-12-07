package com.dse.cms.web.controller;

import com.dse.cms.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


