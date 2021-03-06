<#include "../layout.ftl" />
<@head title="润庆纸制品有限公司后台管理系统" keywords="" description="">
</@head>
<@body>
<div class="grid_10">
    <div class="box round first grid">
        <h2>用户列表</h2>
        <div class="block">
        	<div  id="example_wrapper" class="dataTables_wrapper">
	        	<div id="example_length" class="dataTables_length_my">
	        		<button class="btn btn-green sys_btn" id="add">新增</button>
	        		<button class="btn btn-red sys_btn">批量删除</button>
				</div>
				<div id="example_filter" class="dataTables_filter_my"  width="70%">
				<form action="${contextPath}/user/listuser" id="searchForm" method="post">
					<label>
					用户名称:<input name="name" type="text" value="${name!}">
					<button class="btn btn-green sys_btn" id="search">查询</button>
					</label>
				</form>
				</div>
	            <table class="data display datatable center" id="example">
					<thead>
						<tr>
							<th class="no_sorting" rowspan="1" colspan="1" width="10%" style="width: 30px;background-color: #39A7B6;">
							<input type="checkbox" name="checkbox" value="checkbox" /
							></th>
							<th class="no_sorting" width="10%" rowspan="1" colspan="1" style="background-color: #39A7B6;">用户名</th>
							<th class="no_sorting" width="10%" rowspan="1" colspan="1" style="background-color: #39A7B6;">登录名</th>
							<th class="no_sorting" width="10%" rowspan="1" colspan="1" style="background-color: #39A7B6;">角色</th>
							<th class="no_sorting" width="10%" rowspan="1" colspan="1" style="background-color: #39A7B6;">用户状态</th>
							<th class="no_sorting" width="20%" rowspan="1" colspan="1" style="background-color: #39A7B6;">最后登录时间</th>
							<th class="no_sorting" width="20%" rowspan="1" colspan="1" style="width: 280px;background-color: #39A7B6;">操作</th>
						</tr>
					</thead>
					<tbody id="content">
					</tbody>
				</table>
			</div>
			<div id="example_info" class="dataTables_info"></div> 
			<input type="hidden" value="${name!}" id="hiddenval"/>
	        <div id="pager" class="dataTables_paginate paging_two_button" >
			</div>
        </div>
    </div>
</div>
<div class="clear">
</div>
</@body>
<@script>
	<script src="${contextPath}/js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/jquery.pagination.js" type="text/javascript"></script>
    <script src="${contextPath}/js/user/listuser.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.datatable').dataTable();
        });
        var contextPath = '${contextPath}';
		var pageTotal = ${pb.totalPage!0};
		var pageSize = ${pb.pageSize!5};
		var pageIndex = ${pb.pageIndex!1};
    </script>
</@script>