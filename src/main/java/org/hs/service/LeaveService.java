package org.hs.service;

import java.util.List;

import org.hs.domain.Criteria;
import org.hs.domain.LeaveAndEmployeeVO;
import org.hs.domain.LeaveDTO;
import org.hs.domain.LeaveVO;
import org.hs.domain.LeaveVO2;

public interface LeaveService {
	
	public List<LeaveVO> getLeaveCharts();//전체 조회
	public LeaveVO getLeaveOne(Long leaveNum);//세부 조회
	public void registerLeave(LeaveDTO leave);//휴가 신청
	public boolean modifyLeave(LeaveDTO leave);//휴가 수정
	public boolean removeLeave(Long leaveNum);//휴가 삭제
	public int getTotalCount(Criteria cri);
	public LeaveAndEmployeeVO getLeaveAndEmployee();
	public List<LeaveAndEmployeeVO> getListLE();
}