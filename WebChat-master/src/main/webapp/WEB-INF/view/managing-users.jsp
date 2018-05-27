<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 系统日志</title>
    <jsp:include page="include/commonfile.jsp"/>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong> / <small>user</small></div>
        </div>
        <div class="am-tabs am-margin">
            <table class="am-table am-table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>用户名</th>
                    <th>昵称</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>操作</th>
                </tr>

                </thead>
                <tbody>
                <c:forEach items="${list}" var="user" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${user.userid}</td>
                        <td>${user.nickname}</td>
                        <td>
                            <c:if test="${user.sex == null || user.sex == ''}">未知</c:if>
                            <c:if test="${user.sex != null && user.sex != ''}">
                                <c:if test="${user.sex == 1}">男</c:if>
                                <c:if test="${user.sex == 0}">女</c:if>
                                <c:if test="${user.sex == -1}">保密</c:if>
                            </c:if>
                        </td>
                        <td>${user.age}</td>
                        <c:if test="${user.status eq 1}">
                            <td><a href="${ctx}/${user.userid}/closure">禁用</a></td>
                        </c:if>
                        <c:if test="${user.status eq 0}">
                            <td><a href="${ctx}/${user.userid}/closure">启用</a></td>
                        </c:if>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div id="page" style="float: right">

            </div>
        </div>
    </div>
    <!-- content end -->
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<jsp:include page="include/footer.jsp"/>z

<script>
    $(function(){
        laypage({
            cont: 'page',
            pages: ${count},
            curr: function(){
                var page = location.search.match(/page=(\d+)/);
                return page ? page[1] : 1;
            }(),
            skin: '#AF0000',
            groups: 5, //连续显示分页数
            jump: function(e, first){ //触发分页后的回调
                if(!first){ //一定要加此判断，否则初始时会无限刷新
                    location.href = '?page='+e.curr;
                }
            }
        });
    });
</script>
</body>
</html>
