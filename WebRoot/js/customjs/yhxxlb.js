$(function() {
	$('#center_datagrid_yhxxlb').datagrid({
		selectOnCheck : true,
		checkOnSelect : true,
		striped : true,// 斑马线效果
		
		/*************AppUser的增删改查***********************/
		/*
		 * toolbar : [ { width : '100px', iconCls : 'icon-add', text:' 增加',
		 * plain:true, handler : function() { $('#addAppuser').dialog({ title :
		 * '增加APP的用户', width : 400, height : 300, closed : false, cache : false,
		 * resizable : true, href : 'appuser_registUI.action', modal : true,
		 * buttons : [ { text : '注册', iconCls:'icon-save', handler : function() { //
		 * if($('#appuser_registform').form('validate')){}如果表单验证都成功 $.ajax({ url :
		 * "appuser_regist.action", data : $('#appuser_registform').serialize(),
		 * type : "post", beforeSend:function(){ $.messager.progress({
		 * text:'正在新增中。。。。。', }); }, success : function(data, response, status) {
		 * $.messager.progress('close'); $('#addAppuser').dialog('close');
		 * $('#center_datagrid_yhxxlb').datagrid('reload'); $.messager.show({
		 * title : '提示', msg : '您已注册成功！！！', timeout : 5000, showType : 'slide'
		 * }); }, error : function() { $.messager.show({ title : '提示', msg :
		 * '您注册失败！！！', timeout : 5000, showType : 'slide' }); } });
		 *  } }, { text : '关闭', handler : function() {
		 * $('#addAppuser').dialog('close'); } } ]
		 * 
		 * }); } }, '-', { width : '100px', iconCls : 'icon-edit', text:' 编辑',
		 * plain:true, handler : function() { var
		 * rows=$('#center_datagrid_yhxxlb').datagrid('getSelections');
		 * if(rows.length>1){ $.messager.alert('警告操作！','编辑记录只能选定一条记录！'); }else
		 * if(rows.length==1){ $('#editAppuser').dialog({ title : '编辑更新APP用户',
		 * width : 400, height : 300, closed : false, cache : false, resizable :
		 * true, href : 'appuser_modifyUI.action?vauid='+rows[0].vauid, modal :
		 * true, buttons : [ { text : '提交修改', iconCls:'icon-save', handler :
		 * function() { //
		 * if($('#appuser_registform').form('validate')){}如果表单验证都成功 $.ajax({ url :
		 * "appuser_modify", data : $('#appuser_updateform').serialize(), type :
		 * "post", beforeSend:function(){ $.messager.progress({
		 * text:'正在更新中。。。。。', }); }, success : function(data, response, status) {
		 * $.messager.progress('close'); $('#editAppuser').dialog('close');
		 * $('#center_datagrid_yhxxlb').datagrid('reload'); $.messager.show({
		 * title : '提示', msg : '更新用户成功！！！', timeout : 5000, showType : 'slide'
		 * }); }, error : function() { $.messager.show({ title : '提示', msg :
		 * '更新用户失败！！！', timeout : 5000, showType : 'slide' }); } });
		 *  } }, { text : '关闭', handler : function() {
		 * $('#editAppuser').dialog('close'); } } ]
		 * 
		 * }); }else if(rows.length==0){
		 * $.messager.alert('警告操作！','编辑记录至少选定一条记录！'); }
		 *  } }, '-', { width : '100px', iconCls : 'icon-remove', text:' 删除',
		 * plain:true, handler : function () { var rows =
		 * $('#center_datagrid_yhxxlb').datagrid('getSelections'); if
		 * (rows.length > 0) { $.messager.confirm('确定操作', '您正在要删除所选的记录吗？',
		 * function (flag) { if (flag) { var vauids = []; for (var i = 0; i <
		 * rows.length; i ++) { vauids.push(rows[i].vauid); }
		 * //console.log(ids.join(',')); $.ajax({ type : 'POST', url :
		 * 'appuser_deletebyVauids.action', data : { vauids : vauids.join(','), },
		 * beforeSend : function () {
		 * $('#center_datagrid_yhxxlb').datagrid('loading'); }, success :
		 * function (data) { if (data) {
		 * $('#center_datagrid_yhxxlb').datagrid('loaded');
		 * $('#center_datagrid_yhxxlb').datagrid('load');
		 * $('#center_datagrid_yhxxlb').datagrid('unselectAll');
		 * $.messager.show({ title : '提示', msg : data + '个App用户被删除成功！', }); } },
		 * }); } }); } else { $.messager.alert('提示', '请选择要删除的记录！', 'info'); } } } ],
		 */
		columns : [ [ {
			field : 'vauid',
			title : '自动编号',
			
			align : 'center',
			checkbox : true,
		}, {
			field : 'vname',
			title : '姓名',
			width : 100,
			align : 'center'
		},{
			field : 'vinnercode',
			title : '员工编码',
			width : 100,
			align : 'center'
		}, {
			field : 'vtel',
			title : '电话',
			width : 100,
			align : 'center'
		}, {
			field : 'dpoint',
			title : '积分',
			width : 100,
			align : 'center'
		}, {
			field : 'vcard',
			title : '卡号',
			width : 100,
			align : 'center'
		}, {
			field : 'address1',
			title : '地址一',
			width : 100,
			align : 'center'
		}, {
			field : 'address2',
			title : '地址二',
			width : 100,
			align : 'center'
		}, {
			field : 'address3',
			title : '地址三',
			width : 100,
			align : 'center'
		}, {
			field : 'address4',
			title : '地址四',
			width : 100,
			align : 'center'
		}, {
			field : 'address5',
			title : '地址五',
			width : 100,
			align : 'right'
		}, {
			field : 'address6',
			title : '地址六',
			width : 100,
			align : 'right'
		} ] ],
		pagination : true,
		pagePosition : 'bottom',
		pageSize : 15,
		pageList : [ 15, 30 ],
		fit : true,
		border : false,
		url : 'appuser_queryAppuserJson.action',
		// singleSelect : true,
		rownumbers : true,

	});

});