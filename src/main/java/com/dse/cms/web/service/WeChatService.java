package com.dse.cms.web.service;

import com.dse.cms.web.entity.WeChat;
import com.dse.cms.web.entity.WeChatImage;
import com.dse.cms.web.framework.utils.Config;
import com.dse.cms.web.framework.utils.ImageUtil;
import com.dse.cms.web.repository.WechatImageRepository;
import com.dse.cms.web.repository.WechatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-12-08
 */
@Service
public class WeChatService {

    @Autowired
    private WechatRepository wechatRepository;
    @Autowired
    private WechatImageRepository wechatImageRepository;



    public List<WeChat> getWeChatList(HttpServletRequest request,String startDate , String  endDate){
        List<WeChat> list = wechatRepository.getWeChatsList(startDate,endDate);
        // 取到项目部署的绝对路径
        String basePath =  request.getSession().getServletContext().getRealPath("/");
        String imagePath  = "/img/wx/";
//        String imgpath = Config.getString("upload.root.path");
        if(list.size() > 0 ){
            for (WeChat weChat : list){
                byte[] bytes= weChat.getImages() ;
                String imgageName = weChat.getId()+".jpg";
                ImageUtil.readBin2Image(ImageUtil.byte2Input(bytes),basePath+imagePath+imgageName);
                weChat.setImages(null);
                weChat.setImgUrl(imagePath+imgageName);

            }
        }
        return  list;
    }

    public List getImagesByWechat(HttpServletRequest request,Integer weChatId){

        String basePath =  request.getSession().getServletContext().getRealPath("/");
        String imagePath  = "/img/wx/";
        List<WeChatImage> list = wechatImageRepository.getWeChatImages(weChatId);
//        String imgpath = Config.getString("upload.root.path");
        if(list.size() > 0 ){
            for (WeChatImage weChatImage : list){
                byte[] bytes= weChatImage.getImages() ;
                String imgageName = weChatImage.getWeChat().getId()+"_"+weChatImage.getId()+".jpg";
                ImageUtil.readBin2Image(ImageUtil.byte2Input(bytes),basePath+imagePath+imgageName);
                weChatImage.setImages(null);
                weChatImage.setWeChat(null);
                weChatImage.setImgUrl(imagePath+imgageName);
            }
        }

        return list ;

    }


    public WeChat findById(Integer id){
        return wechatRepository.findOne(id);
    }


}
