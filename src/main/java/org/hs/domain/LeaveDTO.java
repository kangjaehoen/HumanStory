package org.hs.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
@Data
public class LeaveDTO {
	private Long leaveNum;// 휴가 신청 번호
	private Date startDate;// 휴가 시작 날짜
	private Date endDate;// 휴가 종료 날짜
	private Date requestDate;// 휴가 신청 날짜
    private Date updateDate;//휴가 수정 날짜
	private double leaveDays; // 휴가 신청한 총 일수
	private String leaveReason;// 휴가 사유
	private int empNum; // Employee Foreign Key
	private String leaveType; // Personal Foreign Key
	
}
