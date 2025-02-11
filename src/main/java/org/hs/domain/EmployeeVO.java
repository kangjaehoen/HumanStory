package org.hs.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeVO {
   private String empNum;
   private String empName;
   private String pw;
   private String job; 
   private int phoneNum;
   private Date hireDate;
   private String email;
   private int annualLeaveNum;
   private String address;
   private int workDate; 
   private int birthDate;
   private int adminNum;
   private int authNum;
   private int deptNum;
   private  List<DeptVO>  department; 
   private boolean enabled;
   private List<AuthVO> authList;
   private List<LeaveRecordsVO> leaveRecords;
   private List<EmpAttachVO> empAttach;

 
   
}



