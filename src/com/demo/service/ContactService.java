package com.demo.service;

import com.demo.vo.Contact;

import java.io.Serializable;
import java.util.Map;

/**
 * Contact模块的Service层（业务层）接口，提供业务方法的抽象
 */
public interface ContactService {
    /**
     * 增加联系人
     *
     * @param vo
     * @return
     */
    void add(Contact vo);

    /**
     * 删除联系人
     *
     * @param id
     * @return
     */
    void delete(long id);

    /**
     * 修改联系人
     *
     * @param vo
     * @return
     */
    void update(Contact vo);

    /**
     * 根据主键Id查询联系人详情
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
