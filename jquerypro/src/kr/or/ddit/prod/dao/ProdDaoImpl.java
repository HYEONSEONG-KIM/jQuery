package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildedSqlMapClient;
import kr.or.ddit.prod.vo.ProdVO;

/*
 * sql구문을 실행하기 위한 class
 * SqlMapClient객체가 필요
 */
public class ProdDaoImpl implements IProdDao{
	
	private SqlMapClient smc;
	private static ProdDaoImpl dao;
	
	private ProdDaoImpl(){
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ProdDaoImpl getInstance(){
		if(dao ==null){
			dao = new ProdDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public List<ProdVO> prodSelect(String prod_lgu) throws SQLException {
		List<ProdVO> list = null;
		list = smc.queryForList("prod.prodSelect", prod_lgu);
		
		return list;
	}

	@Override
	public ProdVO selectProdName(String prod_id) throws SQLException {
		ProdVO prodVo = (ProdVO) smc.queryForObject("prod.selectProdName", prod_id);
		return prodVo;
	}

}
