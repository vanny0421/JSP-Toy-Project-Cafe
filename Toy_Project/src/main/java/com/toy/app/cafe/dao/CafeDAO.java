package com.toy.app.cafe.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.mybatis.config.SqlMapConfig;

public class CafeDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInterface();
	SqlSession sql_session;

	public CafeDAO() {
		sql_session = sessionf.openSession(true); // 오토커밋
	}
	
	public int getProduct_cnt() { // 주문갯수
		return sql_session.selectOne("cafe.getProduct_cnt");
	}
}
