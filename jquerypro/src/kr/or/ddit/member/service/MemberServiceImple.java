package kr.or.ddit.member.service;

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
		return service.idCheck(mem_id);
	}

	@Override
	public ZipVO searchZip(String input) {
		// TODO Auto-generated method stub
		return service.searchZip(input);
	}

	@Override
	public void insertMember(MemberVO memVo) {
		service.insertMember(memVo);
	}

}
