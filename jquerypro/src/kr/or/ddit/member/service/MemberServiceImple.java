package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImple;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import sun.print.resources.serviceui;

public class MemberServiceImple implements IMemberService {

	private static MemberServiceImple service = null;
	private IMemberDao dao = null;
	
	private MemberServiceImple() {
		dao = MemberDaoImple.getInstance();
	}
	
	public static MemberServiceImple getInstance() {
		if(service == null) {
				service = new MemberServiceImple();
		}
		return service;
	}
	
	@Override
	public String idCheck(String mem_id) {
		String id =null;
		try {
			id = dao.idCheck(mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<ZipVO> searchZip(String input) {
		// TODO Auto-generated method stub
		List<ZipVO> zip = null;
		try {
			zip = dao.searchZip(input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zip;
	}

	@Override
	public String insertMember(MemberVO memVo) {
		String id = null;
		try {
			id = dao.insertMember(memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
