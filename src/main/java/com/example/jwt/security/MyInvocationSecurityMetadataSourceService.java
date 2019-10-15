package com.example.jwt.security;


import com.example.jwt.entity.Permission;
import com.example.jwt.entity.PermissionMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class MyInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {

  //  @Autowired
    /***
     * 模拟请求数据库
     * 跳过注解的这一步
     * 现在就是测试这个权限验证的顺序 还有就是
     * 怎么样进行动态的控制权限 所以这里的处理就是比较的粗躁点
     * */
    private PermissionMapper permissionMapper = new PermissionMapper();

    private HashMap<String , Collection<ConfigAttribute>> maps = null;


    public void loadResourceDefine(){
        maps = new HashMap<>();
        Collection<ConfigAttribute> arrays ;
        ConfigAttribute cfg ;
        List<Permission> plist = permissionMapper.findAll();

        for(Permission permission : plist)
        {
            arrays = new ArrayList<>();
            cfg = new SecurityConfig(permission.getName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。
            // 此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            arrays.add(cfg);
            //用权限的getURL（）来作为maps的key 用configattribute来做为value
            maps.put(permission.getUrl() , arrays);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，
    // 则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if(maps == null)
            loadResourceDefine();
        // //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation)o).getHttpRequest();
        AntPathRequestMatcher matcher ;
        String resUrl;
        for (Iterator<String> iter = maps.keySet().iterator(); iter.hasNext();) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            //System.out.println("Request '" + request.getMethod() + " " + request.getRequestPath(request) + "' doesn't match '" + request.httpMethod + " " + this.pattern + "'");

            if(matcher.matches(request))
                return maps.get(resUrl);

        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    //change false to true
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
