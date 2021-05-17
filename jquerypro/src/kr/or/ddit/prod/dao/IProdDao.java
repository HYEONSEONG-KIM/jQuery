package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	
	public List<ProdVO> prodSelect(String prod_lgu) throws SQLException;
	public ProdVO selectProdName(String prod_id) throws SQLException;
	
}
