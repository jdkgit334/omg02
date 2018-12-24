package controllers.shops;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Shop;
import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsIndexServlet
 */
@WebServlet("/shops/index")
public class ShopsIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		User login_user = (User)request.getSession().getAttribute("login_user");

		int page;
		try{
		    page = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e) {
		    page = 1;
		}
		/*List<Shop> shops = em.createNamedQuery("getAllShops", Shop.class)
		                        .setFirstResult(15 * (page - 1))
		                        .setMaxResults(15)
		                        .getResultList();

		long shops_count = (long)em.createNamedQuery("getShopsCount", Long.class)
		                        .getSingleResult(); */


		List<Shop> shops = em.createNamedQuery("getMyAllShops", Shop.class)
                .setParameter("user", login_user)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

long shops_count = (long)em.createNamedQuery("getMyShopsCount", Long.class)
                  .setParameter("user", login_user)
                  .getSingleResult();


		em.close();

		request.setAttribute("shops", shops);
		request.setAttribute("shops_count", shops_count);
		request.setAttribute("page", page);
		if(request.getSession().getAttribute("flush") != null) {
		    request.setAttribute("flush", request.getSession().getAttribute("flush"));
		    request.getSession().removeAttribute("flush");
		}



		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shops/index.jsp");
		rd.forward(request, response);

	}

}















































