package com.dse.cms.web.repository;

import com.dse.cms.web.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 集团通知的DAO
 *
 * @author wangzy
 * @date 2017-12-04
 */
@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {


    List getNoticesByDeletedIsOrderByCreateTimeDesc(Integer deleted);
    List getNoticesByDeletedIsAndIsPubIsOrderByCreateTimeDesc(Integer deleted,Integer ispub);
}
