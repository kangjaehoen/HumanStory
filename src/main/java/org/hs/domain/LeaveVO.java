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
/*----------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class LeaveCalculator {

    public void calculateLeaveDays(Date startDate, Date endDate, String leaveType, double leaveDays) {
        int totalLeaveDays = 0;
        
        // 휴가 시작일과 종료일이 같은 경우
        if (startDate.equals(endDate)) {
            totalLeaveDays = 1;
        } else {
            // 휴가 시작일부터 종료일까지 반복하여 휴가 일수를 계산
            for (
            		Date date = startDate; 
            		date.before(endDate); 
            		date = addDay(date)) {
                totalLeaveDays++;
            }
            
            // 휴가 유형이 반차 또는 반반차인 경우
            if (leaveType.equals("반차") || leaveType.equals("반반차")) {
                totalLeaveDays = adjustLeaveDays(totalLeaveDays, leaveDays);
            }
        }
        
        System.out.println("Total Leave Days: " + totalLeaveDays);
    }

        public Date addDay(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 1); // 현재 날짜에 하루를 더함
            return calendar.getTime(); // 새로운 날짜를 반환
        }
        ----------------------------------------------------------------------------------------------------------------------------------------------------------------
    // 휴가 일수를 계산하는 메서드
    public static double calculateLeaveDays(LocalDate startDate, LocalDate endDate) {
        // 시작일과 종료일 사이의 일수를 계산
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        
        // 휴가 일수를 계산하여 반환
        return daysBetween + 1; // 시작일과 종료일을 포함하기 위해 1을 더함
    }
    
    // 메인 메서드에서 사용 예시
    public static void main(String[] args) {
        // 휴가 시작일과 종료일 설정
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 3);
        
        // 휴가 일수 계산
        double leaveDays = calculateLeaveDays(startDate, endDate);
        
        // 결과 출력
        System.out.println("휴가 일수: " + leaveDays);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------
public double calculateRemainingLeaveDays(Employee employee) {
    double remainingLeaveDays = employee.getRemainingLeaveDays();
    List<LeaveVO> leaveRequests = employee.getLeaveRequests();
    
    for (LeaveVO leaveRequest : leaveRequests) {
        LocalDate startDate = leaveRequest.getStartDate();
        LocalDate endDate = leaveRequest.getEndDate();
        String leaveType = leaveRequest.getLeaveType();
        
        // 휴가 시작일부터 종료일까지 각 날짜에 대해 휴가 유형에 따른 휴가 일수를 적용
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            switch (leaveType) {
                case "연차":
                    remainingLeaveDays -= 1;
                    break;
                case "반차":
                    remainingLeaveDays -= 0.5; // 반차는 0.5일로 계산
                    break;
                // 다른 휴가 유형에 대한 처리도 추가할 수 있음
                default:
                    break;
            }
        }
    }
    
    return remainingLeaveDays;
}

//Controller에서 호출하는 메서드
@GetMapping("/remaining_leave_days")
public String showRemainingLeaveDays(Model model) {
 // 현재 로그인한 사용자의 정보를 가져옴 (예: 세션에서)
 Employee employee = getCurrentEmployee(); // 이 메서드는 현재 로그인한 사용자를 가져오는 로직
 
 // 휴가 잔여 일수를 계산
 double remainingLeaveDays = calculateRemainingLeaveDays(employee);
 
 // View에 휴가 잔여 일수 전달
 model.addAttribute("remainingLeaveDays", remainingLeaveDays);
 
 // 휴가 잔여 일수를 표시하는 View 페이지 반환
 return "remaining_leave_days";
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------
public double calculateRemainingLeaveDays(Employee employee) {
    double totalLeaveDays = 0;
    
    // 사원의 휴가 신청 내역을 가져옴
    List<LeaveVO> leaveRequests = employee.getLeaveRequests();
    
    // 사원의 휴가 신청 내역을 반복하면서 휴가 일수를 더함
    for (LeaveVO leaveRequest : leaveRequests) {
        totalLeaveDays += leaveRequest.getLeaveDays();
    } 
    
    // 사원의 휴가 잔여 일수를 계산하여 반환
    double remainingLeaveDays = employee.getAnnualLeaveDays() - totalLeaveDays;
    return remainingLeaveDays;
}


----------------------------------------------------------------------------------------------------------------------------------------------------------------

public double calculateRemainingLeaveDays(Employee employee) {
    double remainingLeaveDays = 0;
    
    // 휴가 유형별로 사용한 휴가 일수를 저장할 Map
    Map<String, Double> leaveDaysByType = new HashMap<>();
    
    // 사원의 휴가 신청 내역을 가져옴
    List<LeaveVO> leaveRequests = employee.getLeaveRequests();
    
    // 휴가 신청 내역을 반복하면서 휴가 유형별로 사용한 휴가 일수를 계산
    for (LeaveVO leaveRequest : leaveRequests) {
        String leaveType = leaveRequest.getLeaveType();
        double leaveDays = leaveRequest.getLeaveDays();
        
        // 해당 휴가 유형에 대한 사용한 휴가 일수를 더함
        double totalLeaveDays = leaveDaysByType.getOrDefault(leaveType, 0.0);
        leaveDaysByType.put(leaveType, totalLeaveDays + leaveDays);
    }
    
    // 휴가 유형별로 지정된 총 일수에서 사용한 휴가 일수를 뺌
    for (Map.Entry<String, Double> entry : leaveDaysByType.entrySet()) {
        String leaveType = entry.getKey();
        double usedLeaveDays = entry.getValue();
        
        // 휴가 유형별로 지정된 총 일수를 가져옴 (예: 연차는 15일)
        double totalLeaveDaysByType = getTotalLeaveDaysByType(leaveType);
        
        // 휴가 잔여 일수를 계산하여 더함
        remainingLeaveDays += totalLeaveDaysByType - usedLeaveDays;
    }
    
    return remainingLeaveDays;
}

// 휴가 유형별로 지정된 총 일수를 반환하는 메서드 (예: 연차는 15일)
private double getTotalLeaveDaysByType(String leaveType) {
    // 휴가 유형에 따라 지정된 총 일수를 반환
    double totalLeaveDays = 0;
    
    // 예를 들어, 연차는 15일로 지정되어야 함
    if (leaveType.equals("연차")) {
        totalLeaveDays = 1;
    }
    // 반차의 경우 0.5일로 지정되어야 함
    else if (leaveType.equals("반차")) {
        totalLeaveDays = 0.5;
    }
    // 반반차의 경우 0.25일로 지정되어야 함
    else if (leaveType.equals("반반차")) {
        totalLeaveDays = 0.25;
    }
    // 추가적으로 다른 휴가 유형이 있다면 해당 유형에 대한 처리를 여기에 추가
    
    return totalLeaveDays;
}

}

----------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// 휴가 신청 내역을 담는 VO 클래스
class LeaveVO {
    private LocalDate startDate; // 휴가 시작일
    private LocalDate endDate; // 휴가 종료일
    private String leaveType; // 휴가 유형
    private double leaveDays; // 휴가 일수

    // 생성자, 게터, 세터는 생략
}

// 휴가 서비스 클래스
public class LeaveService {

    // 휴가 유형별로 지정된 총 일수를 반환하는 메서드
    public int getTotalLeaveDays(String leaveType) {
        int totalLeaveDays = 0;
        // 휴가 유형에 따라 총 일수를 설정
        switch (leaveType) {
            case "연차":
                totalLeaveDays = 1;
                break;
            case "반차":
                totalLeaveDays = 0.5; // 반차의 경우, 실제 휴가 유형에 따라 일수가 다를 수 있음
                break;
            // 다른 휴가 유형에 대한 처리를 추가
            default:
                // 기본값으로 설정할 경우
                totalLeaveDays = 0;
                break;
        }
        return totalLeaveDays;
    }

    // 휴가 잔여 일수를 계산하는 메서드
    public int calculateRemainingLeaveDays(List<LeaveVO> leaveRequests) {
        int remainingLeaveDays = 0;
        for (LeaveVO leaveRequest : leaveRequests) {
            LocalDate startDate = leaveRequest.getStartDate();
            LocalDate endDate = leaveRequest.getEndDate();
            String leaveType = leaveRequest.getLeaveType();
            double leaveDays = leaveRequest.getLeaveDays();

            int totalLeaveDays = getTotalLeaveDays(leaveType);

            // 휴가 신청 일수를 휴가 유형별 지정된 일수에서 빼기
            remainingLeaveDays += totalLeaveDays - leaveDays;
        }
        return remainingLeaveDays;
    }

    public static void main(String[] args) {
        // 실제 휴가 신청 내역을 LeaveVO 객체 리스트에 담음
        List<LeaveVO> leaveRequests = new ArrayList<>();
        // leaveRequests에 LeaveVO 객체 추가하는 코드를 작성

        // LeaveService 객체 생성
        LeaveService leaveService = new LeaveService();
        // 휴가 잔여 일수 계산
        int remainingLeaveDays = leaveService.calculateRemainingLeaveDays(leaveRequests);
        System.out.println("휴가 잔여 일수: " + remainingLeaveDays);
    }
}
*/