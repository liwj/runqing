<#if list?? &&  list?size &gt; 0>
	<#list list as role>
	<tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center">
          <input name="ids" type="checkbox" value="${(role.id)!}" id="childs" checked="false" />
        </div></td>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${(role.rolename)!}</span></div></td>
        <td height="20" bgcolor="#FFFFFF">
        	<div align="center">
        		<span class="STYLE4" style="vertical-align:sub">
        		<#if btns?? && btns?size &gt;0>
            <#list btns as btn>
            <#if (btn.btnType)?? && btn.btnType == 'edit'>
            <span class="imgspansub"><img src="${contextPath}/images/edt.gif" width="16" height="16" /></span>编辑
            </#if>
             <#if (btn.btnType)?? && btn.btnType == 'view'>
            <span class="imgspansub"><img src="${contextPath}/images/tb.gif" width="16" height="16" /></span>查看
            </#if>
            <#if (btn.btnType)?? && btn.btnType == 'del'>
            <span class="imgspansub"><img src="${contextPath}/images/del.gif" width="16" height="16" /></span>删除
            </#if>
            </#list>
            </#if>
        		</span>
        	</div>
        </td>
      </tr>
 </#list>
 <#else>
 	<tr>
 		<td style="text-align: center;">
 			暂无数据！
 		</td>
 	</tr>
 </#if>		
	