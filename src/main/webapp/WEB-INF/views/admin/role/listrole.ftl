<#include "../layout.ftl" />
<@head title="润庆纸制品有限公司后台管理系统" keywords="" description="">
</@head>
<@body>
<div class="grid_10">
    <div class="box round first grid">
        <h2>角色列表</h2>
        <div class="block">
        	<div  id="example_wrapper" class="dataTables_wrapper">
	        	<div id="example_length" class="dataTables_length_my">
	        	 <#if btns?? && btns?size &gt;0>
                <#list btns as btn>
	                 <#if (btn.btnType)?? && btn.btnType == 'add'>
	                 	<button class="btn btn-green sys_btn add" id="add">新增</button>
	                 </#if>
	                 <#if (btn.btnType)?? && btn.btnType == 'del'>
	                  <button class="btn btn-red sys_btn">批量删除</button>
	                </#if>
                </#list>
                </#if>
				</div>
				<div id="example_filter" class="dataTables_filter_my"  width="70%">
				<form action="${contextPath}/role/listrole" id="searchForm" method="post">
					<label>
					角色名称:<input   name="name" type="text" value="${rolename!}" id="name" ><button class="btn btn-green sys_btn" onclick="search()">查询</button>
					</label>
				</form>
				</div>
	            <table class="data display datatable center" id="example">
					<thead>
						<tr>
							<th class="no_sorting" rowspan="1" colspan="1" style="width: 30px;background-color: #39A7B6;"><input type="checkbox" name="checkbox" value="checkbox" /></th>
							<th class="no_sorting" rowspan="1" colspan="1" style="background-color: #39A7B6;">角色名称</th>
							<th class="no_sorting" rowspan="1" colspan="1" style="width: 280px;background-color: #39A7B6;">操作</th>
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

</@body>
<@script>
	<script src="${contextPath}/js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>
    <script src="${contextPath}/js/jquery.pagination.js" type="text/javascript"></script>
    <script src="${contextPath}/js/role/rolelist.js" type="text/javascript"></script>
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