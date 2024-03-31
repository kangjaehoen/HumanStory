package org.hs.service;

import java.util.List;

import org.hs.domain.EmpAttachVO;

public interface EmpProFileService {
	
	public List<EmpAttachVO> empProFile(String empNum);
	
	public int insertProFile(EmpAttachVO vo);
}
