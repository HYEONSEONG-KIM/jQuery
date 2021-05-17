package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdController
 */
@WebServlet("/Prod.do")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IProdService service;
    public ProdController() {
    	service = ProdServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청 데이터 가져오기
		// Service 클래스 객체 얻어오기
		// Service클래스의 메서드 호출
		// json형태의 응답 데이터 생성 - jsp에 위임
		// 결과값을 request에 저장
		// jsp로 포워드 - sevletdml request객체변수를 jsp에서 공유
		
		
			String prod_lgu = request.getParameter("gu");
			List<ProdVO> list = service.prodSelect(prod_lgu);
			
			
			request.setAttribute("listvalue", list);
			
			RequestDispatcher disp = 
					request.getRequestDispatcher("0517/prodNames.jsp");
			
			disp.forward(request, response);
			
		
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
