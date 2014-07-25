<#if list?? &&  list?size &gt; 0>
	<#list list as role>
	<tr class="odd gradeX">
		<td><input name="ids" type="checkbox" value="${(role.id)!}" id="childs" checked="false" /></td>
		<td>${(role.rolename)!}</td>
		<td>
		<#if btns?? && btns?size &gt;0>
            <#list btns as btn>
	            <#if (btn.btnType)?? && btn.btnType == 'edit'>
	            <a><span class="imgspansub"><img src="${contextPath}/images/edt.gif" width="16" height="16" /></span>编辑</a>
	            </#if>
	             <#if (btn.btnType)?? && btn.btnType == 'view'>
	            <a><span class="imgspansub"><img src="${contextPath}/images/tb.gif" width="16" height="16" /></span>查看</a>
	            </#if>
	            <#if (btn.btnType)?? && btn.btnType == 'del'>
	            <a><span class="imgspansub"><img src="${contextPath}/images/del.gif" width="16" height="16" /></span>删除</a>
	            </#if>
            </#list>
        </#if>
        </td>
	</tr>
 </#list>
 <#else>
 	<tr>
 		<td style="text-align: center;" colspan="3">
 			暂无数据！
 		</td>
 	</tr>
 </#if>		
	