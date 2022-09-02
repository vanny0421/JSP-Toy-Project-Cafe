package com.toy.app.cafe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.action.ActionForward;

public class CafeFrontController extends HttpServlet{
	/* 
	 * 이렇게 web.xml에 매핑되어 있는 경로를 통해서 들어온 서블릿을 Front Controller라고 한다
	 * 가장 먼저 요청을 맞이하는 컨트롤러라서 프론트 컨트롤러 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post , Get 방식 중에 어떤 방식으로 와도 doProcess 메서드로 가게 해라 
		doProcess(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Post , Get 방식 중에 어떤 방식으로 와도 doProcess 메서드로 가게 해라
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String requestURI = req.getRequestURI();	// /Toy_Project/starbucks.ca 
		String contextPath = req.getContextPath();	// /Toy_Project
		String command = requestURI.substring(contextPath.length());  // starbucks.ca
		
		ActionForward forward = null;
		
		System.out.println("requestURI : " + requestURI);
		System.out.println("contextPath : " + contextPath);
		System.out.println("command : " + command);
		
		// 페이지 이동은 case문 하나하나에 써주는 것이 아니라 switch문이 끝나고 마지막에 일괄로 처리해 주면 됨
		switch (command) { // 모든 요청을 하나의 컨트롤러로 모으면 컨트롤러에서는 switch ~ case 문을 이용해서 나눠서 맞게 처리해주면 된다.
		case "/starbucks.ca": // .ca 앞에 있는 starbucks , purchasePage 으로 어떤 로직을 수행할지 판단하고 분기처리 (switch문)를 하게 됨.
			System.out.println("스위치문 들어옴");  
			// 처리를 ~~Action 클래스에서 하기 위해 req, resp를 파라미터로 같이 보냄
			try {forward = new CafeViewOkAction().execute(req, resp);} catch (Exception e) {System.out.println(e);}
			break;				/* 해당 Action안에 execute() 메서드를 만들어서 그 내부에 비즈니스 로직을 구현하면
	  							 * Front Controller에서는 그 Action 객체를 만든 후 execute 메서드만 호출하면 된다 */
		case "/purchasePage.ca":
			System.out.println("결제 페이지 들어옴");
			try {forward = new CafePurchasePageOkAction().execute(req, resp);} catch (Exception e) {System.out.println(e);}
			break;
		case "/starbucksR.ca":
			System.out.println("결제 완료 들어옴");
			try {forward = new CafePurchaseOkAction().execute(req, resp);} catch (Exception e) {System.out.println(e);}
			break;
		}

		// 일괄 처리
		// 어디로 이동할지 (Path) / 어떤 방식일지 (Redirect, Forward)
		// 그냥 페이지를 이동하는거면 상관 없지만 DB 처리를 하기 위해 다른 클래스로 갔다가
		// 그 페이지에서 어디로 어떤 방식으로 보낼지 값을 반환 받을때 두개의 값을 받아 오는 방법은 없어서
		// ActionForward 타입의 forward 객체를 만들어 그 필드에 어디로 이동하고 어떤 방식으로 이동할지를 설정하고 받아오게 함
		if (forward != null) { 
			if (forward.isRedirect()) { 
				resp.sendRedirect(forward.getPath());
			} else {
				// RequestDispatcher = 페이지를 이동시켜주는 거
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
