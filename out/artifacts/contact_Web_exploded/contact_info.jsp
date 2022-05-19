<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>联系人详情</title>
    <script src="js/jquery.js"></script>
    <link rel="stylesheet" href="js/layui/css/layui.css">
</head>
<body style="padding: 20px">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名：</label>
        <div class="layui-input-block" style="padding: 9px 15px;">
            ${vo.contactName}
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别：</label>
        <div class="layui-input-block">
            <input name="contactSex" type="radio" value="男" ${vo.contactSex=='男'?'checked':''} class="layui-input" title="男" disabled/>
            <input name="contactSex" type="radio" value="女" ${vo.contactSex=='女'?'checked':''} class="layui-input" title="女" disabled/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">关系：</label>
        <div class="layui-input-block" style="padding: 9px 15px;">
            ${vo.contactType}
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话：</label>
        <div class="layui-input-block" style="padding: 9px 15px;">
            ${vo.contactPhone}
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址：</label>
        <div class="layui-input-block" style="padding: 9px 15px;">
            ${vo.contactAddress}
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注：</label>
        <div class="layui-input-block">
            <textarea type="text" name="contactText" disabled="disabled" class="layui-input" style="height: 100px;padding-left: 10px;" placeholder="请输入内容......">${vo.contactText}</textarea>
        </div>
    </div>
</form>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        let form = layui.form, layer = layui.layer, layedit = layui.layedit;
        //创建一个编辑器
        let editIndex = layedit.build('LAY_demo_editor');
    });
</script>
</body>
</html>
