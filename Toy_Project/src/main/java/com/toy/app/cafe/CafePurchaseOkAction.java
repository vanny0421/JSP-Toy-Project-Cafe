package com.toy.app.cafe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.action.Action;
import com.toy.action.ActionForward;
import com.toy.app.cafe.dao.CafeDAO;

public class CafePurchaseOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();
		CafeDAO dao = new CafeDAO();

		System.out.println("이름은 : " + req.getParameter("product_name"));
		req.setAttribute("product_Name", req.getParameter("product_name"));
		
		System.out.println(req.getParameter("product_name"));
		dao.purchaseCnt(req.getParameter("product_name"));
		
		System.out.println("결제까지 됨");
		
		forward.setRedirect(false);
		forward.setPath("/cancel.jsp");

		return forward;
	}
}
