package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {

	public List<BoardVO> boardList(Map<String, Integer> map);
	
	public int countList();
	
	public int insertBoard(BoardVO boardvo);
	
	//댓글 저장 - renum을 리턴
	public int insertReply(ReplyVO vo);
	
	public List<ReplyVO> replyList(int bonum);
	
	public int replyUpdate(ReplyVO replyvo);
	
	public int replyDelete(int renum);
}
