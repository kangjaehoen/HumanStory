package org.hs.domain;

import lombok.Data;

@Data
public class PersonalLeaveDayVO {//휴가 종류에 대한 개인 휴가 일수 객체
	
	private String leaveType;//휴가 유형
	private double lt_days;//휴가 유형에 따른 휴가 일수 표현
	
	// 휴가 신청 시 연차 일수를 감소시키는 메서드
    public void decreaseLeaveDays(double leaveDays) {
        this.lt_days -= leaveDays;
    }
    
    // 휴가 취소 시 연차 일수를 증가시키는 메서드
    public void increaseLeaveDays(double leaveDays) {
        this.lt_days += leaveDays;
    }
    

}
