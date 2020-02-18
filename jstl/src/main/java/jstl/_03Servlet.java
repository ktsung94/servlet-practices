package jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/03")
public class _03Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		List<UserVo> list = new ArrayList<>();
		
		// request scope
		UserVo vo1 = new UserVo();
		vo1.setNo(1L);
		vo1.setName("김태성1");	
		request.setAttribute("vo", vo1);
		list.add(vo1);
		
		// session scope
		UserVo vo2 = new UserVo();
		vo2.setNo(2L);
		vo2.setName("김태성2");
		request.getSession(true).setAttribute("vo",vo2);
		list.add(vo2);
		
		UserVo vo3 = new UserVo();
		vo3.setNo(3L);
		vo3.setName("김태성3");
		request.getSession(true).setAttribute("vo",vo2);	
		list.add(vo3);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/03.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
