package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	// 페이지별 리스트 가져오기
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException;
	
	// 전체글 갯수 가져오기
	public int countList() throws SQLException; 
	
	// 글쓰기 저장
	public int insertBoard(BoardVO boardvo) throws SQLException;

	//댓글 저장 - renum을 리턴
	public int insertReply(ReplyVO vo) throws SQLException;
	
	public List<ReplyVO> replyList(int bonum) throws SQLException;
}
