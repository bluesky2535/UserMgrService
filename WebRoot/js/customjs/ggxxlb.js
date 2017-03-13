$(function() {
	$('#center_datagrid_ggxxlb')
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

										var data = $('#center_datagrid_ggxxlb')
												.datagrid('getData').total;
										if (data >= 5) {
											$.messager.alert('警告！',
													'广告只能插入五条！！！');
											return;
										}
										$('#addAdvertisement')
												.dialog(
														{
															dragable : true,
															title : '增加广告',
															width : 400,
															height : 300,
															closed : false,
															cache : false,
															resizable : true,
															href : 'advertisement_publishUI.action',
															modal : true,
															buttons : [
																	{
																		text : '发布广告',
																		iconCls : 'icon-save',
                                                                       
																		handler : function() {
																			
																			if ($(
																					'#advertisement_publishform')
																					.form('validate')) {
																				var options = {
																					success : function(
																							data) {
																						$('#addAdvertisement')
																								.dialog('close');
																						$(
																								'#center_datagrid_ggxxlb')
																								.datagrid(
																										'reload');
																						$.messager
																								.show({
																									title : '提示',
																									msg : '您已发布成功！！！',
																									timeout : 5000,
																									showType : 'slide'
																								});
																					}
																				};
																				$("#advertisement_publishform")
																						.ajaxSubmit(
																								options);
																			}
																			return;
																		}
																	},
																	{
																		text : '关闭',
																		handler : function() {
																			$('#addAdvertisement')
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
										var rows = $('#center_datagrid_ggxxlb')
												.datagrid('getSelections');
										if (rows.length > 1) {
											$.messager.alert('警告操作！',
													'编辑记录只能选定一条记录！');
										} else if (rows.length == 1) {
											$('#editAdvertisement')
													.dialog(
															{
																title : '编辑更新广告',
																width : 400,
																height : 300,
																closed : false,
																cache : false,
																resizable : true,
																href : 'advertisement_modifyUI.action?vadid='
																		+ rows[0].vadid,
																modal : true,
																buttons : [
																		{
																			text : '提交修改',
																			iconCls : 'icon-save',
																			handler : function() {

																				if ($(
																						'#advertisement_updateform')
																						.form(
																								'validate')) {
																					var options = {
																						success : function(
																								data) {
																							$(
																									'#editAdvertisement')
																									.dialog(
																											'close');
																							$(
																									'#center_datagrid_ggxxlb')
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
																					$("#advertisement_updateform")
																							.ajaxSubmit(
																									options);
																					// if($('#appuser_registform').form('validate')){}如果表单验证都成功
																				}
																				return;
																			}
																		},
																		{
																			text : '关闭',
																			handler : function() {
																				$(
																						'#editAdvertisement')
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
										var rows = $('#center_datagrid_ggxxlb')
												.datagrid('getSelections');
										if (rows.length > 0) {
											$.messager
													.confirm(
															'确定操作',
															'您正在要删除所选的记录吗？',
															function(flag) {
																if (flag) {
																	var vadids = [];
																	for (var i = 0; i < rows.length; i++) {
																		vadids
																				.push(rows[i].vadid);
																	}
																	// console.log(ids.join(','));
																	$
																			.ajax({
																				type : 'POST',
																				url : 'advertisement_deletebyVadids.action',
																				data : {
																					vadids : vadids
																							.join(',')
																				},
																				beforeSend : function() {
																					$(
																							'#center_datagrid_ggxxlb')
																							.datagrid(
																									'loading');
																				},
																				success : function(
																						data) {
																					if (data) {
																						$(
																								'#center_datagrid_ggxxlb')
																								.datagrid(
																										'loaded');
																						$(
																								'#center_datagrid_ggxxlb')
																								.datagrid(
																										'load');
																						$(
																								'#center_datagrid_ggxxlb')
																								.datagrid(
																										'unselectAll');
																						$.messager
																								.show({
																									title : '提示',
																									msg : data
																											+ '条广告删除成功！',
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
							field : 'vadid',
							title : '广告id',
							width : 50,
							checkbox : true,
						}, {
							title : '图片',
							field : 'vpath',
							width : 220,
							align : 'center',
							formatter : function(value, row, index) {
								return '<img src="' + row.vpath + '" />';
							}
						}, {
							field : 'vadname',
							title : '广告名',
							width : 220,
							align : 'center',
						}, {
							field : 'vhrefpath',
							title : '广告链接',
							width : 220,
							align : 'center',
						}, {
							field : 'modifiedtime',
							title : '修改时间',
							width : 220,
							align : 'center',
							formatter : function(val, rec) {
								return jsonTimeStamp(val);
							}
						}, {
							field : 'modifier',
							title : '修改人姓名',
							width : 220,
							align : 'center',
							formatter : function(value, row) {
								return row.modifier.vsuname;
							},
						} ] ],
						fit : true,
						border : false,
						url : 'advertisement_queryAdvertisementJson.action',
						rownumbers : true,
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

	
	$('#advertisement_publishform_tooltip').tooltip({
        position: 'right',
        content: '<span style="color:#fff">This is the tooltip message.</span>',
        onShow: function(){
    		$(this).tooltip('tip').css({
    			backgroundColor: '#666',
    			borderColor: '#666'
    		});
        }
    });
});