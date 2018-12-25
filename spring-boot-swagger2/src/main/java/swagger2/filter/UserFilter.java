package swagger2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "userFilter",urlPatterns = "/user/*")
public class UserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
//        System.out.println("拦截器名称：" + filterName);
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/");
//        System.out.println("获取的路径：" + realPath);
//        System.out.println("拦截器初始化！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long time_1 = new Date().getTime();
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        System.out.println(request.getHeader("token"));
        filterChain.doFilter(request,response);
        long time_2 = new Date().getTime();
        System.out.println("放行。。。。。。。。。。。。。");
        System.out.println("使用时间：" + (time_2 - time_1));
    }

    @Override
    public void destroy() {
        System.out.println("拦截器销毁！");
    }
}
