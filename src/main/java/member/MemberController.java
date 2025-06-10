package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mcontrol")
public class MemberController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("actor");
		String view = "";
		if(action == null) {
			getServletContent().getRequestDispatcher("/mcontrol?action=list").forward(req, resp);
		}else {
			switch(action) {
			case "list":view = list(req, resp); break;
			case "insert": view = insert(req, resp); break;
			}
			getServletContext().getRequestDispacher(view).forward(req,resp);
		}
	}
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("memberlist",  dao.getAll());
		return "/memberinfo.jsp";
	}
	public String insert(HttpServletRequest req, HttpServletResponse resp) {
		return "";
	}
}
