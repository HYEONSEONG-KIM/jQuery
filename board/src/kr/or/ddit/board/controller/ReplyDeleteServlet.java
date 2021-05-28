package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;


@WebServlet("/ReplyDelete.do")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private IBoardService service = null;
	
    public ReplyDeleteServlet() {
    	service = BoardServiceImpl.getInstace();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int renum = Integer.parseInt(request.getParameter("vidx"));
		
		int result = service.replyDelete(renum);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/board/result.jsp");
		rd.forward(request, response);
	}

}
