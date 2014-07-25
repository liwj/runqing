<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="${contextPath}/css/page.css" rel="stylesheet" type="text/css"/>
<script src="${contextPath}/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/js/jquery.form.js" type="text/javascript"></script>
<script type="text/javascript" src="${contextPath}/js/jquery.pagination.js"></script>
<script src="${contextPath}/js/role/rolelist.js" type="text/javascript"></script>
<script>
	var contextPath = '${contextPath}';
	var pageTotal = ${pb.totalPage!0};
	var pageSize = ${pb.pageSize!5};
	var pageIndex = ${pb.pageIndex!1};
	</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="${contextPath}/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="${contextPath}/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE1">
                <#if btns?? && btns?size &gt;0>
                <#list btns as btn>
	                 <#if (btn.btnType)?? && btn.btnType == 'add'>
	                    <a href="${contextPath}/role/addrole" class="marginright10 nodecoration"><span class="imgspantop marginright5 add"><img src="${contextPath}/images/22.gif" width="14" height="14" /></span>新增</a>
	                 </#if>
	                 <#if (btn.btnType)?? && btn.btnType == 'del'>
	                  <span class="imgspantop marginright"><img src="${contextPath}/images/11.gif" width="14" height="14" /></span>批量删除
	                </#if>
                </#list>
                </#if>
             </td>
          </tr>
        </table></td>
        <td width="16"><img src="${contextPath}/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="${contextPath}/images/tab_12.gif">&nbsp;</td>
        <td>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
           <thead>
           	 <tr>
	            <td width="3%" height="22" background="${contextPath}/images/bg.gif" bgcolor="#FFFFFF"><div align="center">
	              <input type="checkbox" name="checkbox" value="checkbox" />
	            </div></td>
	            <td width="70%" height="22" background="${contextPath}/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">角色名称</span></div></td>
	            <td  height="22" background="${contextPath}/images/bg.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">操作</div></td>
	          </tr>
  		   </thead>
          <tbody  id="content">
		  </tbody>
        </table>
        </td>
        <td width="8" background="${contextPath}/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${contextPath}/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${contextPath}/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
            <div id="pager" align= "right" class="page">&nbsp;</div></td>
          </tr>
        </table></td>
        <td width="16"><img src="${contextPath}/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
<div>
</div>
</html>
