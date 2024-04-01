package org.hs.mapper;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hs.domain.CalendarVO;
import org.hs.domain.addLeavesDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CalendarMapperTests {
	
	@Autowired
	private CalendarMapper mapper;
	
	
	  @Test public void test() { mapper.getList().forEach(board ->
	  log.info(board)); }
	 
	
	/*
	 * @Test public void testInsert()throws Exception { addLeavesDTO leaves = new
	 * addLeavesDTO(); leaves.setEmpNum(1010); leaves.setDeptNum(1000);
	 * SimpleDateFormat formdate = new SimpleDateFormat("yy-MM-dd"); Date startDate
	 * = formdate.parse("24-03-02"); Date endDate = formdate.parse("24-03-05");
	 * leaves.setStartDate(startDate); leaves.setEndDate(endDate);
	 * leaves.setLeaveType("연차"); leaves.setLeaveReason("놀러가고 싶어요!");
	 * 
	 * 
	 * 
	 * mapper.insert(leaves); log.info(leaves);
	 * 
	 * 
	 * }
	 */

}
