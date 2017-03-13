$(function() {
	$('#center_datagrid_xtglylb')
			.datagrid(
					{
						selectOnCheck : true,
						checkOnSelect : true,
						striped : true,// 斑马线效果
						toolbar : [
								{
									width : '100px',
									iconCls : 'icon-add',
									text : ' 增加',
									plain : true,
									handler : function() {
										$('#addSysUser')
												.dialog(
														{
															title : '增加系统管理员',
															width : 400,
															height : 300,
															closed : false,
															cache : false,
															resizable : true,
															href : 'sysuser_registUI.action',
															modal : true,
															buttons : [
																	{
																		text : '注册',
																		iconCls : 'icon-save',
																		handler : function() {
																			// 如果表单验证都成功
																			if ($(
																					'#sysuser_registform')
																					.form(
																							'validate')) {
																				$
																						.ajax({
																							url : "sysuser_regist.action",
																							data : $(
																									'#sysuser_registform')
																									.serialize(),
																							type : "post",
																							beforeSend : function() {
																								$.messager
																										.progress({
																											text : '正在新增中。。。。。',
																										});
																							},
																							success : function(
																									data,
																									response,
																									status) {

																								if (data == 'Y') {

																									$.messager
																											.progress('close');
																									$(
																											'#addSysUser')
																											.dialog(
																													'close');
																									$(
																											'#center_datagrid_xtglylb')
																											.datagrid(
																													'reload');
																									$.messager
																											.show({
																												title : '提示',
																												msg : '新建管理员成功！！！',
																												timeout : 5000,
																												showType : 'slide'
																											});
																								} else {
																									$.messager
																											.progress('close');
																									$(
																											'#addSysUser')
																											.dialog(
																													'close');
																									$(
																											'#center_datagrid_xtglylb')
																											.datagrid(
																													'reload');
																									$.messager
																											.show({
																												title : '提示',
																												msg : '注册管理员失败！！！',
																												timeout : 5000,
																												showType : 'slide'
																											});

																								}
																							},
																							error : function() {
																								$.messager
																										.progress('close');
																								$.messager
																										.show({
																											title : '提示',
																											msg : '您注册失败！！！',
																											timeout : 5000,
																											showType : 'slide'
																										});
																							}
																						});
																			}
																			return;
																		}
																	},
																	{
																		text : '关闭',
																		handler : function() {
																			$(
																					'#addSysUser')
																					.dialog(
																							'close');
																		}
																	} ]

														});
									}
								},
								'-',
								{
									width : '100px',
									iconCls : 'icon-edit',
									text : ' 编辑',
									plain : true,
									handler : function() {
										var rows = $('#center_datagrid_xtglylb')
												.datagrid('getSelections');
										if (rows.length > 1) {
											$.messager.alert('警告操作！',
													'编辑记录只能选定一条记录！');
										} else if (rows.length == 1) {
											$('#editSysUser')
													.dialog(
															{
																title : '编辑更新系统管理员',
																width : 400,
																height : 300,
																closed : false,
																cache : false,
																resizable : true,
																href : 'sysuser_modifyUI.action?vsuid='
																		+ rows[0].vsuid,
																modal : true,
																buttons : [
																		{
																			text : '提交修改',
																			iconCls : 'icon-save',
																			handler : function() {
																				// 如果表单验证都成功
																				if ($(
																						'#sysuser_modify')
																						.form(
																								'validate')) {
																					$
																							.ajax({
																								url : "sysuser_modify.action",
																								data : $(
																										'#sysuser_modify')
																										.serialize(),
																								type : "post",
																								beforeSend : function() {
																									$.messager
																											.progress({
																												text : '正在更新中。。。。。',
																											});
																								},
																								success : function(
																										data,
																										response,
																										status) {
																									if (data == 'N') {
																										$.messager
																												.show({
																													title : '提示',
																													msg : '更新用户失败！！！',
																													timeout : 5000,
																													showType : 'slide'
																												});
																										$.messager
																												.progress('close');
																										$(
																												'#editSysUser')
																												.dialog(
																														'close');

																									} else {
																										$.messager
																												.progress('close');
																										$(
																												'#editSysUser')
																												.dialog(
																														'close');
																										$(
																												'#center_datagrid_xtglylb')
																												.datagrid(
																														'reload');
																										$.messager
																												.show({
																													title : '提示',
																													msg : '更新用户成功！！！',
																													timeout : 5000,
																													showType : 'slide'
																												});
																									}
																								},
																								error : function() {
																									$.messager
																											.show({
																												title : '提示',
																												msg : '更新用户失败！！！',
																												timeout : 5000,
																												showType : 'slide'
																											});
																									$.messager
																											.progress('close');
																									$(
																											'#editSysUser')
																											.dialog(
																													'close');
																								}
																							});

																				}

																				return;
																			}
																		},
																		{
																			text : '关闭',
																			handler : function() {
																				$(
																						'#editSysUser')
																						.dialog(
																								'close');
																			}
																		} ]

															});
										} else if (rows.length == 0) {
											$.messager.alert('警告操作！',
													'编辑记录至少选定一条记录！');
										}

									}
								},
								'-',
								{
									width : '100px',
									iconCls : 'icon-remove',
									text : ' 删除',
									plain : true,
									handler : function() {
										var rows = $('#center_datagrid_xtglylb')
												.datagrid('getSelections');
										if (rows.length > 0) {
											$.messager
													.confirm(
															'确定操作',
															'您正在要删除所选的记录吗？',
															function(flag) {
																if (flag) {
																	var vsuids = [];
																	for (var i = 0; i < rows.length; i++) {
																		vsuids
																				.push(rows[i].vsuid);
																	}
																	// console.log(ids.join(','));
																	$
																			.ajax({
																				type : 'POST',
																				url : 'sysuser_deletebyVsuids.action',
																				data : {
																					vsuids : vsuids
																							.join(','),
																				},
																				beforeSend : function() {
																					$(
																							'#center_datagrid_xtglylb')
																							.datagrid(
																									'loading');
																				},
																				success : function(
																						data) {
																					if (data == 'fail') {
																						$(
																								'#center_datagrid_xtglylb')
																								.datagrid(
																										'loaded');
																						$(
																								'#center_datagrid_xtglylb')
																								.datagrid(
																										'load');
																						$(
																								'#center_datagrid_xtglylb')
																								.datagrid(
																										'unselectAll');
																						$.messager
																								.show({
																									title : '提示',
																									msg : '删除管理员失败！',
																								});
																						return;
																					}
																					$(
																							'#center_datagrid_xtglylb')
																							.datagrid(
																									'loaded');
																					$(
																							'#center_datagrid_xtglylb')
																							.datagrid(
																									'load');
																					$(
																							'#center_datagrid_xtglylb')
																							.datagrid(
																									'unselectAll');
																					$.messager
																							.show({
																								title : '提示',
																								msg : data
																										+ '个管理员被删除成功！',
																							});

																				},

																				error : function(
																						data) {
																					if (data == 'fail') {
																						$.messager
																								.show({
																									title : '提示',
																									msg : '删除管理员失败！',
																								});
																						return;
																					}

																					$.messager
																							.show({
																								title : '提示',
																								msg : '删除管理员失败！',
																							});

																				}
																			});
																}
															});
										} else {
											$.messager.alert('提示',
													'请选择要删除的记录！', 'info');
										}
									}
								} ],
						columns : [ [ {
							field : 'vsuid',
							title : '自动编号',
							width : 200,
							checkbox : true,
						}, {
							field : 'vsuname',
							title : '登录名',
							width : 250,
							align : 'center',
						}, {
							field : 'vpassword',
							title : '密码',
							width : 250,
							align : 'center',
						} ] ],
						pagination : true,
						pagePosition : 'bottom',
						pageSize : 15,
						pageList : [ 15, 30 ],
						fit : true,
						border : false,
						url : 'sysuser_querySysUserJson.action',
						// singleSelect : true,
						rownumbers : true,

					});

});