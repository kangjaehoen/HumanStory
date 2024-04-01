package org.hs.controller;

import org.hs.domain.AuthVO;
import org.hs.domain.EmpCriteria;
import org.hs.domain.EmployeeVO;
import org.hs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/emp/*")
@Log4j
public class AuthController {
	@Autowired
	private EmpService service;
//	@RequestParam("selectedEmpNum") String selectedEmpNum
//	 @PostMapping("/authGive")
//	    public String giveAuth(@RequestParam("selectedAuth") String selectedAuth,@RequestParam("empNum") String empNum) {
//	        // ���⼭ ���õ� ������ �̿��Ͽ� �����ͺ��̽��� ���� �Է��ϰ�,
//	        // �ٸ� ó���� �����մϴ�.
//		 log.info("Received empNum: " + empNum);
//	        AuthVO vo = new AuthVO();
//	        vo.setEmpNum(empNum); // ���÷� ����� "5"�� ���� ����� ���̵�� ����
//	        vo.setAuth(selectedAuth);
//	        
//	        service.authGive(vo);
//
//	        return "redirect:/emp/list"; // ó���� �Ϸ�� �Ŀ��� �����̷�Ʈ�� �������� �����մϴ�.
//	    }
	
}
