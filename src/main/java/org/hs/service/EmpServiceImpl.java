package org.hs.service;

import java.util.List;

import org.hs.domain.EmpCriteria;
import org.hs.domain.EmployeeVO;
import org.hs.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j

public class EmpServiceImpl implements EmpService {
	
	private EmpMapper mapper;
	
	@Override
	public void register(EmployeeVO emp) {
		mapper.insertEmpInfo(emp);
	}

	@Override
	public List<EmployeeVO> getList(EmpCriteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public EmployeeVO get(String empNum) {
		return mapper.read(empNum);
	}

	@Override
	public boolean modify(EmployeeVO emp) {
		return mapper.update(emp)==1;
	}

	@Override
	public boolean remove(String empNum) {
		mapper.authdelete(empNum);
		return mapper.delete(empNum)==1;
	}

	@Override
	public int getTotal(EmpCriteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<EmployeeVO> empEmailSend() {
		log.info("휴가 촉진 대상 리스트 출력(서비스)");
		return mapper.empEmailSend();
	}

}
