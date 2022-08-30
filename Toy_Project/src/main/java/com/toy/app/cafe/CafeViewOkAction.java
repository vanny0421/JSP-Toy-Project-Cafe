package com.toy.app.cafe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.action.Action;
import com.toy.action.ActionForward;
import com.toy.app.cafe.dao.CafeDAO;

public class CafeViewOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		int cs_board_no = Integer.parseInt(req.getParameter("cs_board_no"));

		ActionForward forward = new ActionForward();
		CafeDAO c_dao = new CafeDAO();
		System.out.println("요기 찍히나");
		System.out.println("요기 찍히나");
		System.out.println("요기 찍히나");
		System.out.println("요기 찍히나");
		System.out.println("요기 찍히나");
		System.out.println(c_dao.getProduct_cnt());
		req.setAttribute("cafe", c_dao.getProduct_cnt()); 
		
		forward.setRedirect(false);
		forward.setPath("/index.jsp");

		return forward;
	}

}
