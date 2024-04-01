package org.hs.domain;

import lombok.Data;

@Data
public class EmployeeVO {//사원객체

	private int empNum; //사원 번호
	private String empName; //사원 이름
	private int deptNum; //부서
}
