$(function() {
	//
	$('#west_accordion_xtglylb').linkbutton({
		plain:true,
		iconCls : 'icon-search',
		text : '管理员信息列表',
		onClick : function() {
			if ($('#center_tabs').tabs('exists', '系统管理员列表')) {
				$('#center_tabs').tabs('select', '系统管理员列表');
			} else {
				$('#center_tabs').tabs('add', {
					title : '系统管理员列表',
					iconCls : 'icon-admin',
					href : 'sysuser_querySysUserPage.action',
					closable : true,

				});
			}
		}

	});
	// App用户信息列表按钮
	$('#west_accordion_yhxxlb').linkbutton({
		iconCls : 'icon-search',
		text : '用户信息列表',
		plain:true,
		onClick : function() {
			if ($('#center_tabs').tabs('exists', '用户信息列表')) {
				$('#center_tabs').tabs('select', '用户信息列表');
			} else {
				$('#center_tabs').tabs('add', {
					title:'用户信息列表',
					iconCls:'icon-user',
				    toolPosition:'left',
					href : 'appuser_queryAppUserPage.action',
					closable : true,
				});
			}
		}

	});

	// 广告信息管理列表按钮
	$('#west_accordion_ggxxlb').linkbutton({
		iconCls : 'icon-search',
		text : '广告信息列表',
		plain:true,
		onClick : function() {
			if ($('#center_tabs').tabs('exists', '广告信息列表')) {
				$('#center_tabs').tabs('select', '广告信息列表');
			} else {
				$('#center_tabs').tabs('add', {
					title : '广告信息列表',
					toolPosition:'left',
					iconCls:'icon-advertisement',
					href : 'advertisement_allAdvertisement.action',
					closable : true,
				});
			}
		}

	});
	// 公告信息列表
	$('#west_accordion_announcelb').linkbutton({
		iconCls : 'icon-search',
		text : '公告信息列表',
		plain:true,
		onClick : function() {
			if ($('#center_tabs').tabs('exists', '公告信息列表')) {
				$('#center_tabs').tabs('select', '公告信息列表');
			} else {
				$('#center_tabs').tabs('add', {
					title : '公告信息列表',
					toolPosition:'left',
					iconCls:'icon-announce',
					href : 'announce_queryAllAnnounce.action',
					closable : true,
				});
			}
		}

	});
});