package org.hs.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hs.domain.LeaveVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LeaveServiceTests {
	
	@Autowired
	private LeaveService service;
	
//	@Test
//	public void getLeaveListTest() {
//		service.getLeaveCharts();
//		log.info("Service 작동입니다...");
//		log.info("getLeaveCharts 작동 완료...");
//	}
	
//	@Test
//	public void getLeaveOneTest() {
//		service.getLeaveOne(40L);
//		log.info("Service 작동입니다...");
//		log.info("getLeaveOne 작동 완료...");
//	}
	
//	@Test
//	public void registerLeaveTest()throws Exception{
//		LeaveVO leave = new LeaveVO();
//		SimpleDateFormat formdate = new SimpleDateFormat("yy-MM-dd");
//		Date stratDate = formdate.parse("24-01-06");
//		Date endDate = formdate.parse("24-01-02");
//		Date requestDate = formdate.parse("24-01-01");
//		
//		leave.setLeaveType("연차");
//		leave.setStartDate(stratDate);
//		leave.setEndDate(endDate);
//		leave.setLeaveDays(4.5);
//		leave.setRequestDate(requestDate);
//		leave.setLeaveReason("일수 증가해브러~");
//		leave.setEmpNum(202);
//		leave.setEmpName("최길동");
//		leave.setDeptNum(200);
//		leave.setDeptName("법률팀");
//		
//		service.registerLeave(leave);
//		log.info("Service 작동입니다...");
//		log.info("registerLeave 작동 완료...");
//	}
	
//	@Test
//	public void modifyLeaveTest()throws Exception {
//		LeaveVO leave = new LeaveVO();
//		SimpleDateFormat formdate = new SimpleDateFormat("yy-MM-dd");
//		Date stratDate = formdate.parse("24-01-06");
//		Date endDate = formdate.parse("24-01-02");
//		Date requestDate = formdate.parse("24-01-01");
//
//		leave.setLeaveNum(42L);
//		leave.setLeaveType("수정");
//		leave.setStartDate(stratDate);
//		leave.setEndDate(endDate);
//		leave.setLeaveDays(4.5);
//		leave.setRequestDate(requestDate);
//		leave.setLeaveReason("수정");
//		leave.setEmpNum(0);
//		leave.setEmpName("수정");
//		leave.setDeptNum(0);
//		leave.setDeptName("수정");
//		leave.setPa_count(15);
//		
//		boolean result = service.modifyLeave(leave);
//		
//		log.info("Service 작동입니다...");
//		log.info("modifyLeave 작동완료...");
//		log.info("결과 값: " + result);
//		
//	}

//	@Test
//	public void removeLeaveTest() {
//		
//		service.removeLeave(40L);
//		
//		log.info("Service 작동입니다...");
//	    log.info("removeLeave 작동완료...");
//		
//	}
	
	
	

}
