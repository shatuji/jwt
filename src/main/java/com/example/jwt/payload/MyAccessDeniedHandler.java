package com.example.jwt.payload;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * if request fail then deal it by this class
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        StringBuffer msg = new StringBuffer("请求: ");
        msg.append(httpServletRequest.getRequestURI()).append(" 权限不足，无法访问系统资源.");
        //log.info(msg.toString());
        httpServletResponse.getWriter().println("88888");
        httpServletResponse.getWriter().write("you do not access right here");
       // ResultUtil.writeJavaScript(httpServletResponse,ErrorCodeEnum.AUTHORITY,msg.toString());

    }
}
