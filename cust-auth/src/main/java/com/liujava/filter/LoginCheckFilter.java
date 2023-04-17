package com.liujava.filter;


import com.alibaba.fastjson2.JSON;
import com.liujava.common.BaseContext;
import com.liujava.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /**
         * 该拦截器的作用为当有人访问到非登陆页面时进行判断：
         * 放行已经登录且登陆成功的而拦截未登录或登录异常的
         * 1、获取本次请求的URL
         * 2、判断本次请求是否需要处理
         * 3、如果不需要处理，则直接放行
         * 4、判断登录状态，若已登录，则直接放行
         * 5、如果未登录则返回未登录结果
         *
         */

        String requestURI = request.getRequestURI();
        String [] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/login",
                "/user/sendMsg"
        };

        boolean check = check(urls,requestURI);
        if (check)
        {
            filterChain.doFilter(request,response);
            return;
        }

        if(request.getSession().getAttribute("employee")!=null)
        {

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return;
        }

        //判断移动端用户是否登录成功
        if(request.getSession().getAttribute("user")!=null)
        {

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request,response);
            return;
        }


        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;




    }

    /**
     * 路径匹配，检查本次要求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI){

        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
