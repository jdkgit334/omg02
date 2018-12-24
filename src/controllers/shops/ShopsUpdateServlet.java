package controllers.shops;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Shop;
import models.validators.ShopValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ShopsUpdateServlet
 */
@WebServlet("/shops/update")
public class ShopsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsUpdateServlet() {
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

            s.setName(request.getParameter("name"));
            s.setCategory(request.getParameter("category"));
            //s.setDisclose(Integer.parseInt(request.getParameter("disclose")));
            s.setAddress(request.getParameter("address"));
            s.setOpen_at1((request.getParameter("open_at1h")) + ":" + (request.getParameter("open_at1m")));
            s.setClose_at1((request.getParameter("close_at1h")) + ":" + (request.getParameter("close_at1m")));
            s.setOpen_at2((request.getParameter("open_at2h")) + ":" + (request.getParameter("open_at2m")));
            s.setClose_at2((request.getParameter("close_at2h")) + ":" + (request.getParameter("close_at2m")));

            String[] holidayList = request.getParameterValues("holiday");
            String holiday = "";

            if(holidayList != null) {
                for(int i = 0; i < holidayList.length; i++) {
                    if(i == 0) {
                        holiday = holidayList[i];
                    } else {
                        holiday = holiday + ", " + holidayList[i];
                    }
                }
            }

            s.setHoliday(holiday);

            s.setHomepage(request.getParameter("homepage"));
            s.setContent(request.getParameter("content"));
            s.setTel(request.getParameter("tel"));
            s.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors = ShopValidator.validate(s);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("shop", s);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shops/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("shop_id");

                response.sendRedirect(request.getContextPath() + "/shops/index");
            }

		}
	}

}








































