package Producteg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/PController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService service; // ProductService 필드 선언
	
	// 생성자
	public ProductController() {
		super();
		service = new ProductService(); // ProductService 인스턴스 생성
	}

	// GET 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", service.findAll());
		getServletContext().getRequestDispatcher("/productlist.jsp").forward(request, response);
		
		// forward 이후에는 더 이상 응답을 작성하지 마세요.
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// POST 요청 처리 (GET 요청으로 위임)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
