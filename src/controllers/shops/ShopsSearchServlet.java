package controllers.shops;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ShopsSearchServlet
 */
@WebServlet("/shops/search")
public class ShopsSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopsSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    request.setAttribute("_token", request.getSession().getId());
	    EntityManager em = DBUtil.createEntityManager();
	    User login_user = (User)request.getSession().getAttribute("login_user");

	    //ページネーションの仕込み
	    int page;
	    try{
	        page = Integer.parseInt(request.getParameter("page"));
	    } catch(Exception e) {
	        page = 1;
	    }

	    //extentの値に応じた取得対象ショップデータの変更、及びページネーションの仕込み。まずはAllの場合。
	    String judgment = (String)request.getParameter("extent");
	    if(judgment.equals("ALL")) {
	         List<Shop> shops = em.createNamedQuery("getAllShops", Shop.class)
	                    .setFirstResult(15 * (page - 1))
	                    .setMaxResults(15)
	                    .getResultList();

	          long shops_count = (long)em.createNamedQuery("getShopsCount", Long.class)
	                    .getSingleResult();

	    em.close();

	    //各formに対応した必要な変数の呼び出しとメソッドの実行
	       String week = (String)request.getParameter("day");
	       String theTimeA = (String)request.getParameter("hour");
	       String theTimeB = (String)request.getParameter("minute");
	       String theTime = theTimeA + ":" + theTimeB;
	       String category = (String)request.getParameter("category");
	       String area = (String)request.getParameter("area");


	       shops = hdList(shops, week);
	        if(week.contains("月")) {
	            shops = time1List(shops, theTime);
	        } else if(week.contains("火")){
	            shops = time1List(shops, theTime);
	        } else if(week.contains("水")){
	            shops = time1List(shops, theTime);
	        } else if(week.contains("木")){
	            shops = time1List(shops, theTime);
	        } else if(week.contains("金")){
	            shops = time1List(shops, theTime);
	        } else {
	            shops = time2List(shops, theTime);
	        }
            shops = cgList(shops, category);
            shops = areaList(shops, area);


          //絞り込みで残ったレコードデータ数をshops_countへ反映
            shops_count = shops.size();


	    //最終的なページネーション用のshopリストデータを格納

	    request.setAttribute("shops", shops);
	    request.setAttribute("shops_count", shops_count);
	    request.setAttribute("page", page);



	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
	    rd.forward(request, response);

	    //extentの値に応じた取得対象ショップデータの変更、及びページネーションの仕込み。AllMyの場合
	    } else {
	        List<Shop> shops = em.createNamedQuery("getMyAllShops", Shop.class)
	                .setParameter("user", login_user)
                    .setFirstResult(15 * (page - 1))
                    .setMaxResults(15)
                    .getResultList();

	         long shops_count = (long)em.createNamedQuery("getMyShopsCount", Long.class)
	                 .setParameter("user", login_user)
                     .getSingleResult();

	         em.close();


	         String week = (String)request.getParameter("day");
	           String theTimeA = (String)request.getParameter("hour");
	           String theTimeB = (String)request.getParameter("minute");
	           String theTime = theTimeA + ":" + theTimeB;
	           String category = (String)request.getParameter("category");
	           String area = (String)request.getParameter("area");

	         shops = hdList(shops, week);
             if(week.contains("月")) {
                 shops = time1List(shops, theTime);
             } else if(week.contains("火")){
                 shops = time1List(shops, theTime);
             } else if(week.contains("水")){
                 shops = time1List(shops, theTime);
             } else if(week.contains("木")){
                 shops = time1List(shops, theTime);
             } else if(week.contains("金")){
                 shops = time1List(shops, theTime);
             } else {
                 shops = time2List(shops, theTime);
             }
             shops = cgList(shops, category);
             shops = areaList(shops, area);

           //絞り込みで残ったレコードデータ数をshops_countへ反映
             shops_count = shops.size();

	       //最終的な各Shopデータを指定のjspで利用可能にする処理

	               request.setAttribute("shops", shops);
	               request.setAttribute("shops_count", shops_count);
	               request.setAttribute("page", page);



	               RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
	               rd.forward(request, response);

	    }
    }



	//休日チェック用メソッド
    private List<Shop> hdList(List<Shop> list, String week) {
        List<Shop> newList = new ArrayList<>(list);
        newList.removeIf(shop -> shop.getHoliday().contains(week));
        return newList;
    }


  //時間チェック用メソッド(week=平日)
    private List<Shop> time1List(List<Shop> list, String theTime) {
        List<Shop> newList = new ArrayList<>(list);
        newList.removeIf(shop -> !(theTime.compareTo(shop.getOpen_at1()) >= 0 && theTime.compareTo(shop.getClose_at1()) <= 0));
        return newList;

    }

    //時間チェック用メソッド(week=休日)
    private List<Shop> time2List(List<Shop> list, String theTime) {
        List<Shop> newList = new ArrayList<>(list);
        newList.removeIf(shop -> !(theTime.compareTo(shop.getOpen_at2()) >= 0 && theTime.compareTo(shop.getClose_at2()) <= 0));
        return newList;

    }

    //カテゴリチェック用メソッド 「フォームで指定された値をカテゴリが含む　または　フォームの値が"指定しない"に等しい」に一致しないものを除く
    private List<Shop> cgList(List<Shop> list, String category) {
    List<Shop> newList = new ArrayList<>(list);
    newList.removeIf(shop -> !(shop.getCategory().contains(category) || category.equals("指定しない")));
    return newList;

    }

    //エリアチェック用メソッド
    private List<Shop> areaList(List<Shop> list, String area) {
        List<Shop> newList = new ArrayList<>(list);
        newList.removeIf(shop -> !(shop.getAddress().contains(area)));
        return newList;
    }


}
