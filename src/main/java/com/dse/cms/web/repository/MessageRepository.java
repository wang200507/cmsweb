package com.dse.cms.web.repository;

import com.dse.cms.web.entity.TbMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/2.
 */
@Repository
public interface MessageRepository extends JpaRepository<TbMessage, String> {

    /**
     * 分页获取所有有效数据
     * @param deleted
     * @param pageable
     * @return
     */
    Page<TbMessage> findAllByDeletedIs(Integer deleted, Pageable pageable);

    /**
     * 获取所有数据，不用分页
     * @param deleted
     * @return
     */
    List findAllByDeletedIs(Integer deleted);


}
