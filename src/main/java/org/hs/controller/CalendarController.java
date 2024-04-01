package org.hs.controller;

import org.hs.domain.CalendarVO;
import org.hs.domain.addLeavesDTO;
import org.hs.service.CalendarService;
import org.hs.service.addLeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/")
@Log4j
@AllArgsConstructor
public class CalendarController {

	private CalendarService service;
	private addLeaveService addLeaveService;
	
	@GetMapping("/addLeaves")
	public void register() {}
	
	@PostMapping("/addLeaves")
	public String addLeaves(addLeavesDTO leaves) {
		log.info("..............." + leaves);
		addLeaveService.addLeaves(leaves);
		
		return "/addLeaves";
	}
	
	@GetMapping("/main")
	public void main() {}
	
	
	
	
}
