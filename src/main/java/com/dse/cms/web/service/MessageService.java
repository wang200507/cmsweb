package com.dse.cms.web.service;

import com.dse.cms.web.entity.TbMessage;
import com.dse.cms.web.framework.utils.Constants;
import com.dse.cms.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-11-29
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public TbMessage getMessage(String id){
        return messageRepository.findOne(id);
    }

    public List getList(){
        return messageRepository.findAllByDeletedIs(Constants.DELETED_NO);
    }

    public Page<TbMessage> listAll(Pageable page){
        Page<TbMessage> pageList = messageRepository.findAllByDeletedIs(Constants.DELETED_NO,page);
        return  pageList;

    }

}
