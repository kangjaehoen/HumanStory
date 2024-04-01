package org.hs.service;

import java.util.ArrayList;
import java.util.List;

import org.hs.domain.Criteria;
import org.hs.domain.LeaveAndEmployeeVO;
import org.hs.domain.LeaveDTO;
import org.hs.domain.LeaveVO;
import org.hs.domain.LeaveVO2;
import org.hs.domain.PersonalLeaveDayVO;
import org.hs.mapper.LeaveMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service
@AllArgsConstructor
@Log4j
public class LeaveServiceImpl implements LeaveService {
	
	
	//aspect 사용해야함
	//휴가 신청만되고 
	//휴가 잔여일수가 -1이 안되는 경우가 발생 할 수 있어서
	//트랜잭션 무조건 필요
	private LeaveMapper mapper;

	@Override
	public void registerLeave(LeaveDTO leave) {
		log.info("Mapper 작동입니다...");
		log.info("registerLeave 입니다...");
		mapper.insertSelectKey(leave);
	}
	
	@Override
	public List<LeaveVO> getLeaveCharts() {
		log.info("Mapper 작동입니다...");
		log.info("getList 입니다...");
		return mapper.getList();
	}

	@Override
	public LeaveVO getLeaveOne(Long leaveNum) {
		log.info("Mapper 작동입니다...");
		log.info("getLeaveOne 입니다...");
		return mapper.getLeaveOne(leaveNum);
	}

	@Override
	public boolean modifyLeave(LeaveDTO leave) {
		log.info("Mapper 작동입니다...");
		log.info("modifyLeave 입니다...");
		return mapper.update(leave)==1;
	}

	@Override
	public boolean removeLeave(Long leaveNum) {
		log.info("Mapper 작동입니다...");
		log.info("removeLeave 입니다...");
		return mapper.delete(leaveNum)==1;
	}




	@Override
	public int getTotalCount(Criteria cri) {
		log.info("get total...........");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<LeaveAndEmployeeVO> getListLE() {
	    List<LeaveAndEmployeeVO> resultList = new ArrayList<>(); // 리스트 생성
	    
	    LeaveAndEmployeeVO result = new LeaveAndEmployeeVO();
	    result.setLeaveList(mapper.getList2());
	    result.setEmployeeList(mapper.getListEmp());
	    
	    System.out.println(result);
	    
	    resultList.add(result); // 리스트에 결과 추가
	    
	    return resultList; // 리스트 반환
	}

	@Override
	public LeaveAndEmployeeVO getLeaveAndEmployee() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
