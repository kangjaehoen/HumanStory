package org.hs.mapper;

import java.util.List;

import org.hs.domain.Criteria;
import org.hs.domain.EmployeeVO;
import org.hs.domain.EmployeeVO2;
import org.hs.domain.LeaveDTO;
import org.hs.domain.LeaveVO;
import org.hs.domain.LeaveVO2;

public interface LeaveMapper {
	
	public List<LeaveVO> getList(); //휴가 조회
	public List<LeaveVO2> getList2(); //휴가 조회
	public List<EmployeeVO2> getListEmp(); //휴가 조회
	public List<LeaveVO> getListWithPaging(Criteria cri);
	public void insert(LeaveDTO leave); //휴가 신청
	public Integer insertSelectKey(LeaveDTO leave);
	public LeaveVO getLeaveOne(Long leaveNum); //휴가 상세 조회
	public int delete(Long leaveNum); //휴가 삭제
	public int update(LeaveDTO leave); //휴가 수정
	public int getTotalCount(Criteria cri);
	//aspect 사용해야함65
	//휴가 신청만되고 
	//휴가 잔여일수가 -1이 안되는 경우가 발생 할 수 있어서
	//트랜잭션 무조건 필요
}
