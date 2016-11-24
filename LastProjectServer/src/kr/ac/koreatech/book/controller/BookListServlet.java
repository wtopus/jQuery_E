package kr.ac.koreatech.book.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력 
		String keyword = request.getParameter("keyword");
		String tmp = request.getParameter("callback");
		// 2. 로직 처리 ( DB 처리를 포함 )
		// Tomcat Webserver가 제공하는 DBCP방법으로 데이터베이스를 이용
		// 2-1. Driver Loading
		// 2-2. 접속
		Connection con = common.DBTemplate.getConnection();
		// 2-3. PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bimgurl, btitile, bauthor, bprice, bisbn from book where btitile like ?";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while( rs.next() ){
				// ???
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
