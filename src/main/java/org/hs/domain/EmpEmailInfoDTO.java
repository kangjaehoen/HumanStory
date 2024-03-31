package org.hs.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmpEmailInfoDTO {
	private String empName;
	private String email;
	private int annualLeaveNum;
}
