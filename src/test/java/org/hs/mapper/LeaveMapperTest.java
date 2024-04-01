package org.hs.mapper;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hs.domain.EmployeeVO;
import org.hs.domain.LeaveVO;
import org.hs.domain.PersonalLeaveDayVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LeaveMapperTest {
	@Autowired
	private LeaveMapper mapper;

//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(leave -> log.info(leave));
//	}

//	leavetype,leavenum,startdate,enddate,
//	leavedays,requestdate,leavereason,empnum
//	,empname,deptnum,deptname
	
//	@Test
//	public void testInsert() throws Exception {
//		SimpleDateFormat formdate = new SimpleDateFormat("yy-MM-dd");
//		Date stratDate = formdate.parse("24-03-01");
//		Date endDate = formdate.parse("24-03-02");
//		Date requestDate = formdate.parse("24-02-25");
//		
//		LeaveVO leave= new LeaveVO();
//	
//		leave.setStartDate(stratDate);
//		leave.setEndDate(endDate);
//		leave.setRequestDate(requestDate);
//		leave.setLeaveDays(2);
//		leave.setLeaveType("연차");
//		leave.setLeaveReason("쉬고싶어서어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어어");
//		leave.setEmpNum("101");
//		
//		mapper.insert(leave);
//	}


//	@Test
//	public void testGetDetail() {
//		
//	LeaveVO leave = mapper.getDetail(24L);
//		log.info(leave);
//	}
	
//	@Test
//	public void testUpdate()throws Exception {
//		
//		LeaveVO leave = new LeaveVO();
//		SimpleDateFormat formdate = new SimpleDateFormat("yy-MM-dd");
//		Date stratDate = formdate.parse("24-03-23");//시작날짜보다 종료날짜가 빠를 수 없다. 제약조건 무조건 걸어야함
//		Date endDate = formdate.parse("24-03-25");
//		Date requestDate = formdate.parse("24-03-19");
//		
//		leave.setLeaveNum(24L);
//		leave.setStartDate(stratDate);
//		leave.setEndDate(endDate);
//		leave.setRequestDate(requestDate);
//		leave.setLeaveDays(3);
//		leave.setLeaveType("출산휴가");
//		leave.setLeaveReason("알고보니 어제 제 아내가 아들을 낳았더라구요.");
//		//leave.setEmpNum("202");
//		
//	log.info(mapper.update(leave));
//		
//	}
	
//	@Test
//	public void testDelete() {
//		
//		log.info(mapper.delete(25L));
//		
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
