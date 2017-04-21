$(function(){
			$('#tt').tree({
				url: '${pageContext.request.contextPath}/workData/tree_data.json',
				loadFilter: function(rows){
					return convert(rows);
				}
			});
			
			function convert(rows){
				function exists(rows, parentId){
					for(var i=0; i<rows.length; i++){
						if (rows[i].id == parentId) return true;
					}
					return false;
				}
				
				var nodes = [];
				// get the top level nodes
				for(var i=0; i<rows.length; i++){
					var row = rows[i];
					if (!exists(rows, row.parentId)){
						nodes.push({
							id:row.id,
							text:row.name
						});
					}
				}
				
				var toDo = [];
				for(var i=0; i<nodes.length; i++){
					toDo.push(nodes[i]);
				}
				while(toDo.length){
					var node = toDo.shift();	// the parent node
					// get the children nodes
					for(var i=0; i<rows.length; i++){
						var row = rows[i];
						if (row.parentId == node.id){
							var child = {id:row.id,text:row.name};
							if (node.children){
								node.children.push(child);
							} else {
								node.children = [child];
							}
							toDo.push(child);
						}
					}
				}
				return nodes;
			};
			
			
			
			
			
			
			
			
			
			
			
			
		//添加树控件
		$("#tr1").tree({
			url:'tree_data.json'
		});

		//双击树的节点添加面板
		$("#tr").tree({
			onDblClick:function(node){
				addTab(node);
			}
		});

		//添加面板
		function addTab(node){

			$("#ta").tabs('add',{
				title:node.text,
				content:'<table id="tb"></table>',
				closable:true,
			}); 
		}

		/*//添加选项卡的时候添加数据表格
		$(function(){
			$("#ta").tabs({
				onAdd:function(title,index){
				addGrid();
				}
			});
		});


		//添加数据表格的方法
		function addGrid(){
			$("#tb").datagrid({
				url:'datagrid_data.json',
				columns:[[
				         {field:'code',title:'Code',width:100},
				         {field:'name',title:'Name',width:100},
				         {field:'price',title:'Price',width:100,align:'right'}
				         ]]
				});
			}*/
		})