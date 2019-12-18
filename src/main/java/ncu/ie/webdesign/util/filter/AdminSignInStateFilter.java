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
 * @date 2019-12-12  16:21
 * @description 对需要管理员身份登录才可以操作的请求进行拦截检查
 **/
@WebFilter(urlPatterns ={"/userManage","/postsManage"})
public class AdminSignInStateFilter implements Filter {

    private final static Integer USER_KEY=0;
    private final static String LOGIN_ACC ="loginAcc";
    private final static String TYPE="accType";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        if(session.getAttribute(LOGIN_ACC)==null){
            ajaxCallBack.setSuccessFlag(false);
            ajaxCallBack.setCallbackData("请先登录！");
            JSONObject callback=new JSONObject(ajaxCallBack);
            response.getWriter().print(callback);
        }else if(session.getAttribute(TYPE)==USER_KEY){
            ajaxCallBack.setSuccessFlag(false);
            ajaxCallBack.setCallbackData("您不是管理员，没有操作权限！");
            JSONObject callback=new JSONObject(ajaxCallBack);
            response.getWriter().print(callback);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
