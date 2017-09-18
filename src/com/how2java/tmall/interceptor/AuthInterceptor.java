/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.interceptor;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor  extends AbstractInterceptor{  


	@Autowired
	OrderItemService orderItemService;			
	
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {
        String[] noNeedAuthPage = new String[]{
                "home",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"};
        
          
        ActionContext ctx = invocation.getInvocationContext();
        HttpServletRequest request= (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response= (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
        ServletContext servletContext= (ServletContext) ctx.get(StrutsStatics.SERVLET_CONTEXT);
        String contextPath = servletContext.getContextPath();
        String uri = request.getRequestURI();
        uri =StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
            	User user = (User) ctx.getSession().get("user");
                if(null==user){
                    response.sendRedirect("login.jsp");
                    return null;
                }
            }
        }
        return  invocation.invoke();
    }  
  
    
    

}  
/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
