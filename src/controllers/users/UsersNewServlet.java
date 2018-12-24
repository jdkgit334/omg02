package controllers.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class UsersNewServlet
 */
@WebServlet("/users/new")
public class UsersNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("_token", request.getSession().getId()); //new.jspにアクセスしてきたidを変数tokenに格納
		request.setAttribute("user", new User()); //Userクラスのインスタンスを変数userに格納

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/new.jsp"); //new.jspを表示
		rd.forward(request, response);
	}

}