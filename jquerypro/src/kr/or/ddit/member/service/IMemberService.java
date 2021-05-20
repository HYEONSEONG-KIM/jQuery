package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	// 아이디 중복검사
	public String idCheck(String mem_id);
	// 우편변호 검색
	public List<ZipVO> searchZip(String input);
	// 저장
	public String insertMember(MemberVO memVo);
}
