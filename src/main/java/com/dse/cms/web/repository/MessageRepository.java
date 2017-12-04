package com.dse.cms.web.repository;

import com.dse.cms.web.entity.TbMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/12/2.
 */
public interface MessageRepository extends JpaRepository<TbMessage, String> {

}
