package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImple implements IMemberDao {
	
	private static MemberDaoImple dao = null;
	private SqlMapClient smc;
	
	private MemberDaoImple() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static MemberDaoImple getInstance() {
		if(dao == null) {
			dao = new MemberDaoImple();
		}
		return dao;
	}
	
	@Override
	public String idCheck(String mem_id) throws SQLException {
		String id = (String)smc.queryForObject("member.idCheck", mem_id);
		
		return id;
	}

	@Override
	public List<ZipVO> searchZip(String input) throws SQLException {
		List<ZipVO> zip = smc.queryForList("member.searchZip", input);
		return zip;
	}

	@Override
	public String insertMember(MemberVO memVo) throws SQLException {
		 String id = (String)smc.insert("member.insertMember",memVo);
		 return id;
	}

}
