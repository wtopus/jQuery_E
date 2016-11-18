package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myFirstServlet
 */
@WebServlet("/first") // 서버프로그램 이름
public class myFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받고 함수 출력
		response.setContentType("text/plain; charset=utf8");// 출력하려는 데이터의  종류를 먼저 알려줘야함 -> 의미 : 문자를 유니코드로 주겠다?//text / html, image / jpg, image/ png 
		PrintWriter out = response.getWriter(); // 출력하기 위한 데이터연결 통로인 stream을 만든다.
		out.println("서버로부터 전달된메시지!!"); // 연결통로를 통해서 데이터를 클라이언트에게 전달
		out.flush(); // 데이터출력을 정확히 처리하기 위해 flush 작업을 해준다.
		out.close(); // 사용된 자원 해제
	}// 클라이언트가 서버 호출하면 doget 실행된다

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
