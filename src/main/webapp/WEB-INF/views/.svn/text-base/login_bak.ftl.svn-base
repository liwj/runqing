<!Doctype html>
<html>
<head>
<title>瑞庆后台管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript"  src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">  
function doLogin(){  
    var url = "${contextPath}/j_spring_security_check";  
    var username= $("input[name='j_username']").val();  
    var password= $("input[name='j_password']").val();  
    $.ajax({  
        url:url,  
        type:"POST",  
        data:"j_username="+username+"&j_password="+password,  
        success: function(data){  
        alert(data);
            location.href="${contextPath}/index";
        }  
    });  
}  
</script>  
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="235" background="images/login_03.gif">
<div id="results"></div>  </td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="394" height="53" background="images/login_05.gif">&nbsp;</td>
            <td width="206" background="images/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="16%" height="25"><div align="right"><span class="STYLE1">账号</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text"  name='j_username'  style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">密码</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" onkeydown="if(event.keyCode==13){doLogin()}" name='j_password' style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="25"><div align="left"><a name="submit" onclick="doLogin()"><img src="images/dl.gif" width="49" height="18" border="0"></a></div></td>
              </tr>
            </table></td>
            <td width="362" background="images/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="213" background="images/login_08.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
