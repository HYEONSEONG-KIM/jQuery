package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdService {
	
	public List<ProdVO> prodSelect(String prod_lgu);
	public ProdVO selectProdName(String prod_id) ;
	
}
