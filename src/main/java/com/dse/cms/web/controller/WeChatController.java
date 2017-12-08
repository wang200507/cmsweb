package com.dse.cms.web.controller;

import com.dse.cms.web.entity.WeChat;
import com.dse.cms.web.framework.utils.DateUtil;
import com.dse.cms.web.framework.utils.DseResult;
import com.dse.cms.web.framework.utils.Utility;
import com.dse.cms.web.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-12-08
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 获取当前日期往前推10天的微信数据
     * @return
     */
    @RequestMapping("/getWechatList")
    @ResponseBody
    public DseResult getList(){
        DseResult result = null ;
        try {
//            List list = weChatService.getWeChatList(DateUtil.getNowDate(),DateUtil.dateToString(DateUtil.dateIncreaseByDay(DateUtil.getNowDate(),-10)));
            result = DseResult.success(weChatService.getWeChatList(DateUtil.dateToString(DateUtil.dateIncreaseByDay(DateUtil.getNowDate(),-10)),DateUtil.dateToString(DateUtil.getNowDate())));
        }catch (Exception e){
            e.printStackTrace();
            result = DseResult.faild("获取数据失败");
        }
        return result ;
    }

    @RequestMapping("/getWechatImages")
    @ResponseBody
    public DseResult getWechatImages(String id){
        DseResult result = null ;
        if (Utility.isEmpty(id)){
            return DseResult.faild("id不能为空！");
        }
        try {
            result = DseResult.success(weChatService.getImagesByWechat(Integer.valueOf(id)));
        }catch (Exception e){
            e.printStackTrace();
            result = DseResult.faild("获取数据失败");
        }
        return result ;
    }

}
