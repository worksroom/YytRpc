package com.yyt.print.base;

import com.youguu.core.dao.SqlDAO;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

public class YytBaseDAO<T> extends SqlDAO<T> {
	public YytBaseDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "yytSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
