package com.toy.app.cafe;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.action.Action;
import com.toy.action.ActionForward;
import com.toy.app.cafe.dao.CafeDAO;
import com.toy.app.cafe.vo.CafeVO;
								
public class CafeViewOkAction implements Action { // Action 인터페이스 상속 받음
	/*
	 * 프론트 컨트롤러 안에서 모든 비즈니스 로직을 구현해 놓게 되면 코드가 너무 길어지고 
	 * 유지보수 및 재사용이 어렵기 때문에 요청별로 따로 Controller (~~~Action, ~~OkAction)를 만들어 놓는다
	 */
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = new ActionForward();
		CafeDAO dao = new CafeDAO();
		
		/* 여기가 비즈니스 로직
		 * 비즈니스 로직 안에서는 우리가 만든 DAO객체를 통해 DB와 데이터를 주고 받으면서 원하는 결과를 추출하는 로직을 짠다. */
		
		List<CafeVO> vo = dao.getProductList(); 
		List<CafeVO> list = dao.getPurchaseView();
		List<CafeVO> cnt = dao.getTop3();
		
		List<CafeVO> cntList = new ArrayList<>(cnt.subList(0, 3));
		
		req.setAttribute("cafeLeft", vo);
		req.setAttribute("cafeRight", list);
		req.setAttribute("cafeTopLeft", cntList);
		
//		req.setAttribute("cafe", dao.getProduct_cnt()); 
		
		/* 비즈니스 로직이 모두 완료되면 어떤 페이지로 이동 할 건지, 어떤 방식 (Redirect, Forward)으로 이동할 것인지
		 * path는 어디인지 정해서 Front Controller로 리턴을 하고
		 * 이때 리턴할 값이 두개이므로 그 둘을 담을 객체를 만들어서 리턴을 해줌 
		 * 그 객체 타입은 ActionForward 클래스 형 타입이다. 
		 * 비즈니스 로직이 끝나면 결과로 경로(Path)와 방식을 ActionForward 타입의 객체를 만들어서 리턴한다 */
		forward.setRedirect(false);
		forward.setPath("/cafe.jsp");

		return forward;
	}

}
