package com.toy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
	/* 모든 ~~Action 클래스에 execute() 메서드를 구현해야 하기 때문에 ~~Action 클래스의 틀을
	 * Action 인터페이스로 만들고 그 안에 추상메서드로 execute()을 선언해 놓으면 
	 * 각 ~~Action 클래스 마다 그 인터페이스를 상속 받고 오버라이드 해서 구현 하면된다 */
}
