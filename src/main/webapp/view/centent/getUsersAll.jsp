<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>所有管理员</title>
	<link rel="stylesheet" type="text/css" href="././public/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="././public/themes/icon.css">
	<link href="././public/themes/icon.css" rel="stylesheet" />
    <script src="././public/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="././public/jquery.min.js"></script>
	<script type="text/javascript" src="././public/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		$(function(){
			function doSearch(){
				$('#tt').datagrid('load',{
					anme: $('#itemid').val(),
					管理权限: $('#productid').val()
				});
			}
		})
	</script>
</head>
<body>
	<div id="tb" style="padding:3px">
		<span>用户名:</span>
		<input id="name" style="line-height:26px;border:1px solid #ccc">
		<span>管理权限:</span>
		<input id="grades" style="line-height:26px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="doSearch()">搜索</a>
	</div>
	<table id="tt" class="easyui-datagrid" style="width:100%;height:480px"
		title="查看管理员信息" iconCls="icon-save"
		rownumbers="true" >
	<thead>
		<tr>
			<th field="itemid" width="180" align="center">用户 ID</th>
			<th field="productid" width="180" align="center">用户名</th>
			<th field="productid" width="180" align="center">密码</th>
			<th field="listprice" width="180" align="center">管理权限</th>
		</tr>
		<c:forEach items="${pageBean.lists}" var="users">
			<tr>
				<th field="itemid" width="180" align="center">${users.id}</th>
				<th field="productid" width="180" align="center">${users.name}</th>
				<th field="productid" width="180" align="center">${users.password}</th>
				<th field="listprice" width="180" align="center">
					<c:if test="${users.grades=='1'}">
						<c:out value="超级管理员"/>
					</c:if>
					<c:if test="${users.grades=='0'}">
						<c:out value="超级管理员"/>
					</c:if>
				</th>
			</tr>
		</c:forEach>
	</thead>
</table>
<div id="pp" style="background:#efefef;border:1px solid #ccc;" align="buttom"></div>
<script type="text/javascript">
	$(function(){
		var total = ${pageBean.countNum};
		var pageNumber = ${pageBean.index};
		$('#pp').pagination({
		    total:total,
		    pageSize:10,
		    pageNumber:pageNumber,
		    pageNumber:'${pageBean.index}',
		    pageList: [10,10]
		});
	})
</script>
</body>
</html>