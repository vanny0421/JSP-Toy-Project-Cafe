package com.toy.app.cafe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.action.Action;
import com.toy.action.ActionForward;
import com.toy.app.cafe.dao.CafeDAO;

public class CafePurchasePageOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("결제까지 들어옴");
		
		forward.setRedirect(false);

		System.out.println("product_name : " + req.getParameter("product_name"));
		
		req.setAttribute("product_img_url", req.getParameter("imageURL"));
		req.setAttribute("product_Name", req.getParameter("product_name"));
		req.setAttribute("product_Price", req.getParameter("product_price")); 
		
		forward.setPath("/popup.jsp");

		return forward;
	}
}
