package com.dse.cms.web.service;

import com.dse.cms.web.framework.utils.Constants;
import com.dse.cms.web.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-12-04
 */
@Service
public class NoticeService {

    @Autowired
    public NoticeRepository noticeRepository;

    public List getList(){
        List  list  = noticeRepository.getNoticesByDeletedIsOrderByCreateTimeDesc(Constants.DELETED_NO);
        return list;
    }

}
