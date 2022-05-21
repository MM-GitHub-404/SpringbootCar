<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
	</head>

	<body>
		<div id="addAll">
			<div id="nav">
				<p>用户管理>查看信息</p>
			</div>
			<script type="text/javascript">
				function fileChange(){//注意：此处不能使用jQuery中的change事件，因此仅触发一次，因此使用标签的：onchange属性

					$.ajaxFileUpload({
						url: '/user/uploadPicture',//用于文件上传的服务器端请求地址
						secureuri: false,//一般设置为false
						fileElementId: 'uavatar',//文件上传控件的id属性  <input type="file" id="pimage" name="pimage" />
						dataType: 'json',//返回值类型 一般设置为json
						success: function(obj) //服务器成功响应处理函数
						{

							$("#imgDiv").empty();  //清空原有数据
							//创建img 标签对象
							var imgObj = $("<img>");
							//给img标签对象追加属性
							imgObj.attr("src","/image_big/"+obj.imgurl);
							imgObj.attr("width","55px");
							imgObj.attr("height","35px");
							//将图片img标签追加到imgDiv末尾
							$("#imgDiv").append(imgObj);
							//将图片的名称（从服务端返回的JSON中取得）赋值给文件本框
							//$("#imgName").html(data.imgName);
						},
						error: function (e)//服务器响应失败处理函数
						{
							alert(e.message);
						}
					});
				}
			</script>
<script type="text/javascript">
	function myclose() {
		window.location="${pageContext.request.contextPath}/user/firstPage";
	}
</script>
			<div id="table">
				<form action="${pageContext.request.contextPath}/user/updateUserInfo" enctype="multipart/form-data" method="post" id="myform">
					<input type="hidden" value="${prod.uId}" name="uId">
					<input type="hidden" value="${prod.uAvatar}" name="uAvatar">
					<input type="hidden" value="${page}" name="page">
					<table>
						<tr>
							<td class="three">用户头像</td>
							<td><br>
								<div id="imgDiv" style="display:block; width: 55px; height: 35px;">
									<img src="/image_big/${prod.uAvatar}" width="135px" height="85px">
								</div>
								<br><br><br><br>
								<%-- uavatar不能写成uAvatar,原因未知 --%>
								<input type="file" id="uavatar" name="uavatar" onchange="fileChange()">
								<span id="imgName"></span><br>
							</td>
						</tr>
						<tr class="three">
							<td class="four"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="one">用户昵称</td>
							<td><input type="text" name="uName" class="two" value="${prod.uName}"></td>
						</tr>
						<!--错误提示-->
						<tr class="three">
							<td class="four"></td>
							<td><span id="pnameerr"></span></td>
						</tr>
						<tr>
							<td class="one">用户账号</td>
							<td><input type="number" name="uPhone" class="two" value="${prod.uPhone}"></td>
						</tr>
						<!--错误提示-->
						<tr class="three">
							<td class="four"></td>
							<td><span id="pcontenterr"></span></td>
						</tr>
						<tr>
							<td class="one">用户类型</td>
							<td>
								<select name="typeId">
									<c:forEach items="${userTypeList}" var="type">
										<option value="${type.typeId}"
												<c:if test="${type.typeId==prod.typeId}">
													selected="selected"
												</c:if>
										>${type.typeName}</option>
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
							<td class="one">用户积分</td>
							<td><input type="number" name="uIntegral" class="two" value="${prod.uIntegral}"></td>
						</tr>
						<!--错误提示-->
						<tr class="three">
							<td class="four"></td>
							<td><span id="priceerr"></span></td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="提交" class="btn btn-success">
							</td>
							<td>
								<input type="reset" value="取消" class="btn btn-default" onclick="myclose(${param.page})">
								<script type="text/javascript">
									function myclose(ispage) {
										window.location = "${pageContext.request.contextPath}/user/firstPage";
												// ?page=" + ispage
									}
								</script>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</body>

</html>