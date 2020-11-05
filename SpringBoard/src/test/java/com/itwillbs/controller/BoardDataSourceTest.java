package com.itwillbs.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class BoardDataSourceTest {
	
	// DataSource 객체 생성(DI)
	@Inject
	private DataSource ds;
	
	@Test
	public void testDataSource() throws Exception{
		// throws Exception : 예외를 던져서 메서드를 부르는 메소드에 예외 처리를 한다.
		System.out.println("테스트 작동 시작");
		
		System.out.println("ds : " + ds);
		System.out.println("---------------------------------------------");
		
		
		try( Connection con = ds.getConnection()){
			System.out.println("con : " + con);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("테스트 작동 끝");
	}
	
	

}
