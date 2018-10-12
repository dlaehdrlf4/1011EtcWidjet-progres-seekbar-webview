package com.gil.mobileweb;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gil.mobileweb.dao.GoodDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestClass {
	// SqlSession을 자동주입받아서 sqlsession이 잘되는 지 확인
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private GoodDao goodDao;
	
	@Test
	public void method() {
		System.out.println(sqlSession);
		System.out.println(goodDao.list());
		//아무것도 안뜨면 sqlSession 잘못
	}
}
