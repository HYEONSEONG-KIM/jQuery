package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	// 페이지별 리스트 가져오기
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException;
	
	// 전체글 갯수 가져오기
	public int countList() throws SQLException; 
}
