package org.hs.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.hs.domain.AuthVO;
import org.hs.domain.EmployeeVO;
import org.hs.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml", })
@Log4j
public class EmployeeTests {
	@Autowired
	private PasswordEncoder pwencoder;

	@Autowired
	private DataSource ds;

//	@Test
//	public void testInsertEmp() {
//		String sql = "INSERT INTO employee (EMPNUM, EMPNAME, JOB, PHONENUM, HIREDATE, EMAIL, ANNUALLEAVENUM,"
//				+ " ADDRESS, WORKDATE, BIRTHDATE, ADMINNUM, AUTHNUM,DEPTNUM,PW) "
//				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(sql);
//
//			pstmt.setString(1, "18-73039089"); // EMPN
//			pstmt.setString(2, "아이유"); // EMPNAME
//			pstmt.setString(3, "가수"); // JOB
//			pstmt.setString(4, "01073334555"); // PHONENUM
//			pstmt.setString(5, "2019-04-02"); // HIREDATE
//			pstmt.setString(6, "gjsdms1244@gmail.com"); // EMAIL
//			pstmt.setInt(7, 15); // ANNUALLEAVENUM
//			pstmt.setString(8, "서울시 성북구"); // ADDRESS
//			pstmt.setString(9, "121"); // WORKDATE
//			pstmt.setString(10, "930101"); // BIRTHDATE
//			pstmt.setInt(11, 1); // ADMINNUM
//			pstmt.setInt(12, 1); // AUTHNUM
//			pstmt.setInt(13, 1); // DEPTNUM
//			pstmt.setString(14, pwencoder.encode("1")); // PW
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (Exception e) {
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//					}
//				}
//
//			}
//		}
//	}
//}
	
	@Test
	public void testInsertEMPAuth() {
		String sql = "insert into EMPLOYEE_AUTH (EMPNUM, auth) values(?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "18-73039089");
			pstmt.setString(2, "ROLE_ADMIN");

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}

		}
	}
}

//	
//	@Autowired
//	private EmpMapper mapper;
//	
//	@Test
//	public void testRead() {
//		
//		EmployeeVO vo = mapper.authread("11");
//		log.info(vo);
//		vo.getAuthList().forEach(authVO-> log.info(authVO));
//	}
//	
