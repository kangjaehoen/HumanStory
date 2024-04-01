package org.hs.domain;

import java.util.List;

import lombok.Data;
@Data
public class LeaveAndEmployeeVO {
	private List<LeaveVO2> leaveList;
    private List<EmployeeVO2> employeeList;

}
