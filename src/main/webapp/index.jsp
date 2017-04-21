<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>工作管理后台</title>
	<link rel="stylesheet" type="text/css" href="public/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="public/themes/icon.css">
	<link href="public/themes/icon.css" rel="stylesheet" />
	<link href="public/public/css/index.css" rel="stylesheet" />
    <script src="public/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="public/jquery.min.js"></script>
	<script type="text/javascript" src="public/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="public/public/js/index.js"></script>
</head>
<body class="indexBody">
    <div id="loginWin" class="easyui-window" title="管理员登录" style="width:350px;height:188px;padding:5px;"
         minimizable="false" maximizable="false" resizable="false" collapsible="false">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
                <form id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
                    <div style="padding:5px 0;font-size: 20px;">
                        <label for="login">帐号:</label>
                        <input type="text" name="name" style="width:240px;height: 20px;" />
                    </div>
                    <div style="padding:5px 0;font-size: 20px;">
                        <label for="password">密码:</label>
                        <input type="password" name="password" style="width:240px;height: 20px;" />
                    </div>
                    <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
                    <div region="south" border="false" style="text-align:center;padding:5px 0;">
		                <button class="easyui-linkbutton" iconcls="icon-ok" type="submit" style="margin-right: 10px;">登录</button>
		                <button class="easyui-linkbutton" iconcls="icon-cancel" type="reset" >取消</button>
		            </div>
                </form>
            </div>
        </div>
    </div>
    <div style="display:none;">
    	<span id="spanError">${error}</span>
    </div>
    <div id="win" class="easyui-window" title="错误信息" closed="true" style="width:300px;height:100px;padding:5px;">
		${error}
	</div>
    <script type="text/javascript">
    	$(function(){
    		if($("#spanError").html().length>1){
    			$('#win').window('open');
    		}
    	})
    </script>
</body>
</html>