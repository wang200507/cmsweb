package com.dse.cms.web.repository;

import com.dse.cms.web.entity.WeChat;
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
public interface WechatRepository extends JpaRepository<WeChat,Integer>{

    @Query("select t from WeChat t where  t.datetime  between ?1 and ?2 order by t.datetime desc ")
    List<WeChat> getWeChatsList(String startDate,String endDate);


    List<WeChat> findAll();

//    WeChat getById();
}
