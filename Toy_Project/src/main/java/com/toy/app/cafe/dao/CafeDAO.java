package com.toy.app.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.app.cafe.vo.CafeVO;
import com.toy.mybatis.config.SqlMapConfig;

public class CafeDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInterface();
	SqlSession sql_session;

	public CafeDAO() {
		sql_session = sessionf.openSession(true); // 오토커밋
	}

	public List<CafeVO> getProductList() { 
		return sql_session.selectList("cafe.getProductList");
	}
	
	public void purchaseCnt(String product_name) { 
		sql_session.update("cafe.purchaseCnt", product_name);
	}
	
	public List<CafeVO> getPurchaseView() { 
		return sql_session.selectList("cafe.getPurchaseView");
	}
	
	public List<CafeVO> getTop3() { 
		return sql_session.selectList("cafe.getTop3");
	}
}
