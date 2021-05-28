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
import kr.or.ddit.board.vo.ReplyVO;


@WebServlet("/ReplyUpdata.do")
public class ReplyUpdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService service = null;
  
    public ReplyUpdataServlet() {
    	service = BoardServiceImpl.getInstace();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ReplyVO replyvo = new ReplyVO();
		replyvo.setCont(request.getParameter("cont"));
		replyvo.setRenum(Integer.parseInt(request.getParameter("renum")));
		
		int result = service.replyUpdate(replyvo);
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/result.jsp");
		rd.forward(request, response);
	}

}








