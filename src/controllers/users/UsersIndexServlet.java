package controllers.users;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UsersIndexServlet
 */
@WebServlet("/users/index")
public class UsersIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		int page = 1;

		try{
		    page = Integer.parseInt(request.getParameter("page")); //jspから送信される"page"クエリのパラメーターを整数化したものを変数pageに代入
		} catch(NumberFormatException e) {}
		List<User> users = em.createNamedQuery("getAllUsers", User.class)
		                        .setFirstResult(15 * (page - 1))
		                        .setMaxResults(15)
		                        .getResultList();

		long users_count = (long)em.createNamedQuery("getUsersCount", Long.class)
		                        .getSingleResult();

		em.close();

		request.setAttribute("users", users); //変数usersの内容を、同じusersという変数名でjspの中で扱えるようリクエストスコープに格納
		request.setAttribute("users_count", users_count); //変数users_countの内容を、同じusers_countという変数名でjspの中で扱えるようリクエストスコープに格納
		request.setAttribute("page", page);
		if(request.getSession().getAttribute("flush") != null) {
		    request.setAttribute("flush", request.getSession().getAttribute("flush"));
		    request.getSession().removeAttribute("flush"); //jspの中で変数flushを扱えなくする
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/index.jsp"); //index.jspを呼び出す
		rd.forward(request, response);

	}

}













































