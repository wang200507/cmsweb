package com.dse.cms.web.service;

import com.dse.cms.web.entity.WeChat;
import com.dse.cms.web.entity.WeChatImage;
import com.dse.cms.web.framework.utils.Config;
import com.dse.cms.web.framework.utils.ImageUtil;
import com.dse.cms.web.repository.WechatImageRepository;
import com.dse.cms.web.repository.WechatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


    public List<WeChat> getWeChatList(String startDate , String  endDate){
//       String basePath  = HttpServletRequest.getRequestURI();
        List<WeChat> list = wechatRepository.getWeChatsList(startDate,endDate);
//        List<WeChat> list = wechatRepository.findAll();
        String imgpath = Config.getString("upload.root.path");
        if(list.size() > 0 ){
            for (WeChat weChat : list){
                byte[] bytes= weChat.getImages() ;
                String imgUrl = imgpath+weChat.getId()+".jpg";
                ImageUtil.readBin2Image(ImageUtil.byte2Input(bytes),imgUrl);
                weChat.setImages(null);
                weChat.setImgUrl(imgUrl);

            }
        }
        return  list;
    }

    public List getImagesByWechat(Integer weChatId){

        List<WeChatImage> list = wechatImageRepository.getWeChatImages(weChatId);
        String imgpath = Config.getString("upload.root.path");
        if(list.size() > 0 ){
            for (WeChatImage weChatImage : list){
                byte[] bytes= weChatImage.getImages() ;

                String imgUrl = imgpath+weChatImage.getWeChat().getId()+"_"+weChatImage.getId()+".jpg";
                ImageUtil.readBin2Image(ImageUtil.byte2Input(bytes),imgUrl);
                weChatImage.setImages(null);
                weChatImage.setWeChat(null);
                weChatImage.setImgUrl(imgUrl);

            }
        }

        return list ;

    }


    public WeChat findById(Integer id){
        return wechatRepository.findOne(id);
    }


}
