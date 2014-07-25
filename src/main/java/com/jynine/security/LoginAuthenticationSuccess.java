package com.jynine.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jynine.model.Source;
import com.jynine.model.User;
import com.jynine.service.LoadSourceService;


public class LoginAuthenticationSuccess implements AuthenticationSuccessHandler{
	
	/*private String serialno;
	private String s_id;
	private String areaid;*/
	@Autowired
	private LoadSourceService loadSourceService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		commonLogin(response,"/index");
		/*//判断是否单点登陆
		if(isSingleLogin(request)){
			doSingleLogin(request,response);
		}else{
			commonLogin(response,url);
		}*/
	}

	/*//是否单点登陆
	private boolean isSingleLogin(HttpServletRequest request){
		serialno = request.getParameter("serialno");
		s_id = request.getParameter("s_id");
		areaid = request.getParameter("areaid");
		if(StringUtils.isEmpty(serialno)&&StringUtils.isEmpty(s_id)&&StringUtils.isEmpty(areaid)){
			return false;
		}
		return true;
	}
	*/
	//单点登陆
	/*private void doSingleLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		StringBuilder rtnUrl = new StringBuilder(request.getContextPath());
		rtnUrl.append("/report/reportlist?serialno=");
		rtnUrl.append(serialno);
		rtnUrl.append("&netType=-1&testType=-1&s_id=");
		rtnUrl.append(s_id);
		rtnUrl.append("&areaid=");
		rtnUrl.append(areaid);
		response.sendRedirect(rtnUrl.toString());
	}*/
	
	//常规登陆
	private void commonLogin(HttpServletResponse response,String url) throws IOException{
        String contentType = "application/json";  
        response.setContentType(contentType);
        PrintWriter out = response.getWriter();  
        out.print("{\"url\":\""+ url+"\",\"status\":1,\"msg\":\"登陆成功,页面即将跳转...\"}");  
        out.flush();  
        out.close();
	}
	//获取登录成功跳转的url
	/*private String getUrl(List<Source> Sources){
		boolean flag = false;//判断是否有三级菜单
		String url = "";//跳转的url
		Source rsc = null;
		for(Source rs : Sources){
			//判断权限中是否存在默认进入的页面
			if(rs.getParentid() == 0 && rs.getSourceid().equals(22)){//22 gis资源表中的id
				rsc = rs;
				break;
			}
		}
		//一级菜单
		for(Source rs : Sources){
			if(rs.getParentid() == 0){
				if(rsc != null){
					rs = rsc;
				}
				//二级菜单
				for(Source rs1 : Sources){
					if(rs1.getParentid().equals(rs.getSourceid()) && rs1.getType() == 0){
						//三级菜单
						for(Source rs2 : Sources){
							if(rs2.getParentid().equals(rs1.getSourceid()) && rs2.getType() != 0){
								flag = true;
								url = rs1.getUrl();
								break;
							}
							if(rs2.getParentid().equals(rs1.getSourceid()) && rs2.getType() == 0){
								flag = true;
								url = rs2.getUrl();
								break;
							}
						}
						if(flag){
							return url;
						}else{
							return rs1.getUrl();
						}
					}
				}
			}
		}
		//跳转到没有权限
		return "/accessDeniedBody";
	}*/
}
