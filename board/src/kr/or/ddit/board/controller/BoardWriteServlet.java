package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/Write.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBoardService service = null;
	
    public BoardWriteServlet() {	
    	service = BoardServiceImpl.getInstace();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 요청데이터
		BoardVO boardvo = new BoardVO();
		
		
		try {
			// 요청에 받아왔던 데이터 일일히 객체에 담아주지 않고 한번에 넣어줌(컬럼명과 vo객체에 속성, 요청시 name값 동일해야함)
			BeanUtils.populate(boardvo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boardvo.setWip(request.getRemoteAddr());
		int seq = service.insertBoard(boardvo);
		
		request.setAttribute("result", seq);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/result.jsp");
		rd.forward(request, response);
		
	}

}
