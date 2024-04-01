package org.hs.domain;



import java.util.Date;

import lombok.Data;

@Data
public class addLeavesDTO {
	private int empNum;
	private int deptNum;
	private Date startDate;
	private Date endDate;
	private String leaveType;
	private String leaveReason;
	
}
