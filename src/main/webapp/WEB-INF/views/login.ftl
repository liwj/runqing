<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>润庆后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
    <link href="css/fancy-button/fancy-button.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	.mid{ 
	position:absolute; 
	top:50%; 
	left:50%; 
	margin:-150px 0 0 -150px; 
	width:300px !important; 
	height:300px !important; 
	} 
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
	            location.href="${contextPath}/index";
	        }  
	    });  
	}  
	</script>  
</head>
<body  class="container_12">
    <div>
        <div class="grid_12 mid"  style="width:400px">
            <div class="box round first fullpage">
                <h2>登录窗口</h2>
                <div class="block ">
                    <form>
                    <table class="form">
                        <tr>
                            <td class="col1">
                                <label>工号：</label>
                            </td>
                            <td class="col2">
                                <input type="text"  name='j_username' />
                            </td>
                        </tr>
	                    <tr>
	                        <td class="col1">
	                            <label>密码：</label>
	                        </td>
	                        <td class="col2">
	                            <input type="password"  onkeydown="if(event.keyCode==13){doLogin()}" name='j_password'  />
	                        </td>
	                    </tr>
                    </table>
		              
                    </form>
                </div>
                <div style="text-align:center;">
                	  <button class="btn btn-blue" onclick="doLogin()">登录</button>
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
</body>
</html>
