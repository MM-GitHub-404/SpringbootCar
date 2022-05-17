<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.mm.mmcar.entity.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript">
        if ("${msg}" != "") {
            alert("${msg}");
        }
    </script>
    <c:remove var="msg"></c:remove>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bright.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
</head>
<script type="text/javascript">
    function allClick() {
        //取得全选复选框的选中未选 中状态
        var ischeck = $("#all").prop("checked");
        //将此状态赋值给每个车型列表里的复选框
        $("input[name=ck]").each(function () {
            this.checked = ischeck;
        });
    }

    function ckClick() {
        //取得所有name=ck的被选中的复选框
        var length = $("input[name=ck]:checked").length;
        //取得所有name=ck的复选框
        var len = $("input[name=ck]").length;
        //比较
        if (len == length) {
            $("#all").prop("checked", true);
        } else {
            $("#all").prop("checked", false);
        }
    }
</script>
<body>
<div id="brall">
    <div id="nav">
        <p>车 型 列 表</p>
    </div>
    <div id="condition" style="text-align: center">
        <form id="myform">
            车型名称：<input name="pname" id="pname">&nbsp;&nbsp;&nbsp;
            车型类型：<select name="typeid" id="typeid">
            <option value="-1">请选择</option>
            <c:forEach items="${carTypeList}" var="pt">
                <option value="${pt.typeId}">${pt.typeName}</option>
            </c:forEach>
        </select>&nbsp;&nbsp;&nbsp;
            价格：<input name="lprice" id="lprice">-<input name="hprice" id="hprice">
            <input type="button" value="查询" onclick="ajaxsplit(${pb.pageNum})">
        </form>
    </div>
    <br>
    <div id="table">
        <c:choose>
            <c:when test="${info.list.size()!=0}">
                <div id="top">
                    <input type="checkbox" id="all" onclick="allClick()" style="margin-left: 50px">&nbsp;&nbsp;全选
                    <a href="${pageContext.request.contextPath}/admin/addcar.jsp">

                        <input type="button" class="btn btn-warning" id="btn1"
                               value="新增车型">
                    </a>
                    <input type="button" class="btn btn-warning" id="btn2"
                           value="批量删除" onclick="deleteBatch(${info.pageNum})">
                </div>
                <!--显示分页后的车型-->
                <div id="middle">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th></th>
                            <th>车型</th>
                            <th>车型介绍</th>
                            <th>定价（元）</th>
                            <th>车型图片</th>
                            <th>车型数量</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${info.list}" var="p">
                            <tr>
                                <td valign="center" align="center"><input type="checkbox" name="ck" id="ck"
                                                                          value="${p.cId}" onclick="ckClick()"></td>
                                <td>${p.cName}</td>
                                <td>${p.cContent}</td>
                                <td>${p.cPrice}</td>
                                <td><img width="55px" height="35px"
                                         src="${pageContext.request.contextPath}/image_big/${p.cImage}"></td>
                                <td>${p.cNumber}</td>
                                    <%--<td><a href="${pageContext.request.contextPath}/admin/product?flag=delete&pid=${p.pId}" onclick="return confirm('确定删除吗？')">删除</a>--%>
                                    <%--&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/product?flag=one&pid=${p.pId}">修改</a></td>--%>
                                <td>
                                    <button type="button" class="btn btn-info "
                                            onclick="one(${p.cId},${info.pageNum})">编辑
                                    </button>
                                    <button type="button" class="btn btn-warning" id="mydel"
                                            onclick="del(${p.cId},${info.pageNum})">删除
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <!--分页栏-->
                    <div id="bottom">
                        <div>
                            <nav aria-label="..." style="text-align:center;">
                                <ul class="pagination">
                                    <li>
                                            <%--                                        <a href="${pageContext.request.contextPath}/prod/split?page=${pb.prePage}" aria-label="Previous">--%>
                                        <a href="javascript:ajaxsplit(${info.prePage})" aria-label="Previous">

                                            <span aria-hidden="true">«</span></a>
                                    </li>
                                    <c:forEach begin="1" end="${info.pages}" var="i">
                                        <c:if test="${info.pageNum==i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split?page=${i}" style="background-color: grey">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})"
                                                   style="background-color: grey">${i}</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${info.pageNum!=i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split?page=${i}">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})">${i}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <li>
                                            <%--  <a href="${pageContext.request.contextPath}/prod/split?page=1" aria-label="Next">--%>
                                        <a href="javascript:ajaxsplit(${info.nextPage})" aria-label="Next">
                                            <span aria-hidden="true">»</span></a>
                                    </li>
                                    <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${info.pages}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <c:if test="${info.pageNum!=0}">
                                            当前&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${info.pageNum}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                        <c:if test="${info.pageNum==0}">
                                            当前&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h2 style="width:1200px; text-align: center;color: orangered;margin-top: 100px">暂时没有符合条件的车型！</h2>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<!--编辑的模式对话框-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增车型</h4>
            </div>
            <div class="modal-body" id="addTD">
                <form action="${pageContext.request.contextPath}/admin/product?flag=save" enctype="multipart/form-data"
                      method="post" id="myform">
                    <table>
                        <tr>
                            <td class="one">车型名称</td>
                            <td><input type="text" name="pname" class="two" class="form-control"></td>
                        </tr>
                        <!--错误提示-->
                        <tr class="three">
                            <td class="four"></td>
                            <td><span id="pnameerr"></span></td>
                        </tr>
                        <tr>
                            <td class="one">车型介绍</td>
                            <td><input type="text" name="pcontent" class="two" class="form-control"></td>
                        </tr>
                        <!--错误提示-->
                        <tr class="three">
                            <td class="four"></td>
                            <td><span id="pcontenterr"></span></td>
                        </tr>
                        <tr>
                            <td class="one">定价</td>
                            <td><input type="number" name="pprice" class="two" class="form-control"></td>
                        </tr>
                        <!--错误提示-->
                        <tr class="three">
                            <td class="four"></td>
                            <td><span id="priceerr"></span></td>
                        </tr>

                        <tr>
                            <td class="one">图片介绍</td>
                            <td><input type="file" name="pimage" class="form-control"></td>
                        </tr>
                        <tr class="three">
                            <td class="four"></td>
                            <td><span></span></td>
                        </tr>

                        <tr>
                            <td class="one">总数量</td>
                            <td><input type="number" name="pnumber" class="two" class="form-control"></td>
                        </tr>
                        <!--错误提示-->
                        <tr class="three">
                            <td class="four"></td>
                            <td><span id="numerr"></span></td>
                        </tr>


                        <tr>
                            <td class="one">类别</td>
                            <td>
                                <select name="typeId">
                                    <c:forEach items="${carTypeList}" var="type">
                                        <option value="${type.typeId}">${type.typeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <!--错误提示-->
                        <tr class="three">
                            <td class="four"></td>
                            <td><span></span></td>
                        </tr>

                        <tr>
                            <td>
                                <input type="submit" class="btn btn-success" value="提交" class="btn btn-success">
                            </td>
                            <td>
                                <button type="button" class="btn btn-info" data-dismiss="modal">取消</button>
                            </td>
                        </tr>
                    </table>
                </form>

            </div>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
</body>
<!--弹出新增模式对话框-->
<script type="text/javascript">
    $(function () {
        $(".btn-info").on("click", function () {
            //浏览不关，第二次打开时要清空
            $("#myModal").modal("hide");
        });
        //新增车辆非空判断
        $(".btn-success").on("click", function () {
            $("#myModal").modal("hide");
        });
    });
</script>
<script type="text/javascript">
    function mysubmit() {
        $("#myform").submit();
    }

    //批量删除
    function deleteBatch(page) {
        if (confirm("确定删除吗")) {
            //取得所有被选中删除车型的pid
            var zhi = $("input[name=ck]:checked");
            var str = "";
            var id = "";
            if (zhi.length == 0) {
                alert("请选择将要删除的车型！");
            } else {
                // 有选中的车型，则取出每个选中车型的ID，拼接提交的ID的数据
                if (confirm("您确定删除" + zhi.length + "条车型吗？")) {
                    //拼接ID
                    $.each(zhi, function () {
                        id = $(this).val();
                        if (id != null)
                            str += id + ",";
                    });
                    $.ajax({
                        url: "${pageContext.request.contextPath}/car/deleteCarBatch",
                        data: {
                            "cIds": str,
                            "page": page,
                        },
                        type: "post",
                        dataType: "text",
                        success: function (msg) {
                            alert(msg);//弹删除是否成功
                            $("#table").load("${pageContext.request.contextPath}/admin/car.jsp #table")
                        }
                    });
                }
            }


        }
    }

    //单个删除
    function del(cId, page) {
        if (confirm("确定删除吗")) {
            //取出查询条件
            var voName = $("#pname").val();
            var voTypeId = $("#typeid").val();
            var lowestPrice = $("#lprice").val();
            var highestPrice = $("#hprice").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/car/deleteCar",
                /*data: {"pid": pid, "page": page, "pname": pname, "typeid": typeid, "lprice": lprice, "hprice": hprice},*/
                data: {
                    "cId": cId,
                    "page": page,
                    "voName": voName,
                    "voTypeId": voTypeId,
                    "lowestPrice": lowestPrice,
                    "highestPrice": highestPrice
                },
                type: "post",
                /*dataType: "json",*/
                dataType: "text",
                success: function (msg) {
                    alert(msg);//弹删除是否成功
                    $("#table").load("${pageContext.request.contextPath}/admin/car.jsp #table")
                }
            });
        }
    }

    function one(cId, page) {
        var voName = $("#pname").val();
        var voTypeId = $("#typeid").val();
        var lowestPrice = $("#lprice").val();
        var highestPrice = $("#hprice").val();
        var str = "?cId=" + cId + "&page=" + page + "&voName=" + voName + "&voTypeId=" + voTypeId + "&lowestPrice=" + lowestPrice + "&highestPrice=" + highestPrice;
        location.href = "${pageContext.request.contextPath}/car/selectByIdCar" + str;/* + "&page=" + ispage*/
    }
</script>
<!--分页的AJAX实现-->
<script type="text/javascript">
    function ajaxsplit(page) {
        //取出查询条件翻页
        var pname = $("#pname").val();
        var typeid = $("#typeid").val();
        var lprice = $("#lprice").val();
        var hprice = $("#hprice").val();
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/car/turnPages",
            data: {"page": page, "voName": pname, "voTypeId": typeid, "lowestPrice": lprice, "highestPrice": hprice},
            success: function () {
                $("#table").load("${pageContext.request.contextPath}/admin/car.jsp #table");
            }
        });
    }
</script>
</html>