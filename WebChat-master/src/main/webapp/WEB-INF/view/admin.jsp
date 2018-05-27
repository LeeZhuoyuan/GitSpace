<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>WebChat | 后台管理</title>
    <jsp:include page="include/commonfile.jsp"/>
    <style type="text/css">
        .admin-content{
            background:url("../../static/source/img/bg1.jpg") no-repeat 0px 0px;;
        }
    </style>
    <%--<link href="<%=path%>/static/source/css/login.css" rel='stylesheet' type='text/css' />
    <script src="<%=path%>/static/plugins/jquery/jquery-2.1.4.min.js"></script>
    <script src="<%=path%>/static/plugins/layer/layer.js"></script>--%>
</head>
<body>

<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

    <div class="admin-content"  >


        <h1>欢迎使用webChat后台管理</h1>
    </div>

    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>
