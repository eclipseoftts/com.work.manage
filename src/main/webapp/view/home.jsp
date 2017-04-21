<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html .. "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="./public/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="./public/themes/icon.css">
	<link href="./public/themes/icon.css" rel="stylesheet" />
    <script src="./public/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="./public/jquery.min.js"></script>
	<script type="text/javascript" src="./public/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
	$(function () {
		$('#easyuiTree').tree({
			url: '${pageContext.request.contextPath}/workData/tree_data.json',
			loadFilter: function(data){
				if (data.d){
					return data.d;
				} else {
					return data;
				}
			}
		});
		$("#easyuiTree").tree({
			onClick:function(node){
				$("#tabs").tabs('add',{
					title:node.text,
	                closable:true,
	                content : '<iframe frameborder="0" scrolling="auto" width="100%" height="100%" src="http://www.baidu.com"></iframe>'
				})
			}
		});
		$("#messages").tree({
			onClick:function(node){
				$("#tabs").tabs('add',{
					title:node.text,
	                closable:true,
	                content : '<iframe frameborder="0" scrolling="auto" width="100%" '+
	                'height="100%" src="'+node.attributes.url+'"></iframe>'
				})
			}
		});
		$("#wather").tree({
			onClick:function(node){
				$("#tabs").tabs('add',{
					title:node.text,
	                closable:true,
	                content : '<iframe frameborder="0" scrolling="auto" width="100%" '+
	                'height="100%" src="'+node.attributes.url+'"></iframe>'
				})
			}
		});
	})
	</script>
	
</head>
<body style="margin:0px;padding:0px;">
    <div class="easyui-layout" style="width:100%;height:100%;">
    	<div region="north"  style="width: 100%;height:62px;background-color: #E0ECFF;">
    		<div align="right" style="width: 10%;height:60px;float:left;">
    			<img alt="logo" src="./public/images/logocat.gif" width="100" height="58">
    		</div>
    		<div align="left" style="width: 20%;height:58px;float:right;padding:1px;">
    			<p>欢迎${users.name}登录！</p>
    			<span><span>安全退出</a></span>
    		</div>
    	</div>
    	
		<div region="west" split="true" title="下拉菜单" style="width:180px;">
			<div id="aa" class="easyui-accordion" style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">
            <div title="信息管理" iconcls="icon-reload" style="padding: 10px;">
                <ul class="easyui-tree" id="messages">
                    <li data-options="attributes:{'url':'${pageContext.request.contextPath}/findUsersAll'}">
                    	<span>管理员信息管理</span>
                    </li>
                </ul> 
            </div>
            <div title="工作管理" selected="true"  iconcls="icon-save" style="overflow: auto; padding: 10px;">
                <ul class="easyui-tree" id="easyuiTree">
                </ul>
            </div>
            <div title="新闻管理" iconcls="icon-reload" style="padding: 10px;">
                content2 
            </div>
            <div title="资源管理" iconcls="icon-reload" style="padding: 10px;">
                <ul class="easyui-tree" id="wather">
                    <li data-options="attributes:{'url':'${pageContext.request.contextPath}/findUsersAll'}">
                    	<span>天气预报</span>
                    </li>
                </ul> 
            </div>
        </div>
		</div>
		<div id="content" region="center"  style="padding:2px;" >
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
		      <div title="首页"></div>
		    </div>
		</div>
		<div id="south" region="south" title="责任说明" style="">
		</div>
	</div>
</body>
</html>