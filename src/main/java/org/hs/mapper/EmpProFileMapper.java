package org.hs.mapper;

import java.util.List;

import org.hs.domain.EmpAttachVO;
import org.hs.domain.EmployeeVO;

public interface EmpProFileMapper {
	
	public List<EmpAttachVO> empProFile(String empNum);
	public int insertProFile(EmpAttachVO vo);
	
	
	
	
	
}
