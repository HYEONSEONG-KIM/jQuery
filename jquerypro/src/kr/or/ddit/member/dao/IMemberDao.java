package kr.or.ddit.member.dao;

import java.sql.SQLException;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {

	
	// 아이디 중복검사
	public String idCheck(String mem_id) throws SQLException;
	// 우편변호 검색
	public ZipVO searchZip(String input) throws SQLException;
	// 저장
	public void insertMember(MemberVO memVo) throws SQLException;
}
