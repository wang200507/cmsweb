package com.dse.cms.web.controller;

import com.dse.cms.web.entity.TbMessage;
import com.dse.cms.web.framework.utils.DseResult;
import com.dse.cms.web.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页滚动消息
 *
 * @author wangzy
 * @date 2017-11-29
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageSerive;

    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        System.out.println("121klnlsadlk");
        return "menu";
    }

    /**
     * @param pid
     * @return
     */
    @RequestMapping("/getObjById")
    @ResponseBody
    public Object getObjById(String pid){
        DseResult dse = null;
        try {
            TbMessage message = messageSerive.getMessage(pid);
            System.out.println(message);
        } catch (Exception e) {
            dse = DseResult.faild(e.getMessage());
        }
        return dse;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public List getList(){

        List list = messageSerive.getList();
        System.out.println(list);
        return  messageSerive.getList();
    }
}
