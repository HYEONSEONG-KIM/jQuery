package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/List.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IBoardService service = null;
    
    public BoardListServlet() {
    	service = BoardServiceImpl.getInstace();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청시 전송되는 데이터
		int pageNum = 1;
		pageNum = Integer.parseInt(request.getParameter("page"));
		
		// 한 페이지에 출력할 글 갯수
		int perList = 5;
		// 한 화면에 출력할 페이지 수
		int perPage = 2;
		
		// 전체글 개수
		int countList = service.countList();
				
		// 전체 페이지수
		int totalPage = (int)Math.ceil((double)countList/ perList);
		System.out.println(totalPage);
		
		// 화면에 보여지는 페이지 번호
		// 1 -> 1,2  2->1,2  3-> 3,4  4->3,4 ...
		int startPage = ((pageNum - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		// 페이지에 따라서 start, end - 보여지는 게시글
		int start = (pageNum - 1) * perList + 1;
		int end = start + perList - 1;
		
		if(end > countList) {
			end = countList;
		}
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end", end);
		
		
		// 결과값 받기
		List<BoardVO> boardList = service.boardList(map);
		
		// request 저장
		request.setAttribute("list", boardList);
		request.setAttribute("sp", startPage);
		request.setAttribute("ep", endPage);
		request.setAttribute("tp", totalPage);
		
		// jsp로 포워딩
		RequestDispatcher rd = 
				request.getRequestDispatcher("board/list.jsp");
		rd.forward(request, response);
	}

	
	
	
	
	
	
	
	
}
