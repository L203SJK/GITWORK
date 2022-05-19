package com.demo.service.impl;

import com.demo.dao.ContactDAO;
import com.demo.dao.impl.ContactDAOImpl;
import com.demo.service.ContactService;
import com.demo.vo.Contact;

import java.io.Serializable;
import java.util.Map;

/**
 * Contact模块的Service层（业务层）的具体实现类，对ContactService接口中定义的抽象方法作出具体的功能实现
 */
public class ContactServiceImpl implements ContactService {
    //@Override
    public void add(Contact vo) {
        ContactDAO contactDAO = new ContactDAOImpl();
        contactDAO.add(vo);
    }

    //@Override
    public void delete(long id) {
        ContactDAO contactDAO = new ContactDAOImpl();
        contactDAO.delete(id);
    }

    //@Override
    public void update(Contact vo) {
        ContactDAO contactDAO = new ContactDAOImpl();
        contactDAO.update(vo);
    }

    //@Override
    public Contact get(Serializable id) {
        ContactDAO contactDAO = new ContactDAOImpl();
        return contactDAO.get(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        ContactDAO contactDAO = new ContactDAOImpl();
        return contactDAO.list(params);
    }
}
