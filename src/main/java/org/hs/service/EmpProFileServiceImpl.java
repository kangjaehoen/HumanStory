package org.hs.service;

import java.util.List;

import org.hs.domain.EmpAttachVO;
import org.hs.domain.EmployeeVO;
import org.hs.mapper.EmpProFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class EmpProFileServiceImpl implements EmpProFileService {
	@Autowired
	private EmpProFileMapper mapper;
	
	@Override
	public List<EmpAttachVO> empProFile(String empNum) {
		log.info("서비스 사원 프로필 조회"+empNum);
		return mapper.empProFile(empNum);
	}

	@Override
	public int insertProFile(EmpAttachVO vo) {
		log.info("서비스, 사원 프로필 등록"+vo);	
		return mapper.insertProFile(vo);
	}
	
	

	
}
