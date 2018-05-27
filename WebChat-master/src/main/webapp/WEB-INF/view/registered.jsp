<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 注册用户</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <%--<jsp:include page="include/sidebar.jsp"/>--%>

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">注册新用户</strong> / <small>newUser</small></div>
        </div>

        <div class="am-tabs am-margin" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active"><a href="#tab1">注册</a></li>
            </ul>

            <div class="am-tabs-bd">
                <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                    <c:set value="${user}" var="user"/>
                    <form class="am-form am-form-horizontal" id="information-form" action="${ctx}/registered" method="post" data-am-validator>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">用户名</label>
                            <div class="am-u-sm-10">
                                <input type="text" name="userid" value="${result}" required placeholder="请输入用户名...">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">密码</label>
                            <div class="am-u-sm-10">
                                <input type="password" name="password" value="" required placeholder="请输入密码...">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">昵称</label>
                            <div class="am-u-sm-10">
                                <input type="text" id="nickname" name="nickname" value="" required placeholder="请输入你的昵称...">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="sex" class="am-u-sm-2 am-form-label">性别</label>
                            <div class="am-u-sm-10">
                                <select id="sex" name="sex" data-am-selected>
                                    <option selected></option>
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                    <option value="-1">保密</option>
                                </select>
                            </div>
                            <script>
                                $('#sex').find('option').eq(${user.sex}).attr('selected', true);
                            </script>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">年龄</label>
                            <div class="am-u-sm-10">
                                <input type="number" id="age" name="age" min="1" max="100" value="" placeholder="请输入你的年龄...">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label class="am-u-sm-2 am-form-label">个性签名</label>
                            <div class="am-u-sm-10">
                                <textarea class="" id="profile" name="profile" rows="5" placeholder="这里可以写下你的个性签名..."></textarea>
                            </div>
                            <script>
                                $("#profile").val("${user.profile}");
                            </script>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-10 am-u-sm-offset-2" style="width: 100px;">
                                <button type="submit" class="am-btn am-round am-btn-success"> 提交</button>

                            </div>
                            <div class="am-u-sm-10 am-u-sm-offset-2" style="width: 100px;">
                                <%--<button type="submit" class="am-btn am-round am-btn-success"><span class="am-icon-send"></span> 返回</button>--%>
                                    <a href="${ctx}/login" class="am-btn am-btn-success" style="border-radius: 47px;">返回</a>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- content end -->
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>
<script>
    if("${message}"){
        layer.msg('${message}', {
            offset: 0,
        });
    }
    if("${error}"){
        layer.msg('${error}', {
            offset: 0,
            shift: 6
        });
    }

    function checkFileType(){
        var format = ["bmp","jpg","gif","png"];
        var filename = $("#file").val();
        var ext = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        if(jQuery.inArray(ext, format) != -1){
            return true;
        }else{
            layer.msg('头像格式只能是bmp,jpg,gif,png!', {
                offset: 0,
                shift: 6
            });
            return false;
        }
    }
</script>
</body>
</html>
