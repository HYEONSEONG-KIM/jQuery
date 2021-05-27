package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;
import sun.print.resources.serviceui;


@WebServlet("/ReplyList.do")
public class ReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IBoardService service = null;
	
    public ReplyListServlet() {
    	service = BoardServiceImpl.getInstace();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		List<ReplyVO> list = service.replyList(bonum);
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/board/replyList.jsp");
		rd.forward(request, response);
	}

}
