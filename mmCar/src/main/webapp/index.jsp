<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
</head>

<body>
<div id="login">
    <div id="top">
        <h3 style='margin-top:30px;height:20px;font-size: 30px;font-weight: bold;color:white;float:right;text-align:right;'>
            Sign in to MMCarRental
            <h3/><%--<img src="${pageContext.request.contextPath}/images/cloud.jpg"/>--%><%--<span></span>--%>
    </div>
    <div id="bottom">
        <form action="${pageContext.request.contextPath}/admin/login" method="post">
            <table border="0px" id="table">
                <tr>
                    <td class="td1">用户名：</td>
                    <td><input type="text" class="td2" name="name"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span id="nameerr"></span></td>
                </tr>
                <tr>
                    <td class="td1">密码：</td>
                    <td><input type="password" class="td2" name="pwd"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><span id="pwderr"></span></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="登录" class="td3">
                        <a href="${pageContext.request.contextPath}/admin/regist.jsp">
                            <input type="button" value="注册" class="td3">
                        </a>
                    </td>
                </tr>
            </table>
        </form>
        ${errmsg}
    </div>
</div>
<%
    session.removeAttribute("token");
%>
</body>

</html>