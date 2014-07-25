$(function() {
	var optInit = {
			callback : function(page_index, jq) {
				$.ajax({
				type : "post",
				url : contextPath + "/user/listuser/template",
				data : ({
					name : $('#hiddenval').val(),
					index : page_index + 1
				}),
				success : function(data) {
					$('#content').html(data);
					$('.edit').click(function() {
						$("#dlg").dialog({
							href : contextPath+ '/role/updateRole?roleid='+ $(this).attr("id"),
							height : 130,
							width : 435,
							title : "用户信息",
							modal : true,
							closed : false
						});
						$('#dlg').dialog('open');
						$.parser.parse('#dlg');
					});
					$(".del").click(function() {
						var id = $(this).attr("id");
						// TODO 删除
					});
					$(".access").click(function() {
						var id = $(this).attr("id");
						var src = contextPath+ "/role/assignAccess/" + id;
						$("#treedlg").dialog({
							href : src,
							height : 430,
							width : 435,
							title : "权限分配",
							modal : true,
							closed : false
						});
						$('#treedlg').dialog('open');
						$.parser.parse('#treedlg');
					});
					$("input[name='ids']").each(function() {
						$(this).attr('checked', false);
					});
				}
			});
			return false;
		}
	};
	$("#pager").pagination(pageTotal, optInit);
	$('#search').click(function(){
		var _sn = $('input[name]').val();
		$('#hiddenval').val(_sn);
		$('#searchForm').submit();
	});
});