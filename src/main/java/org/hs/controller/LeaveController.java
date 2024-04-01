package org.hs.controller;

import org.hs.domain.Criteria;
import org.hs.domain.LeaveDTO;
import org.hs.domain.LeaveVO;
import org.hs.domain.PageDTO;
import org.hs.service.LeaveService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/leave/*")
@Log4j
@AllArgsConstructor //오토 와이어 대신
public class LeaveController {

	private LeaveService service;
	
	
	@PostMapping("/register")
	public String register(LeaveDTO leave,RedirectAttributes rttr)throws Exception {
		log.info("=================="+leave);
		log.info("register : "+leave);
		try {
			service.registerLeave(leave);
			rttr.addFlashAttribute("result", leave.getLeaveNum()); //값을 담아갈때
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/leave/calendar";
	}
	
	 @GetMapping("/calendar")
	    public String list(Model model) {
	        log.info("request....");
	        //model.addAttribute("list",service.getLeaveAndEmployee());
	        model.addAttribute("list", service.getLeaveCharts()); // 이벤트 데이터를 모델에 추가
	        return "/leave/calendar"; // 해당 JSP 페이지 이름 반환
	    }
//	 @GetMapping("/calendar")
//	 public String list(Model model) {
//		 log.info("request....");
//		 //model.addAttribute("list",service.getLeaveAndEmployee());
//		 model.addAttribute("list", service.getListLE()); // 이벤트 데이터를 모델에 추가
//		 
//		 log.info("MMMMMMMMMMMMMMMM"+service.getListLE());
//		 return "/leave/calendar"; // 해당 JSP 페이지 이름 반환
//	 }
	
//	@GetMapping({"/request","/calendar"})
//	public void list(Criteria cri, Model model) {
//		log.info("request....");
//		model.addAttribute("list", service.getLeaveCharts(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotalCount(cri)));
//	}
//	
	
//	 @GetMapping(value = {"/leave/request", "/leave/calendar"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	    public void list(@RequestParam("cri") Criteria cri, Model model) {
//	        log.info("request....");
//	        model.addAttribute("list", service.getLeaveCharts(cri));
//	        model.addAttribute("pageMaker", new PageDTO(cri, service.getTotalCount(cri)));
//	    }
	
//	@GetMapping(value = {"/leave/calendarTest"} , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> list(Criteria cri) {
//	   log.info("request....");
//	   return ResponseEntity.ok(service.getLeaveCharts(cri));
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping({"/getLeaveOne","/modify"}) 
	public void get(@RequestParam("leaveNum") Long leaveNum,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("getLeaveOne or / modify....");
		model.addAttribute("leave", service.getLeaveOne(leaveNum));
		}
	
	@PostMapping("/modify")
		public String modify(LeaveDTO leave, RedirectAttributes rttr) {
			log.info("수정 컨트롤러:"+ leave);
			
			if(service.modifyLeave(leave)) {
				rttr.addFlashAttribute("result", "success");
			}
			
			return "redirect:/leave/calendar";
		}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("leaveNum") Long leaveNum, RedirectAttributes rttr) {
		log.info("remove : "+ leaveNum);
		
		if(service.removeLeave(leaveNum)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/leave/calendar";
	}
	

}