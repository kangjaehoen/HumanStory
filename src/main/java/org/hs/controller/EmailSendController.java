package org.hs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender; 
import org.hs.domain.Criteria;
import org.hs.domain.EmpEmailInfoDTO;
import org.hs.domain.EmployeeVO;
import org.hs.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/email/*")
@Log4j
public class EmailSendController {
	@Autowired
	private EmpService empservice; 
	@Autowired
    private JavaMailSender mailSender;
	
@GetMapping("/list")
public void empEmailList(Model model, Criteria cri) {
	log.info("휴가 촉진 대상 리스트");
	model.addAttribute("list", empservice.empEmailSend());

}

@RequestMapping("/emailSend")
@ResponseBody
public Map findAuth(EmpEmailInfoDTO dto, Model model) {
		
	Map map = new HashMap();
	
	 StringBuilder sb = new StringBuilder();
	 
	  String setFrom = "gjsdms3340@gmail.com";
	  String tomail = dto.getEmail();
	  String title = "휴가 잔여 촉구 안내 이메일입니다.";
	  sb.append(String.format("안녕하세요 %s님\n", dto.getEmpName()));
	  sb.append(String.format("휴가 잔여일은 %d 일입니다.", dto.getAnnualLeaveNum()));
	  String content = sb.toString();
	
	  try {
		  MimeMessage msg = mailSender.createMimeMessage();
          MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
          
          msgHelper.setFrom(setFrom);
          msgHelper.setTo(tomail);
          msgHelper.setSubject(title);
          msgHelper.setText(content);
		  
          mailSender.send(msg);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	  map.put("status", true);
      map.put("name", dto.getEmpName());
      map.put("leaveNum", dto.getAnnualLeaveNum()); 
	  
      return map;
	}
}

