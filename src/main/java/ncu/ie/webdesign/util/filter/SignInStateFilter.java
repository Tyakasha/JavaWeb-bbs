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
 * @description 登录状态过滤/拦截器，对所有需要登录才能跳转的页面或操作进行拦截检查
 **/
@WebFilter(urlPatterns = "/bbs/user/*")
public class SignInStateFilter implements Filter {

    private final static String KEY="loginAcc";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute(KEY)==null){
            AjaxCallBack ajaxCallBack=new AjaxCallBack();
            ajaxCallBack.setSuccessFlag(false);
            ajaxCallBack.setCallbackData("请先登录！");
            JSONObject callback=new JSONObject(ajaxCallBack);
            response.getWriter().print(callback);
        } else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
