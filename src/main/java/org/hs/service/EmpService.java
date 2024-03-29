package org.hs.service;

import java.util.List;

import org.hs.domain.AuthVO;
import org.hs.domain.EmpCriteria;
import org.hs.domain.EmployeeVO;


public interface EmpService {
	
	public void register(EmployeeVO emp);
	
	public List<EmployeeVO> getList(EmpCriteria cri);
	
	public EmployeeVO get(String empNum);
	public AuthVO authGet(String empNum);
		
	public boolean modify(EmployeeVO emp);
	String empNum="";
	int empnum=Integer.parseInt(empNum);
	public boolean remove(String empnum);
	
	public int getTotal(EmpCriteria cri);
	
	public boolean authGive(AuthVO auth);

}
