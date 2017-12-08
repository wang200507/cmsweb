package com.dse.cms.web.repository;

import com.dse.cms.web.entity.WeChatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-12-08
 */
@Repository
public interface WechatImageRepository extends JpaRepository<WeChatImage,Integer> {

    @Query(value = "select t.* from tb_wechatimage t where t.wechat_id = ?1" ,nativeQuery = true)
    List<WeChatImage> getWeChatImages(Integer weChatId);

}
