package ncu.ie.webdesign.util.filter;

import ncu.ie.webdesign.dto.AjaxCallBack;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  14:28
 * @description 页面直接访问拦截器，对所有直接使用get请求方式访问页面的都拒绝，不允许用url直接访问页面
 **/
@WebFilter(urlPatterns = {"/usermanage.jsp","/post.jsp"})
public class WebPagesFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        response.sendRedirect(request.getContextPath());
    }

    @Override
    public void destroy() {
    }
}
