package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String context_path = ((HttpServletRequest)request).getContextPath();
        String servlet_path = ((HttpServletRequest)request).getServletPath();

        if(!servlet_path.matches("/css.*")) {
            HttpSession session = ((HttpServletRequest)request).getSession();
            User u = (User)session.getAttribute("login_user");

            /*↓この部分は、/login 以外のページにアクセスした場合、ログイン状態でなければ /login ページに
             * 強制的にリダイレクトさせます。さらに、("/users.*")の記述によりユーザー管理（/users/以下含む全て）のページにアクセスした場合、
             * ログインしているユーザー情報の admin_flag をチェックし、一般権限であればトップページへリダイレクトさせるようにしています。
             * else以下の部分は、ログインしているのにログインページを表示させる理由がないので、そのようなアクセスがあった場合はトップページへリダイレクトさせます。*/


            if(!servlet_path.equals("/login")) {
                if(u == null && !servlet_path.equals("/users/new") && !servlet_path.equals("/users/create")) {
                    ((HttpServletResponse)response).sendRedirect(context_path + "/login");
                    return;
                }
//以下の("/users.*")の記述を("/users/index")に変えました
                if(servlet_path.matches("/users/index") && u.getAdmin_flag() == 0) {
                    ((HttpServletResponse)response).sendRedirect(context_path + "/");
                    return;
                }
            } else {
                if(u != null) {
                    ((HttpServletResponse)response).sendRedirect(context_path + "/");
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}