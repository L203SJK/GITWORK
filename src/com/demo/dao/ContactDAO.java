package com.demo.dao;

import com.demo.vo.Contact;

import java.io.Serializable;
import java.util.Map;

/**
 * Contact模块的DAO层（数据层）接口，提供增删改查等数据库操作的方法抽象
 */
public interface ContactDAO {
    /**
     * 增加联系人表记录
     *
     * @param vo
     * @return
     */
    void add(Contact vo);

    /**
     * 根据主键id，删除对应的联系人表记录
     *
     * @param id
     * @return
     */
    boolean delete(long id);

    /**
     * 更新联系人表记录
     *
     * @param vo
     * @return
     */
    void update(Contact vo);

    /**
     * 根据主键id获取联系人表记录的详情
     *
     * @param id
     * @return
     */
    Contact get(Serializable id);

    /**
     * 根据条件查询联系人的列表与数量
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);
}
