package com.lihuanda.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lihuanda.annotation.FireAuthority;
import com.lihuanda.beans.AuthorityType;
import com.lihuanda.beans.ResultTypeEnum;

public class AuthorityAnnotationInterceptor extends HandlerInterceptorAdapter {

//    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.debug("");
        HandlerMethod handler2=(HandlerMethod) handler;
        FireAuthority fireAuthority = handler2.getMethodAnnotation(FireAuthority.class);

        if(null == fireAuthority){
            //没有声明权限,放行
            return true;
        }
        System.out.println("进入了Interceptor！！！！！！！！");
//        logger.debug("fireAuthority", fireAuthority.toString());

//        HttpSession session = request.getSession();
        //这里需要通过session取得登陆用户的基本信息
        boolean aflag = false;

        for(AuthorityType at:fireAuthority.authorityTypes()){
            if(at.getIndex()==1){//6
                aflag = true;
                break;
            }
        }

        if(false == aflag){

            if (fireAuthority.resultType() == ResultTypeEnum.page) {
                //传统的登录页面               
                StringBuilder sb = new StringBuilder();
                sb.append(request.getContextPath());
                sb.append("/controller/error.html?msg=quanxianbuzu");
                System.out.println(sb);
                response.sendRedirect(sb.toString());
//                request.getRequestDispatcher(sb.toString()).forward(request, response);
            } else if (fireAuthority.resultType() == ResultTypeEnum.json) {
                //ajax类型的登录提示
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=UTF-8");
                OutputStream out = response.getOutputStream();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
                pw.println("{\"result\":false,\"code\":12,\"errorMessage\":\""+"没有权限"+"\"}");
                pw.flush();
                pw.close();
            }

            return false;

        }
        return true;
    }

}