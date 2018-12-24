package controllers.shops;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Shop;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsDestroyServlet
 */
@WebServlet("/shops/destroy")
public class ShopsDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Shop s = em.find(Shop.class, (Integer)(request.getSession().getAttribute("shop_id")));

            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("shop_id");

            response.sendRedirect(request.getContextPath() + "/shops/index");
        }
    }

}
