package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	private IProdDao dao = null;
	private static ProdServiceImpl service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static ProdServiceImpl getInstance(){
		if(service == null){
			service = new ProdServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<ProdVO> prodSelect(String prod_lgu){
		
		List<ProdVO> list = null;
		try {
			list = dao.prodSelect(prod_lgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProdVO selectProdName(String prod_id){
		ProdVO prod = null;
		try {
			prod = dao.selectProdName(prod_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod;
	}

}
