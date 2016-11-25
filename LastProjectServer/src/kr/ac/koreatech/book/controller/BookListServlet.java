package kr.ac.koreatech.book.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.koreatech.book.dto.BookDTO;

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
		System.out.println(keyword);
		
		String tmp = request.getParameter("callback");
		// 2. 로직 처리 ( DB 처리를 포함 )
		// Tomcat Webserver가 제공하는 DBCP방법으로 데이터베이스를 이용
		// 2-1. Driver Loading
		// 2-2. 접속
		Connection con = common.DBTemplate.getConnection();
		// 2-3. PreparedStatement
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		String sql = "select bimgurl, btitle, bauthor, bprice, bisbn from book where btitle like ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			while( rs.next() ){
				BookDTO entity = new BookDTO(); // VO, DO, DTO, Entity
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBimgurl(rs.getString("bimgurl"));
				entity.setBtitile(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				entity.setBprice(rs.getString("bprice"));
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		common.DBTemplate.close(rs);
		common.DBTemplate.close(pstmt);
		common.DBTemplate.close(con);
		
		// 3. 출력처리 
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		// 출력처리 유식한방법 ( 라이브러리이용 - JACKSON )
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		System.out.println(json);
		
		out.println(tmp + "(" + json + ")");
		out.flush();
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
