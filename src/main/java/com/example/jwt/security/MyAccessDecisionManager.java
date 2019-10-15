package com.example.jwt.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     * decide 判断是否有权限进入 的决策方法
     *authentication 是CustomerUserService中添加循环到list<GrantedAuthority>集合中的对象
     *object 包含客户端发起的请求信息 可以转换成request 转换方式是 ServletRequest request = ((FilteInvocation)object).getHttpRequest()
     *collection 为MyInvocationSecutiryMetadataSource的getAttributes(Object object)这个方法返回的结果，这个方法
     * 是为了判定用户的url是否在权限列表中 如果在权限列表中则返回给 decide方法 用来判断用户是否有这个权限，
     * 如果不在权限列表中则放行
     *  */

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
            if(collection == null || collection.size() <= 0)
            {
                return ;
            }

            ConfigAttribute ca;
            String needRole;
        for (Iterator<ConfigAttribute> iter = collection.iterator() ; iter.hasNext()
             ;) {
            ca = iter.next();//将值赋给configAttribute
            needRole = ca.getAttribute();
            //循环获得grantAuthority
            for (GrantedAuthority ga: authentication.getAuthorities()
                 ) {
                if(needRole.trim().equals(ga.getAuthority())){
                    return;
                }
                //if(needRole.trim().indexOf("anonymous"))
               // return;
            }
            
        }
        throw new AccessDeniedException("I am sorry , you do not right to acceing this project");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
