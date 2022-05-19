package com.demo.servlet;

import com.demo.util.Util;
import com.demo.service.ContactService;
import com.demo.service.impl.ContactServiceImpl;
import com.demo.vo.Contact;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contact模块的Servlet控制层，负责接收页面传过来的请求参数，根据action参数的值来确定页面要执行的具体操作<br>
 * 而后再调用ContactService业务层的方法来处理具体的业务，最后将处理完成的结果返回或跳转至相应页面
 */
//@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {

    /**
     * 处理Post请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //过滤编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = Util.decode(request, "action");
        if ("add".equals(action)) {//增加
            Contact vo = new Contact();
            //取出页面传进来的各个数据，并设置到Contact对象的属性里
            vo.setContactName(Util.decode(request, "contactName"));
            vo.setContactSex(Util.decode(request, "contactSex"));
            vo.setContactType(Util.decode(request, "contactType"));
            vo.setContactPhone(Util.decode(request, "contactPhone"));
            vo.setContactAddress(Util.decode(request, "contactAddress"));
            vo.setContactText(Util.decode(request, "contactText"));
            ContactService contactService = new ContactServiceImpl();
            //调用Service层增加方法（add），增加记录
            contactService.add(vo);
            this.redirectList(request, response);
        } else if ("delete".equals(action)) {//删除
            //取出表要删除的联系人记录的主键
            long id = Long.parseLong(Util.decode(request, "id"));
            ContactService contactService = new ContactServiceImpl();
            //调用Service层删除方法（delete），将对应的记录删除
            contactService.delete(id);
            this.redirectList(request, response);
        } else if ("edit".equals(action)) {//修改
            //取出页面传进来的各个数据，并设置到Contact对象的属性里
            Contact vo = new Contact();
            vo.setId(Long.valueOf(Util.decode(request, "id")));
            vo.setContactName(Util.decode(request, "contactName"));
            vo.setContactSex(Util.decode(request, "contactSex"));
            vo.setContactType(Util.decode(request, "contactType"));
            vo.setContactPhone(Util.decode(request, "contactPhone"));
            vo.setContactAddress(Util.decode(request, "contactAddress"));
            vo.setContactText(Util.decode(request, "contactText"));
            ContactService contactService = new ContactServiceImpl();
            //调用Service层更新方法（update），更新记录
            contactService.update(vo);
            this.redirectList(request, response);
        } else if ("get".equalsIgnoreCase(action) || "editPre".equalsIgnoreCase(action)) {//根据主键ID，查询详情信息并跳转到详情页面或编辑页面
            Serializable id = Util.decode(request, "id");//取出页面传入的主键，用于查询详情
            ContactService contactService = new ContactServiceImpl();
            Contact vo = contactService.get(id);
            request.getSession().setAttribute("vo", vo);
            String to = "get".equalsIgnoreCase(action) ? "info" : "edit";//判断是去详情显示页面还是编辑页面
            response.sendRedirect("contact_" + to + ".jsp");
        } else {//默认去列表页面
            this.redirectList(request, response);
        }
    }

    /**
     * 处理Get请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);//Get请求和Post请求的处理是一样的，所以把request、response转交给Post方法就好
    }

    /**
     * 根据参数，查询出条例条件的记录集合，最后将数据返回给调用处或者将数据集合设置到session域里，再跳转到对应的列表页面
     *
     * @param request
     * @param response
     */
    private void redirectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询列和关键字
        String searchColumn = Util.decode(request, "searchColumn");
        String keyword = Util.decode(request, "keyword");
        Map<String, Object> params = new HashMap();//用来保存控制层传进来的参数(查询条件)
        params.put("searchColumn", searchColumn);//要查询的列
        params.put("keyword", keyword);//查询的关键字
        ContactService contactService = new ContactServiceImpl();
        response.getWriter().println(com.alibaba.fastjson.JSONObject.toJSONString(contactService.list(params).get("list")));
    }
}
