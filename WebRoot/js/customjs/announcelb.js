$(function() {
	$('#center_datagrid_announcelb')
			.datagrid(
					{
						selectOnCheck : true,
						checkOnSelect : true,
						striped : true, // 斑马线效果
						toolbar : [
								{
									width : '100px',
									iconCls : 'icon-add',
									text : ' 增加',
									plain : true,
									handler : function() {
										$('#addAnnounce')
												.dialog(
														{
															dragable : true,
															title : '增加公告',
															width : 400,
															height : 300,
															closed : false,
															cache : false,
															resizable : true,
															href : 'announce_publishUI.action',
															modal : true,
															buttons : [
																	{
																		text : '发布公告',
																		iconCls : 'icon-save',
																		handler : function() {
																			if ($(
																					'#announce_publishform')
																					.form(
																							'validate')) {

																				var options = {
																					success : function(
																							data) {
																						$(
																								'#addAnnounce')
																								.dialog(
																										'close');
																						$(
																								'#center_datagrid_announcelb')
																								.datagrid(
																										'reload');
																						$.messager
																								.show({
																									title : '提示',
																									msg : '您已发布公告成功！！！',
																									timeout : 5000,
																									showType : 'slide'
																								});
																					}
																				};
																				$(
																						"#announce_publishform")
																						.ajaxSubmit(
																								options);
																			}
																			return;
																		}
																	},
																	{
																		text : '关闭',
																		handler : function() {
																			$(
																					'#addAnnounce')
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
										var rows = $(
												'#center_datagrid_announcelb')
												.datagrid('getSelections');
										if (rows.length > 1) {
											$.messager.alert('警告操作！',
													'编辑记录只能选定一条记录！');
										} else if (rows.length == 1) {
											$('#editAnnounce')
													.dialog(
															{
																title : '编辑更新公告',
																width : 400,
																height : 400,
																closed : false,
																cache : false,
																resizable : true,
																href : 'announce_modifyUI.action?vanid='
																		+ rows[0].vanid,
																modal : true,
																buttons : [
																		{
																			text : '提交修改',
																			iconCls : 'icon-save',
																			handler : function() {

																				var options = {
																					success : function(
																							data) {
																						$(
																								'#editAnnounce')
																								.dialog(
																										'close');
																						$(
																								'#center_datagrid_announcelb')
																								.datagrid(
																										'reload');
																						$.messager
																								.show({
																									title : '提示',
																									msg : '更新广告成功！！！',
																									timeout : 5000,
																									showType : 'slide'
																								});
																					}
																				};
																				$(
																						"#announce_updateform")
																						.ajaxSubmit(
																								options);
																			}
																		},
																		{
																			text : '关闭',
																			handler : function() {
																				$(
																						'#editAnnounce')
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
										var rows = $(
												'#center_datagrid_announcelb')
												.datagrid('getSelections');
										if (rows.length > 0) {
											$.messager
													.confirm(
															'确定操作',
															'您正在要删除所选的记录吗？',
															function(flag) {
																if (flag) {
																	var vanids = [];
																	for (var i = 0; i < rows.length; i++) {
																		vanids
																				.push(rows[i].vanid);
																	}
																	// console.log(ids.join(','));
																	$
																			.ajax({
																				type : 'POST',
																				url : 'announce_deletebyVanids.action',
																				data : {
																					vanids : vanids
																							.join(',')
																				},
																				beforeSend : function() {
																					$(
																							'#center_datagrid_announcelb')
																							.datagrid(
																									'loading');
																				},
																				success : function(
																						data) {
																					if (data) {
																						$(
																								'#center_datagrid_announcelb')
																								.datagrid(
																										'loaded');
																						$(
																								'#center_datagrid_announcelb')
																								.datagrid(
																										'load');
																						$(
																								'#center_datagrid_announcelb')
																								.datagrid(
																										'unselectAll');
																						$.messager
																								.show({
																									title : '提示',
																									msg : data
																											+ '条公告删除成功！',
																								});
																					}
																				},
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
							field : 'vanid',
							title : '公告id',
							width : 50,
							checkbox : true,
							align : 'center',
						}, {
							field : 'vtitlename',
							title : '公告简称',
							width : 180,
							align : 'center',

						}, {
							field : 'vimgpath',
							title : '公告图片',
							width : 180,
							align : 'center',
							formatter : function(value, row, index) {
								return '<img src="' + row.vimgpath + '" />';
							}
						}, {
							field : 'grade',
							title : '公告级别',
							width : 180,
							align : 'center',
							formatter : function(value, row, index) {
								if (row.grade == 0) {
									return '普通';
								}
								return '重要';
							}
						}, {
							field : 'vtext',
							title : '公告文本',
							width : 180,
							align : 'center'
						}, {
							field : 'vmodifier',
							title : '修改人姓名',
							width : 180,
							align : 'center',
							formatter : function(value, row) {
								return row.vmodifier.vsuname;
							},

						}, {
							field : 'lastmodifyTime',
							title : '修改时间',
							width : 180,
							align : 'center',
							formatter : function(val, rec) {
								return jsonTimeStamp(val);
							}
						} ] ],
						fit : true,
						border : false,
						url : 'announce_queryAnnounceJson.action',
						rownumbers : true,
						pagination : true,
						pagePosition : 'bottom',
						pageSize : 1,
						pageList : [ 1, 2 ],
					});

	// 将日期显示为yyyy-MM-dd HH:mm:ss
	function jsonTimeStamp(milliseconds) {
		if (milliseconds != "" && milliseconds != null
				&& milliseconds != "null") {
			var datetime = new Date();
			datetime.setTime(milliseconds);
			var year = datetime.getFullYear();
			var month = datetime.getMonth() + 1 < 10 ? "0"
					+ (datetime.getMonth() + 1) : datetime.getMonth() + 1;
			var date = datetime.getDate() < 10 ? "0" + datetime.getDate()
					: datetime.getDate();
			var hour = datetime.getHours() < 10 ? "0" + datetime.getHours()
					: datetime.getHours();
			var minute = datetime.getMinutes() < 10 ? "0"
					+ datetime.getMinutes() : datetime.getMinutes();
			var second = datetime.getSeconds() < 10 ? "0"
					+ datetime.getSeconds() : datetime.getSeconds();
			return year + "-" + month + "-" + date + " " + hour + ":" + minute
					+ ":" + second;
		} else {
			return "";
		}

	}
});