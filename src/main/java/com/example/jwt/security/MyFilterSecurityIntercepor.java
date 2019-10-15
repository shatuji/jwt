package com.example.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;


@Service
public class MyFilterSecurityIntercepor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(AccessDecisionManager accessDecisionManager)
    {
        super.setAccessDecisionManager(accessDecisionManager);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest ,servletResponse ,filterChain);
        invoke(filterInvocation);

    }

    private void invoke(FilterInvocation filterInvocation) {
        /**
         * filterInvocation 里面有一个被拦截的url
         * 里面是调用MyInvocationSecurityMetadataSource的getAttribute(Object object)这个方法
         * 获取filterInvocation对应的所有权限
         * 再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
         *
         *
         * */

        InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
        try {
            filterInvocation.getChain().doFilter(filterInvocation.getRequest() , filterInvocation.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }finally {
            super.afterInvocation(token , null);
        }

    }

    @Override
    public void destroy() {

    }


    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.filterInvocationSecurityMetadataSource;
    }
}
