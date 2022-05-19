package com.demo.dao.impl;

import com.demo.util.Util;
import com.demo.dao.ContactDAO;
import com.demo.vo.Contact;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contact模块的DAO层（数据层）的具体实现类，对ContactDAO接口中定义的增删改查等抽象方法作出具体的功能实现
 */
public class ContactDAOImpl implements ContactDAO {

    //@Override
    public void add(Contact vo) {
        String sql = "insert into `t_contact` (`contact_name`,`contact_sex`,`contact_type`,`contact_phone`,`contact_address`,`contact_text`) values(?,?,?,?,?,?)";
        try {
            Connection c = Util.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, vo.getContactName());
            ps.setString(2, vo.getContactSex());
            ps.setString(3, vo.getContactType());
            ps.setString(4, vo.getContactPhone());
            ps.setString(5, vo.getContactAddress());
            ps.setString(6, vo.getContactText());
            ps.execute();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Override
    public void update(Contact vo) {
        String sql = "update `t_contact` set `contact_name` = ? ,`contact_sex` = ? ,`contact_type` = ? ,`contact_phone` = ? ,`contact_address` = ? ,`contact_text` = ?  where `id` = ?";
        try {
            Connection c = Util.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            
            ps.setString(1, vo.getContactName());
            ps.setString(2, vo.getContactSex());
            ps.setString(3, vo.getContactType());
            ps.setString(4, vo.getContactPhone());
            ps.setString(5, vo.getContactAddress());
            ps.setString(6, vo.getContactText());
            ps.setLong(7, vo.getId());
            ps.execute();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Override
    public boolean delete(long id) {
        try {
            Connection c = Util.getConnection();
            Statement s = c.createStatement();
            String sql = "delete from `t_contact` where id = " + id;
            s.execute(sql);
            s.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //@Override
    public Contact get(Serializable id) {
        Contact vo = null;
        try {
            Connection c = Util.getConnection();
            Statement s = c.createStatement();
            String sql = "select * from `t_contact` where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                vo = new Contact();
                vo.setId(rs.getLong("id"));
                vo.setContactName(rs.getString("contact_name"));
                vo.setContactSex(rs.getString("contact_sex"));
                vo.setContactType(rs.getString("contact_type"));
                vo.setContactPhone(rs.getString("contact_phone"));
                vo.setContactAddress(rs.getString("contact_address"));
                vo.setContactText(rs.getString("contact_text"));
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        List<Contact> list = new ArrayList();
        int totalCount = 0;
        String condition = "";
        String sqlList;
        if (params.get("searchColumn") != null && !"".equals(params.get("searchColumn"))) {
            condition += " and `" + params.get("searchColumn") + "` like '%" + params.get("keyword") + "%'";
        }
        try {
            Connection c = Util.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            String limit = (params.get("startIndex") != null && params.get("pageSize") != null) ? " limit " + params.get("startIndex") + "," + params.get("pageSize") : "";
                sqlList = "select * from `t_contact` where 1=1 " + condition + " order by id asc " + limit + ";";
                ps = c.prepareStatement(sqlList);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Contact vo = new Contact();
                    vo.setId(rs.getLong("id"));
                    vo.setContactName(rs.getString("contact_name"));
                    vo.setContactSex(rs.getString("contact_sex"));
                    vo.setContactType(rs.getString("contact_type"));
                    vo.setContactPhone(rs.getString("contact_phone"));
                    vo.setContactAddress(rs.getString("contact_address"));
                    vo.setContactText(rs.getString("contact_text"));
                    list.add(vo);
                }
            String sqlCount = "select count(*) from `t_contact` where 1=1 " + condition;
            ps = c.prepareStatement(sqlCount);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> result = new HashMap();
        result.put("list", list);
        result.put("totalCount", totalCount);
        return result;
    }
}
