package com.hb.guest.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GuestDaoTest {

	@Test
	public void testSelectOne() throws Exception {
		int sabun =1111;
		GuestDao dao = new GuestDao();
		GuestDto dto = dao.selectOne(sabun);
		assertNotNull(dto);
		assertEquals(1111,dto.getSabun());
		assertEquals("aaaa",dto.getName());
	}
	
	@Test
	public void testSelectAll() throws Exception {
		GuestDao dao = new GuestDao();
		ArrayList list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	public void testInsertOne() throws Exception {
//		GuestDao dao = new GuestDao();
//		GuestDto dto = new GuestDto();
//		dto.setSabun(0);
//		dto.setName("test");
//		dto.setPay(0);
//		dao.insertOne(dto);
//		dao = new GuestDao();
//		assertEquals(dto, dao.selectOne(0));
	}
	
}











