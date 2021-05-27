package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.BuildedSqlMapClient;

public class BoardDaoImpl implements IBoardDao{
	
	private SqlMapClient smc = null;
	private static BoardDaoImpl dao = null;
	
	private BoardDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}

	
	public static BoardDaoImpl getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException {
		
		return smc.queryForList("board.boardList", map);
	}


	@Override
	public int countList() throws SQLException {
		return (Integer)smc.queryForObject("board.countList");
	}


	@Override
	public int insertBoard(BoardVO boardvo) throws SQLException {
		return (Integer)smc.insert("board.insertBoard", boardvo);
	}


	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (Integer) smc.insert("board.insertReply", vo);
	}


	@Override
	public List<ReplyVO> replyList(int bonum) throws SQLException {
		return smc.queryForList("board.replyList", bonum);
	}

}
