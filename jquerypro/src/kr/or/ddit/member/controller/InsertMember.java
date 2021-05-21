package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sun.javafx.collections.MappingChange.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImple;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IMemberService service = null;
    
    public InsertMember() {
        service = MemberServiceImple.getInstance();
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청시 데이터 가져오기
		MemberVO vo = new MemberVO();
		
		try {
			// 요청에 받아왔던 데이터 일일히 객체에 담아주지 않고 한번에 넣어줌(컬럼명과 vo객체에 속성, 요청시 name값 동일해야함)
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = service.insertMember(vo);
		
		request.setAttribute("result", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/0518/insert.jsp");
		rd.forward(request, response);
		
		
	}

}












