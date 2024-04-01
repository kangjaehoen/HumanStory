package org.hs.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

//aspect 사용해야함
//휴가 신청만되고 
//휴가 잔여일수가 -1이 안되는 경우가 발생 할 수 있어서
//트랜잭션 무조건 필요
public class LeaveVO { // 휴가 신청 객체
	
	private Long leaveNum;// 휴가 신청 번호
	private Date startDate;// 휴가 시작 날짜
	private Date endDate;// 휴가 종료 날짜
	private Date requestDate;// 휴가 신청 날짜
    private Date updateDate;//휴가 수정 날짜
	private double leaveDays; // 휴가 신청한 총 일수
	private String leaveReason;// 휴가 사유
	private int empNum; // Employee Foreign Key
	private String leaveType; // Personal Foreign Key
	
	public LeaveVO () {}
	public LeaveVO(Long leaveNum, Date startDate, Date endDate, Date requestDate, Date updateDate, double leaveDays,
			String leaveReason, int empNum, String leaveType) {
		super();
		this.leaveNum = leaveNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requestDate = requestDate;
		this.updateDate = updateDate;
		this.leaveDays = leaveDays;
		this.leaveReason = leaveReason;
		this.empNum = empNum;
		this.leaveType = leaveType;
	}

	@Override
	public String toString() {
		return "LeaveVO [leaveNum=" + leaveNum + ", startDate=" + startDate + ", endDate=" + endDate + ", requestDate="
				+ requestDate + ", updateDate=" + updateDate + ", leaveDays=" + leaveDays + ", leaveReason="
				+ leaveReason + ", empNum=" + empNum + ", leaveType=" + leaveType + "]";
	}
	public Long getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(Long leaveNum) {
		this.leaveNum = leaveNum;
	}

	public String getStartDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String startFormattedDate = formatter.format(startDate);

		return startFormattedDate;
	}
	public String getEndDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String endFormattedDate = formatter.format(endDate);
		
		return endFormattedDate;
	}
	public String getRequestDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String requestFormattedDate = formatter.format(requestDate);
		
		return requestFormattedDate;
	}
	public String getupdateDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String updateFormattedDate = formatter.format(updateDate);
		
		return updateFormattedDate;
	}
	

	public void setStartDate(String startDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            this.startDate = formatter.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // ParseException 처리
        }
    }

    public void setEndDate(String endDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            this.endDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
            // ParseException 처리
        }
    }
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public double getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(double leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	

}
