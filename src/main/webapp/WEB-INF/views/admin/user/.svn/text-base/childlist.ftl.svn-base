<#if list?? &&  list?size &gt; 0>
	<#list list as user>
	<tr class="odd gradeX">
		<td width="10%">
			<input name="ids" type="checkbox" value="${(role.userId)!}" id="childs" checked="false" />
		</td>
		<td width="10%">${user.userName}</td>
		<td width="10%">${user.loginName}</td>
		<td width="10%">${user.userRole}</td>
		<td width="10%">
		<#if user.status == 0>
			正常
			<#elseif user.status == 1>
			禁用
			<#elseif user.status == 2>
			删除
		</#if>
		</td>
		<td width="20%">${user.lastLoginTime}</td>
		<td width="20%">
		<!-- <#if btns?? && btns?size &gt;0>-->
            <!--<#list btns as btn>-->
	            <!--<#if (btn.btnType)?? && btn.btnType == 'edit'>-->
	            <a href="javascript:void(0)"><span class="imgspansub"><img src="${contextPath}/images/edt.gif" width="16" height="16" /></span>编辑</a>
	           <!-- </#if>-->
	             <!--<#if (btn.btnType)?? && btn.btnType == 'view'>-->
	            <a href="javascript:void(0)"><span class="imgspansub"><img src="${contextPath}/images/tb.gif" width="16" height="16" /></span>查看</a>
	            <!--</#if>-->
	            <!--<#if (btn.btnType)?? && btn.btnType == 'del'>-->
	            <a href="javascript:void(0)"><span class="imgspansub"><img src="${contextPath}/images/del.gif" width="16" height="16" /></span>删除</a>
	            <!--</#if>-->
            <!--</#list>-->
        <!--</#if>-->
        </td>
	</tr>
 </#list>
 <#else>
 	<tr>
 		<td style="text-align: center;" colspan="6">
 			暂无数据！
 		</td>
 	</tr>
 </#if>		
	